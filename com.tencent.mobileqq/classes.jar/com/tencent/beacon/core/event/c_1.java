package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.d.l;
import com.tencent.beacon.core.e.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class c
  implements n
{
  private static AtomicInteger a = new AtomicInteger(1000);
  final Context b;
  boolean c = false;
  private final Object d = new Object();
  private final Object e = new Object();
  protected final List<RDBean> f = new ArrayList(25);
  private int g = 60000;
  private h h;
  private final int i;
  protected Runnable j = new a(this);
  
  public c(Context paramContext, h paramh)
  {
    this.b = paramContext;
    this.h = paramh;
    this.i = a.addAndGet(1);
  }
  
  private String a(String paramString)
  {
    return paramString + " Tunnel key: " + this.h.b();
  }
  
  private List<RDBean> f()
  {
    synchronized (this.f)
    {
      if ((this.f.size() <= 0) || (!c())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.f);
      this.f.clear();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.beacon.core.e.d.a(a("[event] getListInMemory: buffer event size:" + localArrayList.size()), new Object[0]);
      return localArrayList;
    }
  }
  
  public void a()
  {
    try
    {
      this.g = (EventStrategyBean.getInstance().getComDelayDB() * 1000);
      com.tencent.beacon.core.a.d locald = com.tencent.beacon.core.a.d.a();
      int k = this.i;
      Runnable localRunnable = b(true, null);
      int m = this.g;
      locald.a(k, localRunnable, m, m);
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
    //   3: getfield 41	com/tencent/beacon/core/event/c:c	Z
    //   6: iload_1
    //   7: if_icmpeq +61 -> 68
    //   10: iload_1
    //   11: ifeq +60 -> 71
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 41	com/tencent/beacon/core/event/c:c	Z
    //   19: aload_0
    //   20: invokestatic 125	com/tencent/beacon/core/event/EventStrategyBean:getInstance	()Lcom/tencent/beacon/core/event/EventStrategyBean;
    //   23: invokevirtual 128	com/tencent/beacon/core/event/EventStrategyBean:getComDelayDB	()I
    //   26: sipush 1000
    //   29: imul
    //   30: putfield 53	com/tencent/beacon/core/event/c:g	I
    //   33: invokestatic 133	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 70	com/tencent/beacon/core/event/c:i	I
    //   42: istore_2
    //   43: aload_0
    //   44: iconst_1
    //   45: aconst_null
    //   46: invokevirtual 136	com/tencent/beacon/core/event/c:b	(ZLjava/util/List;)Ljava/lang/Runnable;
    //   49: astore 5
    //   51: aload_0
    //   52: getfield 53	com/tencent/beacon/core/event/c:g	I
    //   55: istore_3
    //   56: aload 4
    //   58: iload_2
    //   59: aload 5
    //   61: iload_3
    //   62: i2l
    //   63: iload_3
    //   64: i2l
    //   65: invokevirtual 139	com/tencent/beacon/core/a/d:a	(ILjava/lang/Runnable;JJ)V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: invokestatic 133	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   74: aload_0
    //   75: getfield 70	com/tencent/beacon/core/event/c:i	I
    //   78: iconst_1
    //   79: invokevirtual 143	com/tencent/beacon/core/a/d:a	(IZ)V
    //   82: invokestatic 133	com/tencent/beacon/core/a/d:a	()Lcom/tencent/beacon/core/a/d;
    //   85: bipush 102
    //   87: iconst_1
    //   88: invokevirtual 143	com/tencent/beacon/core/a/d:a	(IZ)V
    //   91: aload_0
    //   92: iconst_1
    //   93: invokevirtual 145	com/tencent/beacon/core/event/c:b	(Z)V
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 41	com/tencent/beacon/core/event/c:c	Z
    //   101: goto -33 -> 68
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	c
    //   0	111	1	paramBoolean	boolean
    //   42	17	2	k	int
    //   55	9	3	m	int
    //   36	21	4	locald	com.tencent.beacon.core.a.d
    //   104	5	4	localObject	Object
    //   49	11	5	localRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	10	104	finally
    //   14	68	104	finally
    //   71	101	104	finally
  }
  
  protected void a(boolean paramBoolean, List<RDBean> paramList)
  {
    boolean bool;
    synchronized (this.e)
    {
      bool = c();
      if (!bool)
      {
        com.tencent.beacon.core.e.d.b(a("[event] err disable."), new Object[0]);
        return;
      }
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = f();
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label221;
      }
      paramList = t.a(this.b, this.h.b(), (List)localObject1);
      if (paramList != null)
      {
        localObject1 = k.a(this.b).d().iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((l)((Iterator)localObject1).next()).incCommonEventWriteSucc(paramList.length);
        }
      }
    }
    Object localObject1 = k.a(this.b);
    if ((paramList != null) && (d()) && (((k)localObject1).f()) && (((k)localObject1).e()))
    {
      bool = EventStrategyBean.getInstance().isZeroPeakUploadByRate();
      if (!bool)
      {
        com.tencent.beacon.core.e.d.e(a("[event] max but not up(zeroPeak)!"), new Object[0]);
        return;
      }
      c(paramBoolean);
      com.tencent.beacon.core.e.d.e(a("[event] max then up"), new Object[0]);
    }
    for (;;)
    {
      return;
      label221:
      if (e())
      {
        c(paramBoolean);
        com.tencent.beacon.core.e.d.e(a("[event] polling then up"), new Object[0]);
      }
    }
  }
  
  public boolean a(RDBean paramRDBean)
  {
    synchronized (this.d)
    {
      String str = a("[event] eN:%s");
      if (paramRDBean == null) {}
      for (??? = "null";; ??? = paramRDBean.getEN())
      {
        com.tencent.beacon.core.e.d.f(str, new Object[] { ??? });
        ??? = this.b;
        if ((??? != null) && (paramRDBean != null)) {
          break;
        }
        com.tencent.beacon.core.e.d.b(a("[event] err return."), new Object[0]);
        return false;
      }
      boolean bool = c();
      if (!bool)
      {
        com.tencent.beacon.core.e.d.b(a("[event] return false, isEnable is false !"), new Object[0]);
        return false;
      }
    }
    ??? = EventStrategyBean.getInstance();
    int k = ((EventStrategyBean)???).getComNumDB();
    this.g = (((EventStrategyBean)???).getComDelayDB() * 1000);
    synchronized (this.f)
    {
      this.f.add(paramRDBean);
      int m = this.f.size();
      paramRDBean = new StringBuilder();
      com.tencent.beacon.core.e.d.f(a("[event] event buff num：" + m), new Object[0]);
      if (m >= k)
      {
        paramRDBean = new StringBuilder();
        com.tencent.beacon.core.e.d.f(a("[event] max num .  size : " + m), new Object[0]);
        paramRDBean = f();
        com.tencent.beacon.core.a.d.a().a(b(false, paramRDBean));
        com.tencent.beacon.core.a.d.a().a(this.i, b(true, null), this.g, this.g);
      }
      paramRDBean = k.a(this.b).d().iterator();
      while (paramRDBean.hasNext()) {
        ((l)paramRDBean.next()).incCommonEventCalls();
      }
      com.tencent.beacon.core.e.d.d(a("[event] process UA:true!"), new Object[0]);
      return true;
    }
  }
  
  protected Runnable b(boolean paramBoolean, List<RDBean> paramList)
  {
    return new b(this, paramBoolean, paramList);
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 249
    //   5: invokespecial 74	com/tencent/beacon/core/event/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 117	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: invokevirtual 101	com/tencent/beacon/core/event/c:c	()Z
    //   19: ifne +19 -> 38
    //   22: aload_0
    //   23: ldc 148
    //   25: invokespecial 74	com/tencent/beacon/core/event/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 150	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: invokespecial 152	com/tencent/beacon/core/event/c:f	()Ljava/util/List;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -9 -> 35
    //   47: aload_1
    //   48: invokeinterface 98 1 0
    //   53: ifle -18 -> 35
    //   56: aload_0
    //   57: getfield 62	com/tencent/beacon/core/event/c:b	Landroid/content/Context;
    //   60: aload_0
    //   61: getfield 64	com/tencent/beacon/core/event/c:h	Lcom/tencent/beacon/core/event/h;
    //   64: invokevirtual 88	com/tencent/beacon/core/event/h:b	()Ljava/lang/String;
    //   67: aload_1
    //   68: invokestatic 157	com/tencent/beacon/core/event/t:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)[Ljava/lang/Long;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull -38 -> 35
    //   76: aload_0
    //   77: getfield 62	com/tencent/beacon/core/event/c:b	Landroid/content/Context;
    //   80: invokestatic 162	com/tencent/beacon/core/d/k:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/d/k;
    //   83: invokevirtual 165	com/tencent/beacon/core/d/k:d	()Ljava/util/ArrayList;
    //   86: invokevirtual 169	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   89: astore_2
    //   90: aload_2
    //   91: invokeinterface 174 1 0
    //   96: ifeq -61 -> 35
    //   99: aload_2
    //   100: invokeinterface 178 1 0
    //   105: checkcast 180	com/tencent/beacon/core/d/l
    //   108: aload_1
    //   109: arraylength
    //   110: invokeinterface 183 2 0
    //   115: goto -25 -> 90
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	c
    //   42	67	1	localObject1	Object
    //   118	4	1	localObject2	Object
    //   89	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	35	118	finally
    //   38	43	118	finally
    //   47	72	118	finally
    //   76	90	118	finally
    //   90	115	118	finally
  }
  
  public void b(boolean paramBoolean)
  {
    com.tencent.beacon.core.e.d.e(a("[event] process flush memory objects to db."), new Object[0]);
    if (paramBoolean)
    {
      b();
      return;
    }
    com.tencent.beacon.core.a.d.a().a(this.j);
  }
  
  protected void c(boolean paramBoolean)
  {
    com.tencent.beacon.core.e.d.f(a("[event] -> do max size upload task."), new Object[0]);
    try
    {
      this.h.a(paramBoolean, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  protected boolean d()
  {
    long l2 = EventStrategyBean.getInstance().getComNumUpload();
    long l1 = l2;
    if (e.d(this.b))
    {
      com.tencent.beacon.core.e.d.e(a("[event] on wifi, so half mSZ " + l2), new Object[0]);
      l1 = l2 / 2L;
    }
    int k = t.a(this.b, this.h.b());
    com.tencent.beacon.core.e.d.a(a("[event] recordNum: " + k + ", maxNum: " + l1), new Object[0]);
    return k >= l1;
  }
  
  protected boolean e()
  {
    EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
    if (localEventStrategyBean != null) {
      return localEventStrategyBean.isComPollUp();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.c
 * JD-Core Version:    0.7.0.1
 */