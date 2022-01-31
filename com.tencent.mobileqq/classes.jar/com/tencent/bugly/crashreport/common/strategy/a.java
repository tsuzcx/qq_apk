package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static int a = 1000;
  public static long b;
  private static a c = null;
  private static String i = null;
  private final List<com.tencent.bugly.a> d;
  private final w e;
  private final StrategyBean f;
  private StrategyBean g = null;
  private Context h;
  
  private a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    this.h = paramContext;
    this.f = new StrategyBean();
    this.d = paramList;
    this.e = w.a();
  }
  
  public static a a()
  {
    try
    {
      a locala = c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static a a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (c == null) {
        c = new a(paramContext, paramList);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((z.a(paramString)) || (!z.c(paramString)))
    {
      x.d("URL user set is invalid.", new Object[0]);
      return;
    }
    i = paramString;
  }
  
  public static StrategyBean d()
  {
    Object localObject = p.a().a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (r)((List)localObject).get(0);
      if (((r)localObject).g != null) {
        return (StrategyBean)z.a(((r)localObject).g, StrategyBean.CREATOR);
      }
    }
    return null;
  }
  
  public final void a(long paramLong)
  {
    this.e.a(new Thread()
    {
      public final void run()
      {
        try
        {
          Object localObject2 = p.a().a(a.a, null, true);
          if (localObject2 != null)
          {
            localObject1 = (byte[])((Map)localObject2).get("key_imei");
            localObject2 = (byte[])((Map)localObject2).get("key_ip");
            if (localObject1 != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).e(new String((byte[])localObject1));
            }
            if (localObject2 != null) {
              com.tencent.bugly.crashreport.common.info.a.a(a.a(a.this)).d(new String((byte[])localObject2));
            }
          }
          Object localObject1 = a.this;
          localObject2 = a.this;
          a.a((a)localObject1, a.d());
          if ((a.b(a.this) != null) && (!z.a(a.e())) && (z.c(a.e())))
          {
            a.b(a.this).q = a.e();
            a.b(a.this).r = a.e();
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (!x.a(localThrowable)) {
              localThrowable.printStackTrace();
            }
          }
        }
        a.this.a(a.b(a.this), false);
      }
    }, paramLong);
  }
  
  protected final void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    x.c("[Strategy] Notify %s", new Object[] { b.class.getName() });
    b.a(paramStrategyBean, paramBoolean);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.bugly.a locala = (com.tencent.bugly.a)localIterator.next();
      try
      {
        x.c("[Strategy] Notify %s", new Object[] { locala.getClass().getName() });
        locala.onServerStrategyChanged(paramStrategyBean);
      }
      catch (Throwable localThrowable) {}
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public final void a(ap paramap)
  {
    if (paramap == null) {}
    while ((this.g != null) && (paramap.h == this.g.o)) {
      return;
    }
    localStrategyBean = new StrategyBean();
    localStrategyBean.g = paramap.a;
    localStrategyBean.i = paramap.c;
    localStrategyBean.h = paramap.b;
    if ((z.a(i)) || (!z.c(i)))
    {
      if (z.c(paramap.d))
      {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramap.d });
        localStrategyBean.q = paramap.d;
      }
      if (z.c(paramap.e))
      {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramap.e });
        localStrategyBean.r = paramap.e;
      }
    }
    if ((paramap.f != null) && (!z.a(paramap.f.a))) {
      localStrategyBean.t = paramap.f.a;
    }
    if (paramap.h != 0L) {
      localStrategyBean.o = paramap.h;
    }
    String str;
    if ((paramap.g != null) && (paramap.g.size() > 0))
    {
      localStrategyBean.u = paramap.g;
      str = (String)paramap.g.get("B11");
      if ((str == null) || (!str.equals("1"))) {
        break label568;
      }
    }
    label568:
    for (localStrategyBean.j = true;; localStrategyBean.j = false)
    {
      str = (String)paramap.g.get("B3");
      if (str != null) {
        localStrategyBean.x = Long.valueOf(str).longValue();
      }
      localStrategyBean.p = paramap.i;
      localStrategyBean.w = paramap.i;
      str = (String)paramap.g.get("B27");
      if ((str != null) && (str.length() > 0)) {}
      try
      {
        int j = Integer.parseInt(str);
        if (j > 0) {
          localStrategyBean.v = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (!x.a(localException))
          {
            localException.printStackTrace();
            continue;
            localStrategyBean.l = false;
          }
        }
      }
      paramap = (String)paramap.g.get("B25");
      if ((paramap == null) || (!paramap.equals("1"))) {
        break;
      }
      localStrategyBean.l = true;
      x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.j), Boolean.valueOf(localStrategyBean.k), Boolean.valueOf(localStrategyBean.m), Boolean.valueOf(localStrategyBean.n), Long.valueOf(localStrategyBean.p), Boolean.valueOf(localStrategyBean.l), Long.valueOf(localStrategyBean.o) });
      this.g = localStrategyBean;
      p.a().b(2);
      paramap = new r();
      paramap.b = 2;
      paramap.a = localStrategyBean.e;
      paramap.e = localStrategyBean.f;
      paramap.g = z.a(localStrategyBean);
      p.a().a(paramap);
      a(localStrategyBean, true);
      return;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/bugly/crashreport/common/strategy/a:g	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localStrategyBean	StrategyBean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    if (this.g != null) {
      return this.g;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a
 * JD-Core Version:    0.7.0.1
 */