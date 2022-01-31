package android.support.v4.util;

import com.tencent.commonsdk.cache.IMemoryManager;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V>
{
  private static IMemoryManager sManager;
  private int clearMemory;
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
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
    if (sManager != null) {
      sManager.addLruCache(this);
    }
  }
  
  public LruCache(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
    if ((paramBoolean) && (sManager != null)) {
      sManager.addLruCache(this);
    }
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  public static final void setManager(IMemoryManager paramIMemoryManager)
  {
    if (paramIMemoryManager != null) {
      sManager = paramIMemoryManager;
    }
  }
  
  /* Error */
  public final int cacheCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 85	java/util/LinkedHashMap:size	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	LruCache
    //   16	7	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.map.get(paramK);
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
    }
    finally {}
    try
    {
      this.createCount += 1;
      Object localObject2 = this.map.put(paramK, localObject1);
      if (localObject2 != null) {
        this.map.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return localObject2;
        this.size += safeSizeOf(paramK, localObject1);
      }
      trimToSize(this.maxSize);
    }
    finally {}
    return localObject1;
  }
  
  public final int getClearMemory()
  {
    return this.clearMemory;
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
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
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
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
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
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
  
  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = this.hitCount * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 121	android/support/v4/util/LruCache:size	I
    //   11: iflt +20 -> 31
    //   14: aload_0
    //   15: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   18: invokevirtual 158	java/util/LinkedHashMap:isEmpty	()Z
    //   21: ifeq +50 -> 71
    //   24: aload_0
    //   25: getfield 121	android/support/v4/util/LruCache:size	I
    //   28: ifeq +43 -> 71
    //   31: new 58	java/lang/IllegalStateException
    //   34: dup
    //   35: new 60	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   42: aload_0
    //   43: invokevirtual 162	java/lang/Object:getClass	()Ljava/lang/Class;
    //   46: invokevirtual 167	java/lang/Class:getName	()Ljava/lang/String;
    //   49: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 169
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 77	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: aload_0
    //   72: getfield 121	android/support/v4/util/LruCache:size	I
    //   75: iload_1
    //   76: if_icmple +13 -> 89
    //   79: aload_0
    //   80: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   83: invokevirtual 158	java/util/LinkedHashMap:isEmpty	()Z
    //   86: ifeq +6 -> 92
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: aload_0
    //   93: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   96: invokevirtual 173	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   99: invokeinterface 179 1 0
    //   104: invokeinterface 185 1 0
    //   109: checkcast 187	java/util/Map$Entry
    //   112: astore 5
    //   114: aload 5
    //   116: invokeinterface 190 1 0
    //   121: astore 4
    //   123: aload 5
    //   125: invokeinterface 193 1 0
    //   130: astore 5
    //   132: aload_0
    //   133: aload 4
    //   135: aload 5
    //   137: invokespecial 123	android/support/v4/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: iconst_1
    //   141: if_icmpne +98 -> 239
    //   144: aload 5
    //   146: ifnull +93 -> 239
    //   149: aload 5
    //   151: instanceof 195
    //   154: ifeq +85 -> 239
    //   157: aload_0
    //   158: getfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   161: istore_2
    //   162: aload 5
    //   164: checkcast 195	android/graphics/Bitmap
    //   167: invokevirtual 198	android/graphics/Bitmap:getRowBytes	()I
    //   170: istore_3
    //   171: aload_0
    //   172: aload 5
    //   174: checkcast 195	android/graphics/Bitmap
    //   177: invokevirtual 201	android/graphics/Bitmap:getHeight	()I
    //   180: iload_3
    //   181: imul
    //   182: iload_2
    //   183: iadd
    //   184: putfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   187: aload_0
    //   188: getfield 41	android/support/v4/util/LruCache:map	Ljava/util/LinkedHashMap;
    //   191: aload 4
    //   193: invokevirtual 134	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 121	android/support/v4/util/LruCache:size	I
    //   202: aload_0
    //   203: aload 4
    //   205: aload 5
    //   207: invokespecial 123	android/support/v4/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   210: isub
    //   211: putfield 121	android/support/v4/util/LruCache:size	I
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 99	android/support/v4/util/LruCache:evictionCount	I
    //   219: iconst_1
    //   220: iadd
    //   221: putfield 99	android/support/v4/util/LruCache:evictionCount	I
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_0
    //   227: iconst_1
    //   228: aload 4
    //   230: aload 5
    //   232: aconst_null
    //   233: invokevirtual 119	android/support/v4/util/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   236: goto -231 -> 5
    //   239: aload_0
    //   240: aload 4
    //   242: aload 5
    //   244: invokespecial 123	android/support/v4/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   247: iconst_1
    //   248: if_icmpne +58 -> 306
    //   251: aload 5
    //   253: ifnull +53 -> 306
    //   256: aload 5
    //   258: instanceof 203
    //   261: ifeq +45 -> 306
    //   264: aload 5
    //   266: checkcast 203	android/graphics/drawable/BitmapDrawable
    //   269: invokevirtual 207	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   272: astore 6
    //   274: aload 6
    //   276: ifnull -89 -> 187
    //   279: aload_0
    //   280: getfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   283: istore_2
    //   284: aload 6
    //   286: invokevirtual 198	android/graphics/Bitmap:getRowBytes	()I
    //   289: istore_3
    //   290: aload_0
    //   291: aload 6
    //   293: invokevirtual 201	android/graphics/Bitmap:getHeight	()I
    //   296: iload_3
    //   297: imul
    //   298: iload_2
    //   299: iadd
    //   300: putfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   303: goto -116 -> 187
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   311: aload_0
    //   312: aload 4
    //   314: aload 5
    //   316: invokespecial 123	android/support/v4/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   319: iadd
    //   320: putfield 126	android/support/v4/util/LruCache:clearMemory	I
    //   323: goto -136 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	LruCache
    //   0	326	1	paramInt	int
    //   161	139	2	i	int
    //   170	128	3	j	int
    //   64	5	4	localObject1	Object
    //   121	192	4	localObject2	Object
    //   112	203	5	localObject3	Object
    //   272	20	6	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   7	31	64	finally
    //   31	64	64	finally
    //   66	68	64	finally
    //   71	89	64	finally
    //   89	91	64	finally
    //   92	144	64	finally
    //   149	187	64	finally
    //   187	226	64	finally
    //   239	251	64	finally
    //   256	274	64	finally
    //   279	303	64	finally
    //   306	323	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.LruCache
 * JD-Core Version:    0.7.0.1
 */