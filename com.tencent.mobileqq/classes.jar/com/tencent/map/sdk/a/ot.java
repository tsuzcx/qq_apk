package com.tencent.map.sdk.a;

import java.util.LinkedHashMap;
import java.util.Locale;

public class ot<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ot(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
  }
  
  /* Error */
  private void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/map/sdk/a/ot:b	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 37	com/tencent/map/sdk/a/ot:a	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 44	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 40	com/tencent/map/sdk/a/ot:b	I
    //   23: ifeq +41 -> 64
    //   26: new 46	java/lang/IllegalStateException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 53	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 59	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 65
    //   49: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 69	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 40	com/tencent/map/sdk/a/ot:b	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 37	com/tencent/map/sdk/a/ot:a	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 44	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 37	com/tencent/map/sdk/a/ot:a	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 73	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 79 1 0
    //   97: invokeinterface 85 1 0
    //   102: checkcast 87	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 90 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 93 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 37	com/tencent/map/sdk/a/ot:a	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 97	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 40	com/tencent/map/sdk/a/ot:b	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 100	com/tencent/map/sdk/a/ot:b	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 40	com/tencent/map/sdk/a/ot:b	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 102	com/tencent/map/sdk/a/ot:e	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 102	com/tencent/map/sdk/a/ot:e	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_3
    //   159: invokevirtual 105	com/tencent/map/sdk/a/ot:a	(ZLjava/lang/Object;)V
    //   162: goto -162 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	ot
    //   0	165	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	24	2	localObject2	Object
    //   105	54	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
  
  private int b(K paramK, V paramV)
  {
    int i = a(paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected int a(V paramV)
  {
    return 1;
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.d += 1;
      this.b += b(paramK, paramV);
      paramV = this.a.put(paramK, paramV);
      if (paramV != null) {
        this.b -= b(paramK, paramV);
      }
      if (paramV != null) {
        a(false, paramV);
      }
      a(this.c);
      return paramV;
    }
    finally {}
  }
  
  public final void a()
  {
    a(-1);
  }
  
  protected void a(boolean paramBoolean, V paramV) {}
  
  public final V b(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramK = this.a.get(paramK);
      if (paramK != null)
      {
        this.f += 1;
        return paramK;
      }
      this.g += 1;
      return null;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.f + this.g;
      if (j != 0) {
        i = this.f * 100 / j;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ot
 * JD-Core Version:    0.7.0.1
 */