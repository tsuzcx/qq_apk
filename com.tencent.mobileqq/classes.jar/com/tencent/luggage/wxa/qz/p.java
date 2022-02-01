package com.tencent.luggage.wxa.qz;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class p<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public p(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int c(K paramK, V paramV)
  {
    int i = b(paramK, paramV);
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
  
  public final V a(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject = this.a.remove(paramK);
        if (localObject != null) {
          this.b -= c(paramK, localObject);
        }
        if (localObject != null) {
          a(false, paramK, localObject, null);
        }
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      o.b("MicroMsg.LruMap", "put key == null or value == null [%s, %s], %s", new Object[] { paramK, paramV, af.c().toString() });
    }
    try
    {
      this.d += 1;
      this.b += c(paramK, paramV);
      Object localObject = this.a.put(paramK, paramV);
      if (localObject != null) {
        this.b -= c(paramK, localObject);
      }
      if (localObject != null) {
        a(false, paramK, localObject, paramV);
      }
      a(this.c);
      return localObject;
    }
    finally {}
  }
  
  public Set<K> a()
  {
    return this.a.keySet();
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.b >= 0) && ((!this.a.isEmpty()) || (this.b == 0)))
        {
          if ((this.b > paramInt) && (!this.a.isEmpty()))
          {
            Object localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
            localObject1 = ((Map.Entry)localObject3).getKey();
            localObject3 = ((Map.Entry)localObject3).getValue();
            this.a.remove(localObject1);
            this.b -= c(localObject1, localObject3);
            this.f += 1;
            a(true, localObject1, localObject3, null);
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
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  protected int b(K paramK, V paramV)
  {
    return 1;
  }
  
  /* Error */
  public final V b(K paramK)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +25 -> 26
    //   4: ldc 85
    //   6: ldc 156
    //   8: iconst_1
    //   9: anewarray 5	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 92	com/tencent/luggage/wxa/qz/af:c	()Lcom/tencent/luggage/wxa/qz/u;
    //   17: invokevirtual 95	com/tencent/luggage/wxa/qz/u:toString	()Ljava/lang/String;
    //   20: aastore
    //   21: invokestatic 100	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 31	com/tencent/luggage/wxa/qz/p:a	Ljava/util/LinkedHashMap;
    //   32: aload_1
    //   33: invokevirtual 159	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +17 -> 55
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 161	com/tencent/luggage/wxa/qz/p:g	I
    //   46: iconst_1
    //   47: iadd
    //   48: putfield 161	com/tencent/luggage/wxa/qz/p:g	I
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: areturn
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 163	com/tencent/luggage/wxa/qz/p:h	I
    //   60: iconst_1
    //   61: iadd
    //   62: putfield 163	com/tencent/luggage/wxa/qz/p:h	I
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 165	com/tencent/luggage/wxa/qz/p:c	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnonnull +5 -> 79
    //   77: aconst_null
    //   78: areturn
    //   79: aload_0
    //   80: monitorenter
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 167	com/tencent/luggage/wxa/qz/p:e	I
    //   86: iconst_1
    //   87: iadd
    //   88: putfield 167	com/tencent/luggage/wxa/qz/p:e	I
    //   91: aload_0
    //   92: getfield 31	com/tencent/luggage/wxa/qz/p:a	Ljava/util/LinkedHashMap;
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 105	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +16 -> 118
    //   105: aload_0
    //   106: getfield 31	com/tencent/luggage/wxa/qz/p:a	Ljava/util/LinkedHashMap;
    //   109: aload_1
    //   110: aload_3
    //   111: invokevirtual 105	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: goto +18 -> 133
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 71	com/tencent/luggage/wxa/qz/p:b	I
    //   123: aload_0
    //   124: aload_1
    //   125: aload_2
    //   126: invokespecial 73	com/tencent/luggage/wxa/qz/p:c	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   129: iadd
    //   130: putfield 71	com/tencent/luggage/wxa/qz/p:b	I
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: ifnull +13 -> 149
    //   139: aload_0
    //   140: iconst_0
    //   141: aload_1
    //   142: aload_2
    //   143: aload_3
    //   144: invokevirtual 76	com/tencent/luggage/wxa/qz/p:a	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   147: aload_3
    //   148: areturn
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 23	com/tencent/luggage/wxa/qz/p:c	I
    //   154: invokevirtual 107	com/tencent/luggage/wxa/qz/p:a	(I)V
    //   157: aload_2
    //   158: areturn
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	p
    //   0	169	1	paramK	K
    //   36	122	2	localObject1	Object
    //   100	48	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   81	101	159	finally
    //   105	115	159	finally
    //   118	133	159	finally
    //   133	135	159	finally
    //   160	162	159	finally
    //   28	37	164	finally
    //   41	53	164	finally
    //   55	67	164	finally
    //   165	167	164	finally
  }
  
  public final int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected V c(K paramK)
  {
    return null;
  }
  
  public final int d()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d(K paramK)
  {
    try
    {
      boolean bool = this.a.containsKey(paramK);
      return bool;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.g + this.h;
        if (i != 0)
        {
          i = this.g * 100 / i;
          String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.p
 * JD-Core Version:    0.7.0.1
 */