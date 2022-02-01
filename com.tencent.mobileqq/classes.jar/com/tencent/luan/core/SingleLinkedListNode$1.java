package com.tencent.luan.core;

import java.util.Iterator;

class SingleLinkedListNode$1
  implements Iterator<E>
{
  private SingleLinkedListNode<E> node = this.this$0;
  private boolean shouldReadNext = false;
  
  SingleLinkedListNode$1(SingleLinkedListNode paramSingleLinkedListNode) {}
  
  public boolean hasNext()
  {
    if (this.shouldReadNext) {
      this.node = SingleLinkedListNode.access$000(this.node);
    }
    return this.node != null;
  }
  
  public E next()
  {
    Object localObject = this.node.element;
    this.shouldReadNext = true;
    return localObject;
  }
  
  public void remove()
  {
    throw new IllegalArgumentException("wrong call");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.core.SingleLinkedListNode.1
 * JD-Core Version:    0.7.0.1
 */