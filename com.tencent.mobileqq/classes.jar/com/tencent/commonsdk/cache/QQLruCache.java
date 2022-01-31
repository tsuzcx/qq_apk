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
    if (sManager != null) {
      sManager.addQQLruCache(this);
    }
  }
  
  private void init(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCache = new LruCache(paramInt2, false)
    {
      protected void entryRemoved(boolean paramAnonymousBoolean, K paramAnonymousK, V paramAnonymousV1, V paramAnonymousV2)
      {
        QQLruCache.this.entryRemoved(paramAnonymousBoolean, paramAnonymousK, paramAnonymousV1, paramAnonymousV2);
        if (paramAnonymousBoolean)
        {
          if (paramAnonymousV1 != null) {}
          try
          {
            if ((paramAnonymousV1 instanceof List)) {
              QQLruCache.access$002(QQLruCache.this, QQLruCache.this.subNum - ((List)paramAnonymousV1).size());
            }
            if ((paramAnonymousV2 != null) && ((paramAnonymousV2 instanceof List))) {
              QQLruCache.access$002(QQLruCache.this, QQLruCache.this.subNum + ((List)paramAnonymousV2).size());
            }
            return;
          }
          finally {}
        }
      }
      
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return QQLruCache.this.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
    init(paramInt1, paramInt3);
  }
  
  public static void setManager(IMemoryManager paramIMemoryManager)
  {
    if (paramIMemoryManager != null) {
      sManager = paramIMemoryManager;
    }
  }
  
  /* Error */
  public final void clearOnLowMemory(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/commonsdk/cache/QQLruCache:subNum	I
    //   6: ifle +38 -> 44
    //   9: aload_0
    //   10: getfield 38	com/tencent/commonsdk/cache/QQLruCache:subNum	I
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   18: iload_1
    //   19: invokevirtual 76	android/support/v4/util/LruCache:trimToSize	(I)V
    //   22: aload_0
    //   23: iload_2
    //   24: aload_0
    //   25: getfield 38	com/tencent/commonsdk/cache/QQLruCache:subNum	I
    //   28: isub
    //   29: aload_0
    //   30: getfield 44	com/tencent/commonsdk/cache/QQLruCache:mItemSize	I
    //   33: imul
    //   34: putfield 78	com/tencent/commonsdk/cache/QQLruCache:mClearSize	I
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_0
    //   40: invokevirtual 81	com/tencent/commonsdk/cache/QQLruCache:onClearMemory	()V
    //   43: return
    //   44: aload_0
    //   45: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   48: invokevirtual 85	android/support/v4/util/LruCache:size	()I
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   56: iload_1
    //   57: invokevirtual 76	android/support/v4/util/LruCache:trimToSize	(I)V
    //   60: aload_0
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   66: invokevirtual 85	android/support/v4/util/LruCache:size	()I
    //   69: isub
    //   70: aload_0
    //   71: getfield 44	com/tencent/commonsdk/cache/QQLruCache:mItemSize	I
    //   74: imul
    //   75: putfield 78	com/tencent/commonsdk/cache/QQLruCache:mClearSize	I
    //   78: goto -41 -> 37
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	QQLruCache
    //   0	86	1	paramInt	int
    //   13	57	2	i	int
    //   81	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	81	finally
    //   37	39	81	finally
    //   44	78	81	finally
    //   82	84	81	finally
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
  
  /* Error */
  public CacheInfo getCacheInfos()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 108	com/tencent/commonsdk/cache/LruCacheInfo
    //   5: dup
    //   6: aload_0
    //   7: getfield 42	com/tencent/commonsdk/cache/QQLruCache:tagId	I
    //   10: aload_0
    //   11: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   14: invokevirtual 111	android/support/v4/util/LruCache:maxSize	()I
    //   17: invokespecial 113	com/tencent/commonsdk/cache/LruCacheInfo:<init>	(II)V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   26: invokevirtual 85	android/support/v4/util/LruCache:size	()I
    //   29: putfield 115	com/tencent/commonsdk/cache/LruCacheInfo:size	I
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 44	com/tencent/commonsdk/cache/QQLruCache:mItemSize	I
    //   37: putfield 116	com/tencent/commonsdk/cache/LruCacheInfo:mItemSize	I
    //   40: aload_0
    //   41: getfield 38	com/tencent/commonsdk/cache/QQLruCache:subNum	I
    //   44: ifle +121 -> 165
    //   47: aload_1
    //   48: aload_0
    //   49: getfield 38	com/tencent/commonsdk/cache/QQLruCache:subNum	I
    //   52: aload_0
    //   53: getfield 44	com/tencent/commonsdk/cache/QQLruCache:mItemSize	I
    //   56: imul
    //   57: putfield 119	com/tencent/commonsdk/cache/LruCacheInfo:mMemorySize	I
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 78	com/tencent/commonsdk/cache/QQLruCache:mClearSize	I
    //   65: putfield 120	com/tencent/commonsdk/cache/LruCacheInfo:mClearSize	I
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   73: invokevirtual 123	android/support/v4/util/LruCache:putCount	()I
    //   76: putfield 125	com/tencent/commonsdk/cache/LruCacheInfo:putCount	I
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 103	com/tencent/commonsdk/cache/QQLruCache:getCount	I
    //   84: putfield 126	com/tencent/commonsdk/cache/LruCacheInfo:getCount	I
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 128	com/tencent/commonsdk/cache/QQLruCache:removeCount	I
    //   92: putfield 129	com/tencent/commonsdk/cache/LruCacheInfo:removeCount	I
    //   95: aload_1
    //   96: aload_0
    //   97: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   100: invokevirtual 132	android/support/v4/util/LruCache:evictionCount	()I
    //   103: putfield 134	com/tencent/commonsdk/cache/LruCacheInfo:evictionCount	I
    //   106: aload_1
    //   107: aload_0
    //   108: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   111: invokevirtual 137	android/support/v4/util/LruCache:hitCount	()I
    //   114: putfield 139	com/tencent/commonsdk/cache/LruCacheInfo:hitCount	I
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 65	com/tencent/commonsdk/cache/QQLruCache:mCache	Landroid/support/v4/util/LruCache;
    //   122: invokevirtual 142	android/support/v4/util/LruCache:missCount	()I
    //   125: putfield 144	com/tencent/commonsdk/cache/LruCacheInfo:missCount	I
    //   128: aload_1
    //   129: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   132: aload_0
    //   133: getfield 52	com/tencent/commonsdk/cache/QQLruCache:createTime	J
    //   136: lsub
    //   137: putfield 147	com/tencent/commonsdk/cache/LruCacheInfo:lifeTime	J
    //   140: aload_0
    //   141: getfield 101	com/tencent/commonsdk/cache/QQLruCache:firstUseTime	J
    //   144: lconst_0
    //   145: lcmp
    //   146: ifeq +15 -> 161
    //   149: aload_1
    //   150: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   153: aload_0
    //   154: getfield 52	com/tencent/commonsdk/cache/QQLruCache:createTime	J
    //   157: lsub
    //   158: putfield 150	com/tencent/commonsdk/cache/LruCacheInfo:gapTime	J
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: areturn
    //   165: aload_1
    //   166: aload_1
    //   167: getfield 115	com/tencent/commonsdk/cache/LruCacheInfo:size	I
    //   170: aload_0
    //   171: getfield 44	com/tencent/commonsdk/cache/QQLruCache:mItemSize	I
    //   174: imul
    //   175: putfield 119	com/tencent/commonsdk/cache/LruCacheInfo:mMemorySize	I
    //   178: goto -118 -> 60
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	QQLruCache
    //   20	147	1	localLruCacheInfo	LruCacheInfo
    //   181	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	60	181	finally
    //   60	161	181	finally
    //   165	178	181	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.cache.QQLruCache
 * JD-Core Version:    0.7.0.1
 */