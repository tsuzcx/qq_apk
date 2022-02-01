package com.tencent.commonsdk.cache;

import android.support.v4.util.LruCache;
import java.util.List;
import java.util.Map;

public class QQLruCache<K, V>
{
  public static IMemoryManager sManager;
  private long createTime;
  private long firstUseTime;
  private int getCount;
  private LruCache<K, V> mCache;
  private int mClearSize;
  private int mItemSize;
  private int removeCount;
  private int subNum;
  public int tagId;
  
  @Deprecated
  public QQLruCache(int paramInt1, int paramInt2)
  {
    init(paramInt1, paramInt2, 1);
  }
  
  public QQLruCache(int paramInt1, int paramInt2, int paramInt3)
  {
    init(paramInt1, paramInt2, paramInt3);
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    this.tagId = paramInt1;
    this.mItemSize = paramInt2;
    this.createTime = System.currentTimeMillis();
    IMemoryManager localIMemoryManager = sManager;
    if (localIMemoryManager != null) {
      localIMemoryManager.addQQLruCache(this);
    }
  }
  
  private void init(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCache = new QQLruCache.1(this, paramInt2, false);
    init(paramInt1, paramInt3);
  }
  
  public static void setManager(IMemoryManager paramIMemoryManager)
  {
    if (paramIMemoryManager != null) {
      sManager = paramIMemoryManager;
    }
  }
  
  public final void clearOnLowMemory(int paramInt)
  {
    try
    {
      int i;
      if (this.subNum > 0)
      {
        i = this.subNum;
        this.mCache.trimToSize(paramInt);
        this.mClearSize = ((i - this.subNum) * this.mItemSize);
      }
      else
      {
        i = this.mCache.size();
        this.mCache.trimToSize(paramInt);
        this.mClearSize = ((i - this.mCache.size()) * this.mItemSize);
      }
      onClearMemory();
      return;
    }
    finally {}
  }
  
  public boolean containsKey(K paramK)
  {
    return this.mCache.get(paramK) != null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public void evictAll()
  {
    this.mCache.evictAll();
    this.subNum = 0;
  }
  
  public V get(K paramK)
  {
    if (this.firstUseTime == 0L) {
      this.firstUseTime = System.currentTimeMillis();
    }
    this.getCount += 1;
    return this.mCache.get(paramK);
  }
  
  public CacheInfo getCacheInfos()
  {
    try
    {
      LruCacheInfo localLruCacheInfo = new LruCacheInfo(this.tagId, this.mCache.maxSize());
      localLruCacheInfo.size = this.mCache.size();
      localLruCacheInfo.mItemSize = this.mItemSize;
      if (this.subNum > 0) {
        localLruCacheInfo.mMemorySize = (this.subNum * this.mItemSize);
      } else {
        localLruCacheInfo.mMemorySize = (localLruCacheInfo.size * this.mItemSize);
      }
      localLruCacheInfo.mClearSize = this.mClearSize;
      localLruCacheInfo.putCount = this.mCache.putCount();
      localLruCacheInfo.getCount = this.getCount;
      localLruCacheInfo.removeCount = this.removeCount;
      localLruCacheInfo.evictionCount = this.mCache.evictionCount();
      localLruCacheInfo.hitCount = this.mCache.hitCount();
      localLruCacheInfo.missCount = this.mCache.missCount();
      localLruCacheInfo.lifeTime = (System.currentTimeMillis() - this.createTime);
      if (this.firstUseTime != 0L) {
        localLruCacheInfo.gapTime = (System.currentTimeMillis() - this.createTime);
      }
      return localLruCacheInfo;
    }
    finally {}
  }
  
  protected void onClearMemory() {}
  
  public V put(K paramK, V paramV)
  {
    if (this.firstUseTime == 0L) {
      this.firstUseTime = System.currentTimeMillis();
    }
    paramK = this.mCache.put(paramK, paramV);
    try
    {
      if ((paramV instanceof List))
      {
        if (paramK != null) {
          this.subNum -= ((List)paramK).size();
        }
        this.subNum += ((List)paramV).size();
      }
      return paramK;
    }
    finally {}
  }
  
  public V remove(K paramK)
  {
    paramK = this.mCache.remove(paramK);
    try
    {
      this.removeCount += 1;
      if ((paramK != null) && ((paramK instanceof List))) {
        this.subNum -= ((List)paramK).size();
      }
      return paramK;
    }
    finally {}
  }
  
  public int size()
  {
    return this.mCache.size();
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public Map<K, V> snapshot()
  {
    try
    {
      Map localMap = this.mCache.snapshot();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.cache.QQLruCache
 * JD-Core Version:    0.7.0.1
 */