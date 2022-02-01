package com.tencent.component.network.module.cache.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject1 = this.map.get(paramK);
        if (localObject1 != null)
        {
          this.hitCount += 1;
          return localObject1;
        }
        this.missCount += 1;
        localObject1 = create(paramK);
        if (localObject1 == null) {
          return null;
        }
        try
        {
          this.createCount += 1;
          Object localObject2 = this.map.put(paramK, localObject1);
          if (localObject2 != null) {
            this.map.put(paramK, localObject2);
          } else {
            this.size += safeSizeOf(paramK, localObject1);
          }
          if (localObject2 != null)
          {
            entryRemoved(false, paramK, localObject1, localObject2);
            return localObject2;
          }
          trimToSize(this.maxSize);
          return localObject1;
        }
        finally {}
        throw new NullPointerException("key == null");
      }
      finally {}
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.putCount += 1;
        this.size += safeSizeOf(paramK, paramV);
        Object localObject = this.map.put(paramK, paramV);
        if (localObject != null) {
          this.size -= safeSizeOf(paramK, localObject);
        }
        if (localObject != null) {
          entryRemoved(false, paramK, localObject, paramV);
        }
        trimToSize(this.maxSize);
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final V remove(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject = this.map.remove(paramK);
        if (localObject != null) {
          this.size -= safeSizeOf(paramK, localObject);
        }
        if (localObject != null) {
          entryRemoved(false, paramK, localObject, null);
        }
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.hitCount + this.missCount;
        if (i != 0)
        {
          i = this.hitCount * 100 / i;
          String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void trimToSize(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.size >= 0) && ((!this.map.isEmpty()) || (this.size == 0)))
        {
          if ((this.size > paramInt) && (!this.map.isEmpty()))
          {
            Object localObject3 = (Map.Entry)this.map.entrySet().iterator().next();
            localObject1 = ((Map.Entry)localObject3).getKey();
            localObject3 = ((Map.Entry)localObject3).getValue();
            this.map.remove(localObject1);
            this.size -= safeSizeOf(localObject1, localObject3);
            this.evictionCount += 1;
            entryRemoved(true, localObject1, localObject3, null);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(getClass().getName());
          ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.cache.common.LruCache
 * JD-Core Version:    0.7.0.1
 */