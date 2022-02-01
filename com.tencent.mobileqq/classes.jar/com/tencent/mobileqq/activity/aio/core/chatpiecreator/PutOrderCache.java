package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class PutOrderCache<K, V>
  extends LinkedHashMap<K, V>
{
  private int capacity = 2147483647;
  private Map.Entry<K, V> removed;
  
  @Nullable
  public V put(K paramK, V paramV)
  {
    remove(paramK);
    return super.put(paramK, paramV);
  }
  
  @Nullable
  public V putAndGetRemoved(K paramK, V paramV)
  {
    this.removed = null;
    Object localObject = get(paramK);
    put(paramK, paramV);
    paramK = this.removed;
    if (paramK == null)
    {
      if (localObject == paramV) {
        return null;
      }
      return localObject;
    }
    return paramK.getValue();
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    if (size() > this.capacity)
    {
      this.removed = paramEntry;
      return true;
    }
    this.removed = null;
    return false;
  }
  
  public void setCapacity(int paramInt)
  {
    this.capacity = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.PutOrderCache
 * JD-Core Version:    0.7.0.1
 */