package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class dn
{
  final dr a = new dn.1(this);
  final dz b = new dn.2(this);
  private final ThreadLocal<Map<fd<?>, dn.a<?>>> c = new ThreadLocal();
  private final Map<fd<?>, ee<?>> d = Collections.synchronizedMap(new HashMap());
  private final List<ef> e;
  private final ei f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  
  public dn()
  {
    this(ej.a, dl.a, Collections.emptyMap(), false, false, false, true, false, false, ec.a, Collections.emptyList());
  }
  
  public dn(ej paramej, dm paramdm, Map<Type, dp<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ec paramec, List<ef> paramList)
  {
    this.f = new ei(paramMap);
    this.g = paramBoolean1;
    this.i = paramBoolean3;
    this.h = paramBoolean4;
    this.j = paramBoolean5;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(fc.Q);
    localArrayList.add(ex.a);
    localArrayList.add(paramej);
    localArrayList.addAll(paramList);
    localArrayList.add(fc.x);
    localArrayList.add(fc.m);
    localArrayList.add(fc.g);
    localArrayList.add(fc.i);
    localArrayList.add(fc.k);
    paramList = Long.TYPE;
    if (paramec == ec.a)
    {
      paramMap = fc.n;
      localArrayList.add(fc.a(paramList, Long.class, paramMap));
      paramec = Double.TYPE;
      if (!paramBoolean6) {
        break label600;
      }
      paramMap = fc.p;
      label241:
      localArrayList.add(fc.a(paramec, Double.class, paramMap));
      paramec = Float.TYPE;
      if (!paramBoolean6) {
        break label612;
      }
    }
    label600:
    label612:
    for (paramMap = fc.o;; paramMap = new dn.4(this))
    {
      localArrayList.add(fc.a(paramec, Float.class, paramMap));
      localArrayList.add(fc.r);
      localArrayList.add(fc.t);
      localArrayList.add(fc.z);
      localArrayList.add(fc.B);
      localArrayList.add(fc.a(BigDecimal.class, fc.v));
      localArrayList.add(fc.a(BigInteger.class, fc.w));
      localArrayList.add(fc.D);
      localArrayList.add(fc.F);
      localArrayList.add(fc.J);
      localArrayList.add(fc.O);
      localArrayList.add(fc.H);
      localArrayList.add(fc.d);
      localArrayList.add(et.a);
      localArrayList.add(fc.M);
      localArrayList.add(fa.a);
      localArrayList.add(ez.a);
      localArrayList.add(fc.K);
      localArrayList.add(er.a);
      localArrayList.add(fc.R);
      localArrayList.add(fc.b);
      localArrayList.add(new es(this.f));
      localArrayList.add(new ew(this.f, paramBoolean2));
      localArrayList.add(new ey(this.f, paramdm, paramej));
      this.e = Collections.unmodifiableList(localArrayList);
      return;
      paramMap = new dn.5(this);
      break;
      paramMap = new dn.3(this);
      break label241;
    }
  }
  
  public final <T> ee<T> a(ef paramef, fd<T> paramfd)
  {
    Iterator localIterator = this.e.iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ef)localIterator.next();
      if (k == 0)
      {
        if (localObject == paramef) {
          k = 1;
        }
      }
      else
      {
        localObject = ((ef)localObject).a(this, paramfd);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(paramfd)));
  }
  
  public final <T> ee<T> a(fd<T> paramfd)
  {
    Object localObject1 = (ee)this.d.get(paramfd);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject4 = (Map)this.c.get();
    int k = 0;
    if (localObject4 == null)
    {
      localObject4 = new HashMap();
      this.c.set(localObject4);
      k = 1;
    }
    for (;;)
    {
      Object localObject5 = (dn.a)((Map)localObject4).get(paramfd);
      localObject1 = localObject5;
      if (localObject5 != null) {
        break;
      }
      try
      {
        localObject1 = new dn.a();
        ((Map)localObject4).put(paramfd, localObject1);
        Iterator localIterator = this.e.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject5 = ((ef)localIterator.next()).a(this, paramfd);
        } while (localObject5 == null);
        if (((dn.a)localObject1).a != null) {
          throw new AssertionError();
        }
      }
      finally
      {
        ((Map)localObject4).remove(paramfd);
        if (k != 0) {
          this.c.remove();
        }
      }
      localObject2.a = ((ee)localObject5);
      this.d.put(paramfd, localObject5);
      ((Map)localObject4).remove(paramfd);
      Object localObject3 = localObject5;
      if (k == 0) {
        break;
      }
      this.c.remove();
      return localObject5;
      throw new IllegalArgumentException("GSON cannot handle ".concat(String.valueOf(paramfd)));
    }
  }
  
  public final <T> ee<T> a(Class<T> paramClass)
  {
    return a(fd.a(paramClass));
  }
  
  /* Error */
  public final <T> T a(fe paramfe, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: getfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   13: aload_1
    //   14: invokevirtual 376	com/tencent/map/sdk/a/fe:f	()Lcom/tencent/map/sdk/a/ff;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 379	com/tencent/map/sdk/a/fd:a	(Ljava/lang/reflect/Type;)Lcom/tencent/map/sdk/a/fd;
    //   25: invokevirtual 361	com/tencent/map/sdk/a/dn:a	(Lcom/tencent/map/sdk/a/fd;)Lcom/tencent/map/sdk/a/ee;
    //   28: aload_1
    //   29: invokevirtual 382	com/tencent/map/sdk/a/ee:a	(Lcom/tencent/map/sdk/a/fe;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: iload_3
    //   43: ifeq +11 -> 54
    //   46: aload_1
    //   47: iload 4
    //   49: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   52: aconst_null
    //   53: areturn
    //   54: new 384	com/tencent/map/sdk/a/eb
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: iload 4
    //   67: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: new 384	com/tencent/map/sdk/a/eb
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   81: athrow
    //   82: astore_2
    //   83: new 384	com/tencent/map/sdk/a/eb
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	dn
    //   0	92	1	paramfe	fe
    //   0	92	2	paramType	Type
    //   1	42	3	k	int
    //   6	60	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	java/io/EOFException
    //   20	33	41	java/io/EOFException
    //   13	18	63	finally
    //   20	33	63	finally
    //   54	63	63	finally
    //   73	82	63	finally
    //   83	92	63	finally
    //   13	18	72	java/lang/IllegalStateException
    //   20	33	72	java/lang/IllegalStateException
    //   13	18	82	java/io/IOException
    //   20	33	82	java/io/IOException
  }
  
  public final String toString()
  {
    return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dn
 * JD-Core Version:    0.7.0.1
 */