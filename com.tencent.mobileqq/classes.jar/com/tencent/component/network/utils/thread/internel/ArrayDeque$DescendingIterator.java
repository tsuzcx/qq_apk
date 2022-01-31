package com.tencent.component.network.utils.thread.internel;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayDeque$DescendingIterator
  implements Iterator<E>
{
  private int cursor = ArrayDeque.access$300(this.this$0);
  private int fence = ArrayDeque.access$200(this.this$0);
  private int lastRet = -1;
  
  private ArrayDeque$DescendingIterator(ArrayDeque paramArrayDeque) {}
  
  public boolean hasNext()
  {
    return this.cursor != this.fence;
  }
  
  public E next()
  {
    if (this.cursor == this.fence) {
      throw new NoSuchElementException();
    }
    this.cursor = (this.cursor - 1 & ArrayDeque.access$400(this.this$0).length - 1);
    Object localObject = ArrayDeque.access$400(this.this$0)[this.cursor];
    if ((ArrayDeque.access$200(this.this$0) != this.fence) || (localObject == null)) {
      throw new ConcurrentModificationException();
    }
    this.lastRet = this.cursor;
    return localObject;
  }
  
  public void remove()
  {
    if (this.lastRet < 0) {
      throw new IllegalStateException();
    }
    if (!ArrayDeque.access$500(this.this$0, this.lastRet))
    {
      this.cursor = (this.cursor + 1 & ArrayDeque.access$400(this.this$0).length - 1);
      this.fence = ArrayDeque.access$200(this.this$0);
    }
    this.lastRet = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.internel.ArrayDeque.DescendingIterator
 * JD-Core Version:    0.7.0.1
 */