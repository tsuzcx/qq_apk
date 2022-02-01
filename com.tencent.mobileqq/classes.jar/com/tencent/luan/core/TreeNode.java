package com.tencent.luan.core;

import java.util.Iterator;

public class TreeNode<E>
  extends AbstractNode<E>
{
  private SingleLinkedListNode<TreeNode<E>> headChildNode;
  private final SingleLinkedListNode<TreeNode<E>> parentNode;
  private final SingleLinkedListNode<TreeNode<E>> selfNode;
  private SingleLinkedListNode<TreeNode<E>> tailChildNode;
  
  public TreeNode(E paramE)
  {
    this(paramE, null);
  }
  
  private TreeNode(E paramE, SingleLinkedListNode<TreeNode<E>> paramSingleLinkedListNode)
  {
    super(paramE);
    this.parentNode = paramSingleLinkedListNode;
    this.selfNode = new SingleLinkedListNode(this);
  }
  
  public TreeNode<E> addChild(E paramE)
  {
    paramE = new TreeNode(paramE, this.selfNode);
    if (this.tailChildNode == null) {
      this.headChildNode = paramE.selfNode;
    }
    for (;;)
    {
      this.tailChildNode = paramE.selfNode;
      return paramE;
      this.tailChildNode.setNext(paramE.selfNode);
    }
  }
  
  public TreeNode<E> getParent()
  {
    if (this.parentNode == null) {
      return null;
    }
    return (TreeNode)this.parentNode.element;
  }
  
  public Iterator<E> iterator()
  {
    return new TreeNode.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luan.core.TreeNode
 * JD-Core Version:    0.7.0.1
 */