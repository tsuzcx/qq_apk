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
    if (paramec == ec.a) {
      paramMap = fc.n;
    } else {
      paramMap = new dn.5(this);
    }
    localArrayList.add(fc.a(paramList, Long.class, paramMap));
    paramec = Double.TYPE;
    if (paramBoolean6) {
      paramMap = fc.p;
    } else {
      paramMap = new dn.3(this);
    }
    localArrayList.add(fc.a(paramec, Double.class, paramMap));
    paramec = Float.TYPE;
    if (paramBoolean6) {
      paramMap = fc.o;
    } else {
      paramMap = new dn.4(this);
    }
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
    paramef = new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(paramfd)));
    for (;;)
    {
      throw paramef;
    }
  }
  
  public final <T> ee<T> a(fd<T> paramfd)
  {
    Object localObject1 = (ee)this.d.get(paramfd);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = (Map)this.c.get();
    int k = 0;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      this.c.set(localObject1);
      k = 1;
    }
    localObject2 = (dn.a)((Map)localObject1).get(paramfd);
    if (localObject2 != null) {
      return localObject2;
    }
    try
    {
      localObject2 = new dn.a();
      ((Map)localObject1).put(paramfd, localObject2);
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        ee localee = ((ef)localIterator.next()).a(this, paramfd);
        if (localee != null)
        {
          if (((dn.a)localObject2).a == null)
          {
            ((dn.a)localObject2).a = localee;
            this.d.put(paramfd, localee);
            ((Map)localObject1).remove(paramfd);
            if (k != 0) {
              this.c.remove();
            }
            return localee;
          }
          throw new AssertionError();
        }
      }
      throw new IllegalArgumentException("GSON cannot handle ".concat(String.valueOf(paramfd)));
    }
    finally
    {
      ((Map)localObject1).remove(paramfd);
      if (k != 0) {
        this.c.remove();
      }
    }
    for (;;)
    {
      throw localObject3;
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
    //   0: aload_1
    //   1: getfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore_3
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
    //   42: goto +45 -> 87
    //   45: astore_2
    //   46: new 384	com/tencent/map/sdk/a/eb
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   54: athrow
    //   55: astore_2
    //   56: new 384	com/tencent/map/sdk/a/eb
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   64: athrow
    //   65: astore_2
    //   66: iload_3
    //   67: ifeq +11 -> 78
    //   70: aload_1
    //   71: iload 4
    //   73: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   76: aconst_null
    //   77: areturn
    //   78: new 384	com/tencent/map/sdk/a/eb
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 387	com/tencent/map/sdk/a/eb:<init>	(Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: aload_1
    //   88: iload 4
    //   90: putfield 373	com/tencent/map/sdk/a/fe:b	Z
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	dn
    //   0	95	1	paramfe	fe
    //   0	95	2	paramType	Type
    //   7	60	3	k	int
    //   4	85	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   20	33	41	finally
    //   46	55	41	finally
    //   56	65	41	finally
    //   78	87	41	finally
    //   13	18	45	java/io/IOException
    //   20	33	45	java/io/IOException
    //   13	18	55	java/lang/IllegalStateException
    //   20	33	55	java/lang/IllegalStateException
    //   13	18	65	java/io/EOFException
    //   20	33	65	java/io/EOFException
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("factories:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.dn
 * JD-Core Version:    0.7.0.1
 */