package com.tencent.luan.core;

import java.util.Iterator;

class TreeNode$1
  implements Iterator<E>
{
  TreeNode<E> node = this.rootNode;
  TreeNode<E> rootNode = this.this$0;
  
  TreeNode$1(TreeNode paramTreeNode) {}
  
  private SingleLinkedListNode<TreeNode<E>> getNextLinkedNode(SingleLinkedListNode<TreeNode<E>> paramSingleLinkedListNode)
  {
    if (paramSingleLinkedListNode.hasNext()) {
      return paramSingleLinkedListNode.next();
    }
    paramSingleLinkedListNode = TreeNode.access$200((TreeNode)paramSingleLinkedListNode.element);
    if (paramSingleLinkedListNode == null) {
      return null;
    }
    return getNextLinkedNode(paramSingleLinkedListNode);
  }
  
  public boolean hasNext()
  {
    return this.node != null;
  }
  
  public E next()
  {
    Object localObject2 = this.node.element;
    if (TreeNode.access$000(this.node) != null)
    {
      this.node = ((TreeNode)TreeNode.access$000(this.node).element);
      return localObject2;
    }
    Object localObject1 = getNextLinkedNode(TreeNode.access$100(this.node));
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (TreeNode)((SingleLinkedListNode)localObject1).element)
    {
      this.node = ((TreeNode)localObject1);
      return localObject2;
    }
  }
  
  public void remove()
  {
    throw new IllegalArgumentException("wrong call");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.luan.core.TreeNode.1
 * JD-Core Version:    0.7.0.1
 */