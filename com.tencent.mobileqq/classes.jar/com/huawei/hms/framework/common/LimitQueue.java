package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LimitQueue<E>
  extends ConcurrentLinkedQueue<E>
{
  private static final String TAG = "LimitQueue";
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
  
  public void clear()
  {
    super.clear();
  }
  
  public E get(int paramInt)
  {
    Iterator localIterator = iterator();
    Object localObject = null;
    int i = 0;
    while ((i <= paramInt) && (localIterator.hasNext()))
    {
      localObject = localIterator.next();
      i += 1;
    }
    return localObject;
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
  
  public E peekLast()
  {
    Iterator localIterator = iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = localIterator.next()) {}
    return localObject;
  }
  
  public E poll()
  {
    return super.poll();
  }
  
  public E remove()
  {
    try
    {
      Object localObject = super.remove();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      label7:
      break label7;
    }
    Logger.w("LimitQueue", "remove failed, limitQueue is empty");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.LimitQueue
 * JD-Core Version:    0.7.0.1
 */