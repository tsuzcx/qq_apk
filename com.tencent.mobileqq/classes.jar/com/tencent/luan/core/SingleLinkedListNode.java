package com.tencent.luan.core;

import java.util.Iterator;

public class SingleLinkedListNode<E>
  extends AbstractNode<E>
{
  private SingleLinkedListNode<E> next;
  
  public SingleLinkedListNode(E paramE)
  {
    super(paramE);
  }
  
  public boolean hasNext()
  {
    return this.next != null;
  }
  
  public Iterator<E> iterator()
  {
    return new SingleLinkedListNode.1(this);
  }
  
  public SingleLinkedListNode<E> next()
  {
    return this.next;
  }
  
  public void setNext(SingleLinkedListNode<E> paramSingleLinkedListNode)
  {
    this.next = paramSingleLinkedListNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.core.SingleLinkedListNode
 * JD-Core Version:    0.7.0.1
 */