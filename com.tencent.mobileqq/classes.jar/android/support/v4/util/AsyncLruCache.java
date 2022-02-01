package android.support.v4.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AsyncLruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public AsyncLruCache(int paramInt)
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
  
  public final int cacheCount()
  {
    LinkedHashMap localLinkedHashMap = this.map;
    if (localLinkedHashMap != null) {
      return localLinkedHashMap.size();
    }
    return 0;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public final int createCount()
  {
    return this.createCount;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    return this.evictionCount;
  }
  
  public final V get(K paramK)
  {
    if (paramK != null)
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
    throw new NullPointerException("key == null");
  }
  
  public final int hitCount()
  {
    return this.hitCount;
  }
  
  public final int maxSize()
  {
    return this.maxSize;
  }
  
  public final int missCount()
  {
    return this.missCount;
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null))
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
    throw new NullPointerException("key == null || value == null");
  }
  
  public final int putCount()
  {
    return this.putCount;
  }
  
  public final V remove(K paramK)
  {
    if (paramK != null)
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
    throw new NullPointerException("key == null");
  }
  
  public final void resetMaxSize(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.maxSize = paramInt;
  }
  
  public final int size()
  {
    return this.size;
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final Map<K, V> snapshot()
  {
    return new LinkedHashMap(this.map);
  }
  
  public final String toString()
  {
    int i = this.hitCount;
    int j = this.missCount + i;
    if (j != 0) {
      i = i * 100 / j;
    } else {
      i = 0;
    }
    return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
  }
  
  public void trimToSize(int paramInt)
  {
    while ((this.size >= 0) && ((!this.map.isEmpty()) || (this.size == 0))) {
      if (this.size > paramInt)
      {
        if (this.map.isEmpty()) {
          return;
        }
        Object localObject2 = (Map.Entry)this.map.entrySet().iterator().next();
        localObject1 = ((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        this.map.remove(localObject1);
        this.size -= safeSizeOf(localObject1, localObject2);
        this.evictionCount += 1;
        entryRemoved(true, localObject1, localObject2, null);
      }
      else
      {
        return;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getClass().getName());
    ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
    localObject1 = new IllegalStateException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.AsyncLruCache
 * JD-Core Version:    0.7.0.1
 */