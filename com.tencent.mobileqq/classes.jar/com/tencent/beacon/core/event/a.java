package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.c.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements g
{
  private static AtomicInteger i = new AtomicInteger(1000);
  private Context a;
  private boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private Object e = new Object();
  private List<RDBean> f;
  private long g = 60000L;
  private d h;
  private int j;
  private Runnable k = new a.1(this);
  private Runnable l = new a.2(this);
  private Runnable m = new a.3(this);
  
  public a(Context paramContext, d paramd)
  {
    this.a = paramContext;
    this.f = new ArrayList(25);
    this.h = paramd;
    this.j = i.addAndGet(1);
  }
  
  private String a(String paramString)
  {
    return paramString + " Tunnel key: " + this.h.f();
  }
  
  /* Error */
  private List<RDBean> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/beacon/core/event/a:f	Ljava/util/List;
    //   6: invokeinterface 116 1 0
    //   11: ifle +12 -> 23
    //   14: aload_0
    //   15: invokespecial 119	com/tencent/beacon/core/event/a:e	()Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 76	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 120	java/util/ArrayList:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 79	com/tencent/beacon/core/event/a:f	Ljava/util/List;
    //   42: invokeinterface 124 2 0
    //   47: pop
    //   48: aload_0
    //   49: getfield 79	com/tencent/beacon/core/event/a:f	Ljava/util/List;
    //   52: invokeinterface 127 1 0
    //   57: aload_0
    //   58: new 94	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 129
    //   64: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: invokeinterface 116 1 0
    //   73: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 92	com/tencent/beacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 140	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: goto -64 -> 25
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   18	2	1	bool	boolean
    //   24	44	2	localObject1	Object
    //   92	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	92	finally
    //   29	89	92	finally
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    int n = 0;
    synchronized (this.d)
    {
      if (!e())
      {
        com.tencent.beacon.core.d.b.d(a("[event] err disable."), new Object[0]);
        return;
      }
      Object localObject2 = d();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label336;
      }
      localObject2 = k.a(this.a, this.h.f(), (List)localObject2);
      if (localObject2 != null)
      {
        localObject4 = i.a(this.a).c().iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((j)((Iterator)localObject4).next()).incCommonEventWriteSucc(localObject2.length);
        }
      }
    }
    Object localObject4 = i.a(this.a);
    if (localObject3 != null)
    {
      long l2 = EventStrategyBean.getInstance().getComNumUpload();
      long l1 = l2;
      if (com.tencent.beacon.core.d.d.a(this.a))
      {
        com.tencent.beacon.core.d.b.e(a("[event] on wifi, so half mSZ " + l2), new Object[0]);
        l1 = l2 / 2L;
      }
      int i1 = k.a(this.a, this.h.f());
      com.tencent.beacon.core.d.b.b(a("[event] recordNum: " + i1 + ", maxNum: " + l1), new Object[0]);
      if (i1 >= l1) {
        n = 1;
      }
      if ((n != 0) && (((i)localObject4).a()) && (((i)localObject4).b()))
      {
        if (!EventStrategyBean.getInstance().isZeroPeakUploadByRate())
        {
          com.tencent.beacon.core.d.b.e(a("[event] max but not up(zeroPeak)!"), new Object[0]);
          return;
        }
        this.m.run();
        com.tencent.beacon.core.d.b.e(a("[event] max then up"), new Object[0]);
      }
    }
    label387:
    for (;;)
    {
      return;
      label336:
      EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
      if (localEventStrategyBean != null) {}
      for (boolean bool = localEventStrategyBean.isComPollUp();; bool = false)
      {
        if (!bool) {
          break label387;
        }
        this.m.run();
        com.tencent.beacon.core.d.b.e(a("[event] polling then up"), new Object[0]);
        break;
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/beacon/core/event/a:b	Z
    //   6: iload_1
    //   7: if_icmpeq +49 -> 56
    //   10: iload_1
    //   11: ifeq +48 -> 59
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 45	com/tencent/beacon/core/event/a:b	Z
    //   19: aload_0
    //   20: invokestatic 185	com/tencent/beacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/beacon/core/event/EventStrategyBean;
    //   23: invokevirtual 234	com/tencent/beacon/core/event/EventStrategyBean:getComDelayDB	()I
    //   26: sipush 1000
    //   29: imul
    //   30: i2l
    //   31: putfield 55	com/tencent/beacon/core/event/a:g	J
    //   34: invokestatic 239	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   37: aload_0
    //   38: getfield 87	com/tencent/beacon/core/event/a:j	I
    //   41: aload_0
    //   42: getfield 62	com/tencent/beacon/core/event/a:k	Ljava/lang/Runnable;
    //   45: aload_0
    //   46: getfield 55	com/tencent/beacon/core/event/a:g	J
    //   49: aload_0
    //   50: getfield 55	com/tencent/beacon/core/event/a:g	J
    //   53: invokevirtual 242	com/tencent/beacon/core/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: invokestatic 239	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   62: aload_0
    //   63: getfield 87	com/tencent/beacon/core/event/a:j	I
    //   66: iconst_1
    //   67: invokevirtual 245	com/tencent/beacon/core/a/b:a	(IZ)V
    //   70: invokestatic 239	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   73: bipush 112
    //   75: iconst_1
    //   76: invokevirtual 245	com/tencent/beacon/core/a/b:a	(IZ)V
    //   79: aload_0
    //   80: iconst_1
    //   81: invokevirtual 247	com/tencent/beacon/core/event/a:b	(Z)V
    //   84: aload_0
    //   85: iload_1
    //   86: putfield 45	com/tencent/beacon/core/event/a:b	Z
    //   89: goto -33 -> 56
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   0	97	1	paramBoolean	boolean
    //   92	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	92	finally
    //   14	56	92	finally
    //   59	89	92	finally
  }
  
  public final boolean a(RDBean paramRDBean)
  {
    synchronized (this.c)
    {
      String str = a("[event] eN:%s");
      if (paramRDBean == null) {}
      for (localObject1 = "null";; localObject1 = paramRDBean.getEN())
      {
        com.tencent.beacon.core.d.b.f(str, new Object[] { localObject1 });
        if ((this.a != null) && (paramRDBean != null) && (this.b)) {
          break;
        }
        com.tencent.beacon.core.d.b.d(a("[event] err return."), new Object[0]);
        return false;
      }
      if (!e())
      {
        com.tencent.beacon.core.d.b.d(a("[event] return false, isEnable is false !"), new Object[0]);
        return false;
      }
    }
    Object localObject1 = EventStrategyBean.getInstance();
    int n = ((EventStrategyBean)localObject1).getComNumDB();
    this.g = (((EventStrategyBean)localObject1).getComDelayDB() * 1000);
    int i1 = this.f.size();
    if (i1 >= n)
    {
      com.tencent.beacon.core.d.b.f(a("[event] max num."), new Object[0]);
      com.tencent.beacon.core.a.b.b().a(this.k);
      com.tencent.beacon.core.a.b.b().a(this.j, this.k, this.g, this.g);
    }
    this.f.add(paramRDBean);
    com.tencent.beacon.core.d.b.f(a("[event] event buff num：" + this.f.size()), new Object[0]);
    if (this.f.size() >= n) {
      com.tencent.beacon.core.d.b.c(a("[event] err BF 3R! list size:" + i1), new Object[0]);
    }
    paramRDBean = i.a(this.a).c().iterator();
    while (paramRDBean.hasNext()) {
      ((j)paramRDBean.next()).incCommonEventCalls();
    }
    com.tencent.beacon.core.d.b.a(a("[event] process UA:true!"), new Object[0]);
    return true;
  }
  
  protected final void b()
  {
    com.tencent.beacon.core.d.b.b(a("[event] sync db only"), new Object[0]);
    synchronized (this.e)
    {
      if (!e())
      {
        com.tencent.beacon.core.d.b.d(a("[event] err disable."), new Object[0]);
        return;
      }
      Object localObject2 = d();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = k.a(this.a, this.h.f(), (List)localObject2);
        if (localObject2 != null)
        {
          Iterator localIterator = i.a(this.a).c().iterator();
          if (localIterator.hasNext()) {
            ((j)localIterator.next()).incCommonEventWriteSucc(localObject2.length);
          }
        }
      }
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 292
    //   6: invokespecial 92	com/tencent/beacon/core/event/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 200	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: iload_1
    //   17: ifeq +10 -> 27
    //   20: aload_0
    //   21: invokevirtual 294	com/tencent/beacon/core/event/a:b	()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 239	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   30: aload_0
    //   31: getfield 67	com/tencent/beacon/core/event/a:l	Ljava/lang/Runnable;
    //   34: invokevirtual 271	com/tencent/beacon/core/a/b:a	(Ljava/lang/Runnable;)V
    //   37: goto -13 -> 24
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	a
    //   0	45	1	paramBoolean	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	40	finally
    //   20	24	40	finally
    //   27	37	40	finally
  }
  
  public final void c()
  {
    try
    {
      this.g = (EventStrategyBean.getInstance().getComDelayDB() * 1000);
      com.tencent.beacon.core.a.b.b().a(this.j, this.k, this.g, this.g);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.event.a
 * JD-Core Version:    0.7.0.1
 */