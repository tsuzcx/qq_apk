package com.tencent.component.network.utils.thread.internel;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayDeque$DeqIterator
  implements Iterator<E>
{
  private int cursor = ArrayDeque.access$200(this.this$0);
  private int fence = ArrayDeque.access$300(this.this$0);
  private int lastRet = -1;
  
  private ArrayDeque$DeqIterator(ArrayDeque paramArrayDeque) {}
  
  public boolean hasNext()
  {
    return this.cursor != this.fence;
  }
  
  public E next()
  {
    if (this.cursor != this.fence)
    {
      Object localObject = ArrayDeque.access$400(this.this$0)[this.cursor];
      if ((ArrayDeque.access$300(this.this$0) == this.fence) && (localObject != null))
      {
        int i = this.cursor;
        this.lastRet = i;
        this.cursor = (i + 1 & ArrayDeque.access$400(this.this$0).length - 1);
        return localObject;
      }
      throw new ConcurrentModificationException();
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    int i = this.lastRet;
    if (i >= 0)
    {
      if (ArrayDeque.access$500(this.this$0, i))
      {
        this.cursor = (this.cursor - 1 & ArrayDeque.access$400(this.this$0).length - 1);
        this.fence = ArrayDeque.access$300(this.this$0);
      }
      this.lastRet = -1;
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.internel.ArrayDeque.DeqIterator
 * JD-Core Version:    0.7.0.1
 */