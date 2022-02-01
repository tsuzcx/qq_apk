package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.j;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.d.l;
import com.tencent.beacon.core.e.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class q
  implements n
{
  private static AtomicInteger a = new AtomicInteger(2000);
  boolean b = false;
  protected final List<RDBean> c;
  protected final Context d;
  private h e;
  private int f;
  protected Runnable g = new o(this);
  protected Runnable h = new p(this);
  
  public q(Context paramContext, h paramh)
  {
    this.d = paramContext;
    this.c = Collections.synchronizedList(new ArrayList(25));
    this.e = paramh;
    this.f = a.addAndGet(1);
  }
  
  private String a(String paramString)
  {
    return paramString + " Tunnel key: " + this.e.b();
  }
  
  private boolean b(RDBean paramRDBean)
  {
    return "rqd_applaunched".equals(paramRDBean.getEN());
  }
  
  public void a()
  {
    try
    {
      long l = EventStrategyBean.getInstance().getRealDelayUpload();
      com.tencent.beacon.core.a.d.a().a(this.f, this.g, 5000, l * 1000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/core/event/q:b	Z
    //   6: iload_1
    //   7: if_icmpeq +43 -> 50
    //   10: iload_1
    //   11: ifeq +42 -> 53
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 38	com/tencent/beacon/core/event/q:b	Z
    //   19: invokestatic 112	com/tencent/beacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/beacon/core/event/EventStrategyBean;
    //   22: invokevirtual 116	com/tencent/beacon/core/event/EventStrategyBean:getRealDelayUpload	()I
    //   25: i2l
    //   26: lstore_2
    //   27: invokestatic 121	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   30: aload_0
    //   31: getfield 71	com/tencent/beacon/core/event/q:f	I
    //   34: aload_0
    //   35: getfield 45	com/tencent/beacon/core/event/q:g	Ljava/lang/Runnable;
    //   38: sipush 5000
    //   41: i2l
    //   42: lload_2
    //   43: ldc2_w 122
    //   46: lmul
    //   47: invokevirtual 126	com/tencent/beacon/core/a/d:a	(ILjava/lang/Runnable;JJ)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 121	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   56: aload_0
    //   57: getfield 71	com/tencent/beacon/core/event/q:f	I
    //   60: iconst_1
    //   61: invokevirtual 130	com/tencent/beacon/core/a/d:a	(IZ)V
    //   64: aload_0
    //   65: iconst_1
    //   66: invokevirtual 132	com/tencent/beacon/core/event/q:b	(Z)V
    //   69: aload_0
    //   70: iload_1
    //   71: putfield 38	com/tencent/beacon/core/event/q:b	Z
    //   74: goto -24 -> 50
    //   77: astore 4
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	q
    //   0	84	1	paramBoolean	boolean
    //   26	17	2	l	long
    //   77	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	77	finally
    //   14	50	77	finally
    //   53	74	77	finally
  }
  
  public boolean a(RDBean paramRDBean)
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
        com.tencent.beacon.core.e.d.f("[event] eN:%s", new Object[] { localObject });
        if ((this.d == null) || (paramRDBean == null))
        {
          com.tencent.beacon.core.e.d.b(a("[realtime event] context is null or bean is null !"), new Object[0]);
          return bool;
          localObject = paramRDBean.getEN();
          continue;
        }
        if (!e())
        {
          com.tencent.beacon.core.e.d.b(a("[realtime event] disable process."), new Object[0]);
          continue;
        }
        this.c.add(paramRDBean);
      }
      finally {}
      localObject = EventStrategyBean.getInstance();
      int i = ((EventStrategyBean)localObject).getRealNumUpload();
      long l = 1000L * ((EventStrategyBean)localObject).getRealDelayUpload();
      int j = this.c.size();
      com.tencent.beacon.core.e.d.a(a("[realtime event] realtime event buff num: " + this.c.size()), new Object[0]);
      if ((b(paramRDBean)) || (j >= i) || (paramRDBean.isImmediatelyUpload()))
      {
        com.tencent.beacon.core.e.d.f(a("[realtime event] upload by max num or immediate."), new Object[0]);
        com.tencent.beacon.core.a.d.a().a(this.g);
        com.tencent.beacon.core.a.d.a().a(this.f, this.g, l, l);
      }
      localObject = k.a(this.d).d().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((l)((Iterator)localObject).next()).incRealTimeEventCalls();
      }
      com.tencent.beacon.core.e.d.a(a("[realtime event] eventName:" + paramRDBean.getEN() + ", processUA:true!"), new Object[0]);
      bool = true;
    }
  }
  
  protected void b()
  {
    Object localObject = d();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 db"), new Object[0]);
      localObject = t.a(this.d, this.e.b(), (List)localObject);
      if (localObject != null)
      {
        Iterator localIterator = k.a(this.d).d().iterator();
        while (localIterator.hasNext()) {
          ((l)localIterator.next()).incRealTimeEventWriteSucc(localObject.length);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    com.tencent.beacon.core.e.d.e(a("[realtime event] flush memory objects to db."), new Object[0]);
    if (paramBoolean)
    {
      b();
      return;
    }
    com.tencent.beacon.core.a.d.a().a(this.h);
  }
  
  protected void c()
  {
    if (!e()) {
      com.tencent.beacon.core.e.d.b(a("[realtime event] disable upload."), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return;
      localObject1 = d();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = k.a(this.d);
        EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
        if ((e.c(this.d)) && (localObject2 != null) && (localEventStrategyBean.isZeroPeakUploadByRate())) {
          break;
        }
        com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 db"), new Object[0]);
        localObject1 = t.a(this.d, this.e.b(), (List)localObject1);
        if (localObject1 != null)
        {
          localObject2 = k.a(this.d).d().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((l)((Iterator)localObject2).next()).incRealTimeEventWriteSucc(localObject1.length);
          }
        }
      }
    }
    com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 upload"), new Object[0]);
    ((j)localObject2).a(new r(this.d, this.e.b(), (List)localObject1));
  }
  
  /* Error */
  public List<RDBean> d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/beacon/core/event/q:c	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +21 -> 29
    //   11: aload_2
    //   12: invokeinterface 161 1 0
    //   17: ifle +12 -> 29
    //   20: aload_0
    //   21: invokevirtual 148	com/tencent/beacon/core/event/q:e	()Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +9 -> 35
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: areturn
    //   35: new 54	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 250	java/util/ArrayList:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 63	com/tencent/beacon/core/event/q:c	Ljava/util/List;
    //   48: invokeinterface 254 2 0
    //   53: pop
    //   54: aload_0
    //   55: getfield 63	com/tencent/beacon/core/event/q:c	Ljava/util/List;
    //   58: invokeinterface 257 1 0
    //   63: aload_0
    //   64: new 77	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 259
    //   74: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_2
    //   78: invokeinterface 161 1 0
    //   83: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 75	com/tencent/beacon/core/event/q:a	(Ljava/lang/String;)Ljava/lang/String;
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 168	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: goto -68 -> 31
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	q
    //   24	2	1	bool	boolean
    //   6	72	2	localObject1	Object
    //   102	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	102	finally
    //   11	25	102	finally
    //   35	99	102	finally
  }
  
  public boolean e()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.q
 * JD-Core Version:    0.7.0.1
 */