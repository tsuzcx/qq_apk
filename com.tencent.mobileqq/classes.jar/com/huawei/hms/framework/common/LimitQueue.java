package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.LinkedList;

public class LimitQueue<E>
  extends LinkedList<E>
{
  private static final long serialVersionUID = -4636313759149307798L;
  private boolean deduplication = false;
  private int limit;
  
  public LimitQueue(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public LimitQueue(int paramInt, boolean paramBoolean)
  {
    this.limit = paramInt;
    this.deduplication = paramBoolean;
  }
  
  public LimitQueue(Collection<? extends E> paramCollection, boolean paramBoolean)
  {
    this(paramCollection.size(), paramBoolean);
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (this.deduplication) {
      super.remove(paramE);
    }
    if (super.size() >= this.limit) {
      super.poll();
    }
    return super.add(paramE);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if (paramCollection.size() > this.limit) {
      return false;
    }
    if (this.deduplication) {
      super.removeAll(paramCollection);
    }
    int i = paramCollection.size() + super.size() - this.limit;
    while (i > 0)
    {
      super.poll();
      i -= 1;
    }
    return super.addAll(paramCollection);
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public boolean offer(E paramE)
  {
    if (this.deduplication) {
      super.remove(paramE);
    }
    if (super.size() >= this.limit) {
      super.poll();
    }
    return super.offer(paramE);
  }
  
  public E poll()
  {
    return super.poll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.LimitQueue
 * JD-Core Version:    0.7.0.1
 */