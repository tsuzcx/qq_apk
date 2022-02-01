package com.nostra13.universalimageloader.core.assist.deque;

class LinkedBlockingDeque$Itr
  extends LinkedBlockingDeque<E>.AbstractItr
{
  private LinkedBlockingDeque$Itr(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    super(paramLinkedBlockingDeque);
  }
  
  LinkedBlockingDeque.Node<E> firstNode()
  {
    return this.this$0.first;
  }
  
  LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
  {
    return paramNode.next;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.Itr
 * JD-Core Version:    0.7.0.1
 */