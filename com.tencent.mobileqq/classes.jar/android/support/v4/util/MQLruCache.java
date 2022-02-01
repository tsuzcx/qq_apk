package android.support.v4.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MQLruCache<K, O>
{
  public static final byte HIGH = 2;
  public static final byte LOW = 0;
  private static final byte MAX_QUEUE = 3;
  public static final byte NORMAL = 1;
  private static final int RISE_PRIORITY_COUNT = 128;
  private int LARGE_SIZE = -1;
  private final HashSet<K> largeSizeItem = new HashSet();
  private int[] maxSizes = null;
  private AsyncLruCache<K, MQLruCache<K, O>.CacheItem>[] mqCaches = null;
  private ArrayList<Pair<K, MQLruCache<K, O>.CacheItem>>[] oldValues = null;
  
  public MQLruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mqCaches = new AsyncLruCache[3];
      this.oldValues = new ArrayList[3];
      this.maxSizes = new int[3];
      localObject = this.maxSizes;
      int j = paramInt * 5 / 10;
      int i = 0;
      localObject[0] = j;
      localObject[1] = (paramInt * 4 / 10);
      localObject[2] = (paramInt * 1 / 10);
      paramInt = i;
      while (paramInt < 3)
      {
        this.oldValues[paramInt] = new ArrayList();
        this.mqCaches[paramInt] = new MQLruCache.1(this, this.maxSizes[paramInt], paramInt);
        paramInt += 1;
      }
      return;
    }
    Object localObject = new IllegalArgumentException("maxSize <= 0");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final O put(K paramK, MQLruCache<K, O>.CacheItem paramMQLruCache)
  {
    try
    {
      j = paramMQLruCache.priority;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int j;
        int i;
        for (;;)
        {
          throw paramK;
        }
        label210:
        i += 1;
      }
    }
    if (i < 3) {
      if ((i == j) || ((MQLruCache.CacheItem)this.mqCaches[i].remove(paramK) == null)) {
        break label210;
      }
    }
    this.mqCaches[j].put(paramK, paramMQLruCache);
    for (i = j; (i > 0) && (this.oldValues[i].size() > 0); i = (byte)(i - 1))
    {
      j = 0;
      while (j < this.oldValues[i].size())
      {
        paramK = (Pair)this.oldValues[i].get(j);
        MQLruCache.CacheItem localCacheItem = (MQLruCache.CacheItem)paramK.second;
        localCacheItem.priority = ((byte)(localCacheItem.priority - 1));
        ((MQLruCache.CacheItem)paramK.second).hitCount = 0;
        this.mqCaches[((MQLruCache.CacheItem)paramK.second).priority].put(paramK.first, paramK.second);
        j += 1;
      }
      this.oldValues[i].clear();
    }
    paramK = paramMQLruCache.value;
    return paramK;
  }
  
  public final int cacheCount()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].cacheCount();
        j += k;
        i += 1;
      }
      finally {}
    }
    return j;
  }
  
  protected void entryObjRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2) {}
  
  public final void evict(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if ((i <= paramInt) && (i < 3)) {}
      try
      {
        this.mqCaches[i].evictAll();
        this.oldValues[i].clear();
        i += 1;
      }
      finally {}
    }
  }
  
  public final void evictAll()
  {
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        this.mqCaches[i].evictAll();
        this.oldValues[i].clear();
        i += 1;
      }
      finally {}
    }
  }
  
  public final O get(K paramK)
  {
    MQLruCache.CacheItem localCacheItem1 = null;
    int i = 0;
    for (;;)
    {
      MQLruCache.CacheItem localCacheItem2 = localCacheItem1;
      if (i <= 2) {}
      label129:
      try
      {
        localCacheItem1 = (MQLruCache.CacheItem)this.mqCaches[i].get(paramK);
        if (localCacheItem1 == null) {
          break label129;
        }
        localCacheItem1.hitCount += 1;
        localCacheItem2 = localCacheItem1;
        if (localCacheItem1.hitCount >= 128)
        {
          localCacheItem2 = localCacheItem1;
          if (localCacheItem1.priority < 2)
          {
            this.mqCaches[i].remove(paramK);
            localCacheItem1.priority = ((byte)(localCacheItem1.priority + 1));
            localCacheItem1.hitCount = 0;
            put(paramK, localCacheItem1);
            localCacheItem2 = localCacheItem1;
          }
        }
        if (localCacheItem2 == null) {
          break label125;
        }
        paramK = localCacheItem2.value;
        return paramK;
      }
      finally
      {
        label121:
        label125:
        break label121;
      }
      throw paramK;
      return null;
      i += 1;
    }
  }
  
  public ArrayList<K> getLargeCache()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.largeSizeItem.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localIterator.next());
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final int hitCount()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].hitCount();
        j += k;
        i += 1;
      }
      finally {}
    }
    return j;
  }
  
  public final int maxSize()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].maxSize();
        j += k;
        i += 1;
      }
      finally {}
    }
    return j;
  }
  
  public final int missCount()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].missCount();
        j += k;
        i += 1;
      }
      finally {}
    }
    return j;
  }
  
  public O put(K paramK, O paramO)
  {
    return put(paramK, new MQLruCache.CacheItem(this, paramO, (byte)1));
  }
  
  public O put(K paramK, O paramO, byte paramByte)
  {
    byte b;
    if (paramByte >= 0)
    {
      b = paramByte;
      if (paramByte <= 2) {}
    }
    else
    {
      b = 0;
    }
    return put(paramK, new MQLruCache.CacheItem(this, paramO, b));
  }
  
  public void releaseLargeCache()
  {
    try
    {
      int i = this.largeSizeItem.size();
      if (i == 0) {
        return;
      }
      ArrayList localArrayList = getLargeCache();
      i = 0;
      while (i < localArrayList.size())
      {
        remove(localArrayList.get(i));
        i += 1;
      }
      this.largeSizeItem.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final O remove(K paramK)
  {
    int i = 0;
    MQLruCache.CacheItem localCacheItem = null;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        localCacheItem = (MQLruCache.CacheItem)this.mqCaches[i].remove(paramK);
        if (localCacheItem == null) {
          break label53;
        }
        if (localCacheItem == null) {
          break label49;
        }
        paramK = localCacheItem.value;
        return paramK;
      }
      finally
      {
        label45:
        break label45;
      }
      throw paramK;
      label49:
      return null;
      label53:
      i += 1;
    }
  }
  
  public final void resetMaxSize(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        this.maxSizes[i] = ((int)(this.maxSizes[i] * paramFloat));
        this.mqCaches[i].resetMaxSize(this.maxSizes[i]);
        i += 1;
      }
      finally {}
    }
  }
  
  public void setLargeSize(int paramInt)
  {
    this.LARGE_SIZE = paramInt;
    if (this.LARGE_SIZE <= 0) {
      this.largeSizeItem.clear();
    }
  }
  
  public final int size()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        int k = this.mqCaches[i].size();
        j += k;
        i += 1;
      }
      finally {}
    }
    return j;
  }
  
  protected int sizeOfObj(K paramK, O paramO)
  {
    return 1;
  }
  
  public final Map<K, O> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      Object localObject2 = new LinkedHashMap();
      int i = 0;
      while (i < 3)
      {
        ((Map)localObject2).putAll(this.mqCaches[i].snapshot());
        i += 1;
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localLinkedHashMap.put(localEntry.getKey(), ((MQLruCache.CacheItem)localEntry.getValue()).value);
      }
      return localLinkedHashMap;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public final void trimToSize(int paramInt)
  {
    try
    {
      int i = size();
      if (i <= paramInt) {
        return;
      }
      i -= paramInt;
      paramInt = 0;
      int j;
      do
      {
        j = this.mqCaches[paramInt].size();
        if (j >= i)
        {
          this.mqCaches[paramInt].trimToSize(j - i);
          break;
        }
        this.mqCaches[paramInt].trimToSize(0);
        i -= j;
        j = paramInt + 1;
        if (i <= 0) {
          break;
        }
        paramInt = j;
      } while (j < 3);
      this.oldValues[0].clear();
      this.oldValues[1].clear();
      this.oldValues[2].clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void warningLargeItem(K paramK, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.MQLruCache
 * JD-Core Version:    0.7.0.1
 */