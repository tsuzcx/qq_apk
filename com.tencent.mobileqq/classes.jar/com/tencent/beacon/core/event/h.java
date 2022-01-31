package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
  implements g
{
  private static AtomicInteger e = new AtomicInteger(2000);
  private boolean a = false;
  private List<RDBean> b;
  private Context c;
  private d d;
  private int f;
  private Runnable g = new h.1(this);
  private Runnable h = new h.2(this);
  
  public h(Context paramContext, d paramd)
  {
    this.c = paramContext;
    this.b = Collections.synchronizedList(new ArrayList(25));
    this.d = paramd;
    this.f = e.addAndGet(1);
  }
  
  private String a(String paramString)
  {
    return paramString + " Tunnel key: " + this.d.f();
  }
  
  /* Error */
  private List<RDBean> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/beacon/core/event/h:b	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 63	com/tencent/beacon/core/event/h:b	Ljava/util/List;
    //   13: invokeinterface 99 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 102	com/tencent/beacon/core/event/h:e	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 54	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 103	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 63	com/tencent/beacon/core/event/h:b	Ljava/util/List;
    //   49: invokeinterface 107 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 63	com/tencent/beacon/core/event/h:b	Ljava/util/List;
    //   59: invokeinterface 110 1 0
    //   64: aload_0
    //   65: new 77	java/lang/StringBuilder
    //   68: dup
    //   69: ldc 112
    //   71: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokeinterface 99 1 0
    //   80: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 75	com/tencent/beacon/core/event/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 123	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: goto -64 -> 32
    //   99: astore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	h
    //   25	2	1	bool	boolean
    //   31	44	2	localObject1	Object
    //   99	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	99	finally
    //   36	96	99	finally
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.a;
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
    Object localObject = d();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      com.tencent.beacon.core.d.b.f(a("[realtime event] sync real events 2 db"), new Object[0]);
      localObject = k.a(this.c, this.d.f(), (List)localObject);
      if (localObject != null)
      {
        Iterator localIterator = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
        while (localIterator.hasNext()) {
          ((j)localIterator.next()).incRealTimeEventWriteSucc(localObject.length);
        }
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
    //   3: getfield 38	com/tencent/beacon/core/event/h:a	Z
    //   6: iload_1
    //   7: if_icmpeq +42 -> 49
    //   10: iload_1
    //   11: ifeq +41 -> 52
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 38	com/tencent/beacon/core/event/h:a	Z
    //   19: invokestatic 169	com/tencent/beacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/beacon/core/event/EventStrategyBean;
    //   22: invokevirtual 172	com/tencent/beacon/core/event/EventStrategyBean:getRealDelayUpload	()I
    //   25: sipush 1000
    //   28: imul
    //   29: i2l
    //   30: lstore_2
    //   31: invokestatic 177	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   34: aload_0
    //   35: getfield 71	com/tencent/beacon/core/event/h:f	I
    //   38: aload_0
    //   39: getfield 45	com/tencent/beacon/core/event/h:g	Ljava/lang/Runnable;
    //   42: ldc2_w 178
    //   45: lload_2
    //   46: invokevirtual 182	com/tencent/beacon/core/a/b:a	(ILjava/lang/Runnable;JJ)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: invokestatic 177	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   55: aload_0
    //   56: getfield 71	com/tencent/beacon/core/event/h:f	I
    //   59: iconst_1
    //   60: invokevirtual 185	com/tencent/beacon/core/a/b:a	(IZ)V
    //   63: aload_0
    //   64: iconst_1
    //   65: invokevirtual 187	com/tencent/beacon/core/event/h:b	(Z)V
    //   68: aload_0
    //   69: iload_1
    //   70: putfield 38	com/tencent/beacon/core/event/h:a	Z
    //   73: goto -24 -> 49
    //   76: astore 4
    //   78: aload_0
    //   79: monitorexit
    //   80: aload 4
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	h
    //   0	83	1	paramBoolean	boolean
    //   30	16	2	l	long
    //   76	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	76	finally
    //   14	49	76	finally
    //   52	73	76	finally
  }
  
  public final boolean a(RDBean paramRDBean)
  {
    boolean bool = false;
    Object localObject;
    if (paramRDBean == null) {
      localObject = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.d.b.f("[event] eN:%s", new Object[] { localObject });
        if ((this.c == null) || (paramRDBean == null))
        {
          com.tencent.beacon.core.d.b.d(a("[realtime event] context is null or bean is null !"), new Object[0]);
          return bool;
          localObject = paramRDBean.getEN();
          continue;
        }
        if (!e())
        {
          com.tencent.beacon.core.d.b.d(a("[realtime event] disable process."), new Object[0]);
          continue;
        }
        this.b.add(paramRDBean);
      }
      finally {}
      localObject = EventStrategyBean.getInstance();
      int i = ((EventStrategyBean)localObject).getRealNumUpload();
      long l = ((EventStrategyBean)localObject).getRealDelayUpload() * 1000;
      int j = this.b.size();
      com.tencent.beacon.core.d.b.b(a("[realtime event] realtime event buff num: " + this.b.size()), new Object[0]);
      if (("rqd_applaunched".equals(paramRDBean.getEN())) || (j >= i) || (paramRDBean.isImmediatelyUpload()))
      {
        com.tencent.beacon.core.d.b.f(a("[realtime event] upload by max num or immediate."), new Object[0]);
        com.tencent.beacon.core.a.b.b().a(this.g);
        com.tencent.beacon.core.a.b.b().a(this.f, this.g, l, l);
      }
      paramRDBean = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
      while (paramRDBean.hasNext()) {
        ((j)paramRDBean.next()).incRealTimeEventCalls();
      }
      com.tencent.beacon.core.d.b.a(a("[realtime event] processUA:true!"), new Object[0]);
      bool = true;
    }
  }
  
  protected final void b()
  {
    if (!e()) {
      com.tencent.beacon.core.d.b.d(a("[realtime event] disable upload."), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return;
      localObject1 = d();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = com.tencent.beacon.core.c.i.a(this.c);
        EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
        if ((com.tencent.beacon.core.d.d.b(this.c)) && (localObject2 != null) && (localEventStrategyBean.isZeroPeakUploadByRate())) {
          break;
        }
        com.tencent.beacon.core.d.b.f(a("[realtime event] sync real events 2 db"), new Object[0]);
        localObject1 = k.a(this.c, this.d.f(), (List)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((j)((Iterator)localObject2).next()).incRealTimeEventWriteSucc(localObject1.length);
          }
        }
      }
    }
    com.tencent.beacon.core.d.b.f(a("[realtime event] sync real events 2 upload"), new Object[0]);
    ((com.tencent.beacon.core.c.h)localObject2).a(new i(this.c, this.d.f(), (List)localObject1));
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 258
    //   6: invokespecial 75	com/tencent/beacon/core/event/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 260	com/tencent/beacon/core/d/b:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: iload_1
    //   17: ifeq +10 -> 27
    //   20: aload_0
    //   21: invokevirtual 262	com/tencent/beacon/core/event/h:a	()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 177	com/tencent/beacon/core/a/b:b	()Lcom/tencent/beacon/core/a/b;
    //   30: aload_0
    //   31: getfield 50	com/tencent/beacon/core/event/h:h	Ljava/lang/Runnable;
    //   34: invokevirtual 227	com/tencent/beacon/core/a/b:a	(Ljava/lang/Runnable;)V
    //   37: goto -13 -> 24
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	h
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
      long l = EventStrategyBean.getInstance().getRealDelayUpload() * 1000;
      com.tencent.beacon.core.a.b.b().a(this.f, this.g, 5000L, l);
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
 * Qualified Name:     com.tencent.beacon.core.event.h
 * JD-Core Version:    0.7.0.1
 */