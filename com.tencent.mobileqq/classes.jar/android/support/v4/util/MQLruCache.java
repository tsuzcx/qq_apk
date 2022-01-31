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
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.mqCaches = new AsyncLruCache[3];
    this.oldValues = new ArrayList[3];
    this.maxSizes = new int[3];
    this.maxSizes[0] = (paramInt * 5 / 10);
    this.maxSizes[1] = (paramInt * 4 / 10);
    this.maxSizes[2] = (paramInt * 1 / 10);
    paramInt = i;
    while (paramInt < 3)
    {
      this.oldValues[paramInt] = new ArrayList();
      this.mqCaches[paramInt] = new MQLruCache.1(this, this.maxSizes[paramInt], paramInt);
      paramInt += 1;
    }
  }
  
  private final O put(K paramK, MQLruCache<K, O>.CacheItem paramMQLruCache)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramMQLruCache.priority;
        i = 0;
        if ((i >= 3) || ((i != j) && ((MQLruCache.CacheItem)this.mqCaches[i].remove(paramK) != null)))
        {
          this.mqCaches[j].put(paramK, paramMQLruCache);
          i = j;
          if ((i > 0) && (this.oldValues[i].size() > 0))
          {
            j = 0;
            if (j < this.oldValues[i].size())
            {
              paramK = (Pair)this.oldValues[i].get(j);
              MQLruCache.CacheItem localCacheItem = (MQLruCache.CacheItem)paramK.second;
              localCacheItem.priority = ((byte)(localCacheItem.priority - 1));
              ((MQLruCache.CacheItem)paramK.second).hitCount = 0;
              this.mqCaches[((MQLruCache.CacheItem)paramK.second).priority].put(paramK.first, paramK.second);
              j += 1;
              continue;
            }
            this.oldValues[i].clear();
            i = (byte)(i - 1);
            continue;
          }
          paramK = paramMQLruCache.value;
          return paramK;
        }
      }
      finally {}
      i += 1;
    }
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  /* Error */
  public final O get(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_3
    //   7: astore 4
    //   9: iload_2
    //   10: iconst_2
    //   11: if_icmpgt +92 -> 103
    //   14: aload_0
    //   15: getfield 36	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   18: iload_2
    //   19: aaload
    //   20: aload_1
    //   21: invokevirtual 125	android/support/v4/util/AsyncLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 75	android/support/v4/util/MQLruCache$CacheItem
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +89 -> 118
    //   32: aload_3
    //   33: aload_3
    //   34: getfield 102	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   37: iconst_1
    //   38: iadd
    //   39: putfield 102	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   42: aload_3
    //   43: astore 4
    //   45: aload_3
    //   46: getfield 102	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   49: sipush 128
    //   52: if_icmplt +51 -> 103
    //   55: aload_3
    //   56: astore 4
    //   58: aload_3
    //   59: getfield 78	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   62: iconst_2
    //   63: if_icmpge +40 -> 103
    //   66: aload_0
    //   67: getfield 36	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   70: iload_2
    //   71: aaload
    //   72: aload_1
    //   73: invokevirtual 82	android/support/v4/util/AsyncLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload_3
    //   78: aload_3
    //   79: getfield 78	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   82: iconst_1
    //   83: iadd
    //   84: i2b
    //   85: putfield 78	android/support/v4/util/MQLruCache$CacheItem:priority	B
    //   88: aload_3
    //   89: iconst_0
    //   90: putfield 102	android/support/v4/util/MQLruCache$CacheItem:hitCount	I
    //   93: aload_0
    //   94: aload_1
    //   95: aload_3
    //   96: invokespecial 127	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Landroid/support/v4/util/MQLruCache$CacheItem;)Ljava/lang/Object;
    //   99: pop
    //   100: aload_3
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +20 -> 125
    //   108: aload 4
    //   110: getfield 111	android/support/v4/util/MQLruCache$CacheItem:value	Ljava/lang/Object;
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: areturn
    //   118: iload_2
    //   119: iconst_1
    //   120: iadd
    //   121: istore_2
    //   122: goto -116 -> 6
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -13 -> 114
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	MQLruCache
    //   0	135	1	paramK	K
    //   3	119	2	i	int
    //   5	96	3	localCacheItem1	MQLruCache.CacheItem
    //   7	102	4	localCacheItem2	MQLruCache.CacheItem
    // Exception table:
    //   from	to	target	type
    //   14	28	130	finally
    //   32	42	130	finally
    //   45	55	130	finally
    //   58	100	130	finally
    //   108	114	130	finally
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
    }
    finally {}
    return localArrayList1;
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
  
  /* Error */
  public void releaseLargeCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	android/support/v4/util/MQLruCache:largeSizeItem	Ljava/util/HashSet;
    //   6: invokevirtual 165	java/util/HashSet:size	()I
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: invokevirtual 167	android/support/v4/util/MQLruCache:getLargeCache	()Ljava/util/ArrayList;
    //   21: astore_2
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_2
    //   26: invokevirtual 89	java/util/ArrayList:size	()I
    //   29: if_icmpge +20 -> 49
    //   32: aload_0
    //   33: aload_2
    //   34: iload_1
    //   35: invokevirtual 93	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   38: invokevirtual 168	android/support/v4/util/MQLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: iload_1
    //   43: iconst_1
    //   44: iadd
    //   45: istore_1
    //   46: goto -22 -> 24
    //   49: aload_0
    //   50: getfield 47	android/support/v4/util/MQLruCache:largeSizeItem	Ljava/util/HashSet;
    //   53: invokevirtual 169	java/util/HashSet:clear	()V
    //   56: goto -42 -> 14
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	MQLruCache
    //   9	37	1	i	int
    //   21	13	2	localArrayList	ArrayList
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	59	finally
    //   17	22	59	finally
    //   24	42	59	finally
    //   49	56	59	finally
  }
  
  /* Error */
  public final O remove(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: iload_2
    //   7: iconst_3
    //   8: if_icmpge +21 -> 29
    //   11: aload_0
    //   12: getfield 36	android/support/v4/util/MQLruCache:mqCaches	[Landroid/support/v4/util/AsyncLruCache;
    //   15: iload_2
    //   16: aaload
    //   17: aload_1
    //   18: invokevirtual 82	android/support/v4/util/AsyncLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 75	android/support/v4/util/MQLruCache$CacheItem
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +16 -> 42
    //   29: aload_3
    //   30: ifnull +19 -> 49
    //   33: aload_3
    //   34: getfield 111	android/support/v4/util/MQLruCache$CacheItem:value	Ljava/lang/Object;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: iload_2
    //   43: iconst_1
    //   44: iadd
    //   45: istore_2
    //   46: goto -40 -> 6
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -13 -> 38
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	MQLruCache
    //   0	59	1	paramK	K
    //   3	43	2	i	int
    //   5	29	3	localCacheItem	MQLruCache.CacheItem
    // Exception table:
    //   from	to	target	type
    //   11	25	54	finally
    //   33	38	54	finally
  }
  
  public final void resetMaxSize(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    int i = 0;
    while (i < 3) {
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
      finally
      {
        localObject = finally;
        throw localObject;
      }
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
      Object localObject = new LinkedHashMap();
      int i = 0;
      while (i < 3)
      {
        ((Map)localObject).putAll(this.mqCaches[i].snapshot());
        i += 1;
      }
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localLinkedHashMap.put(localEntry.getKey(), ((MQLruCache.CacheItem)localEntry.getValue()).value);
      }
    }
    finally {}
    return localMap;
  }
  
  public final void trimToSize(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        i = size();
        if (i <= paramInt) {
          return;
        }
        i -= paramInt;
        paramInt = j;
        j = this.mqCaches[paramInt].size();
        if (j >= i)
        {
          this.mqCaches[paramInt].trimToSize(j - i);
          this.oldValues[0].clear();
          this.oldValues[1].clear();
          this.oldValues[2].clear();
          continue;
        }
        this.mqCaches[paramInt].trimToSize(0);
      }
      finally {}
      i -= j;
      j = paramInt + 1;
      if (i > 0)
      {
        paramInt = j;
        if (j < 3) {}
      }
    }
  }
  
  public void warningLargeItem(K paramK, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.MQLruCache
 * JD-Core Version:    0.7.0.1
 */