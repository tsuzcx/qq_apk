package com.nostra13.universalimageloader.core.assist.deque;

class LinkedBlockingDeque$DescendingItr
  extends LinkedBlockingDeque<E>.AbstractItr
{
  private LinkedBlockingDeque$DescendingItr(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    super(paramLinkedBlockingDeque);
  }
  
  LinkedBlockingDeque.Node<E> firstNode()
  {
    return this.this$0.last;
  }
  
  LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
  {
    return paramNode.prev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.DescendingItr
 * JD-Core Version:    0.7.0.1
 */