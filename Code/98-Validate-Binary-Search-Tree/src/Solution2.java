import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * <p>
 * 根据BST中序遍历的升序性质也可以验证一棵树是不是BST
 * <p>
 * Created By xxm
 */
public class Solution2 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        
        // 访问当前节点: 如果当前节点小于等于中序遍历的前一个节点,
        // 说明不满足BST, 返回 false; 否则继续遍历.
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }

}
