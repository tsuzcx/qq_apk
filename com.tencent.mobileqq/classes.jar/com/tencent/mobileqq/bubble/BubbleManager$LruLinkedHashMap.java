package com.tencent.mobileqq.bubble;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BubbleManager$LruLinkedHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 1L;
  private final Lock lock = new ReentrantLock();
  protected final int maxCapacity;
  
  public BubbleManager$LruLinkedHashMap(BubbleManager paramBubbleManager, int paramInt)
  {
    super(paramInt, 0.75F, true);
    this.maxCapacity = paramInt;
  }
  
  public void clear()
  {
    try
    {
      this.lock.lock();
      super.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public V get(Object paramObject)
  {
    try
    {
      this.lock.lock();
      paramObject = super.get(paramObject);
      return paramObject;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public V put(K paramK, V paramV)
  {
    try
    {
      this.lock.lock();
      paramK = super.put(paramK, paramV);
      return paramK;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap
 * JD-Core Version:    0.7.0.1
 */