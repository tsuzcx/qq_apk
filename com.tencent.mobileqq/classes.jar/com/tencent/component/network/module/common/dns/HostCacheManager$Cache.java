package com.tencent.component.network.module.common.dns;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class HostCacheManager$Cache<K, V>
  extends LinkedHashMap<K, V>
{
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  private static final long serialVersionUID = -6940751117906094384L;
  private int capacity = 5;
  private Object lock = new Object();
  
  public HostCacheManager$Cache(HostCacheManager paramHostCacheManager, int paramInt)
  {
    super(paramInt, 0.75F, true);
    if (paramInt > 0) {
      this.capacity = paramInt;
    }
  }
  
  public void clear()
  {
    synchronized (this.lock)
    {
      super.clear();
      return;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    synchronized (this.lock)
    {
      boolean bool = super.containsKey(paramObject);
      return bool;
    }
  }
  
  public V get(Object paramObject)
  {
    synchronized (this.lock)
    {
      paramObject = super.get(paramObject);
      return paramObject;
    }
  }
  
  public V put(K paramK, V paramV)
  {
    synchronized (this.lock)
    {
      paramK = super.put(paramK, paramV);
      return paramK;
    }
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    synchronized (this.lock)
    {
      super.putAll(paramMap);
      return;
    }
  }
  
  public V remove(Object paramObject)
  {
    synchronized (this.lock)
    {
      paramObject = super.remove(paramObject);
      return paramObject;
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.capacity;
  }
  
  public int size()
  {
    synchronized (this.lock)
    {
      int i = super.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager.Cache
 * JD-Core Version:    0.7.0.1
 */