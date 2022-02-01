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
  private static a c;
  private static String i;
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
    if ((!z.a(paramString)) && (z.c(paramString)))
    {
      i = paramString;
      return;
    }
    x.d("URL user set is invalid.", new Object[0]);
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
    this.e.a(new a.1(this), paramLong);
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
    if (paramap == null) {
      return;
    }
    if ((this.g != null) && (paramap.h == this.g.o)) {
      return;
    }
    StrategyBean localStrategyBean = new StrategyBean();
    localStrategyBean.f = paramap.a;
    localStrategyBean.h = paramap.c;
    localStrategyBean.g = paramap.b;
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
      localStrategyBean.s = paramap.f.a;
    }
    if (paramap.h != 0L) {
      localStrategyBean.o = paramap.h;
    }
    if ((paramap.g != null) && (paramap.g.size() > 0))
    {
      localStrategyBean.t = paramap.g;
      String str1 = (String)paramap.g.get("B11");
      if ((str1 != null) && (str1.equals("1"))) {
        localStrategyBean.i = true;
      } else {
        localStrategyBean.i = false;
      }
      str1 = (String)paramap.g.get("B3");
      if (str1 != null) {
        localStrategyBean.w = Long.valueOf(str1).longValue();
      }
      localStrategyBean.p = paramap.i;
      localStrategyBean.v = paramap.i;
      str1 = (String)paramap.g.get("B27");
      if ((str1 != null) && (str1.length() > 0)) {
        try
        {
          int j = Integer.parseInt(str1);
          if (j > 0) {
            localStrategyBean.u = j;
          }
        }
        catch (Exception localException)
        {
          if (!x.a(localException)) {
            localException.printStackTrace();
          }
        }
      }
      String str2 = (String)paramap.g.get("B25");
      if ((str2 != null) && (str2.equals("1"))) {
        localStrategyBean.k = true;
      } else {
        localStrategyBean.k = false;
      }
    }
    x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.f), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.j), Boolean.valueOf(localStrategyBean.m), Boolean.valueOf(localStrategyBean.n), Long.valueOf(localStrategyBean.p), Boolean.valueOf(localStrategyBean.k), Long.valueOf(localStrategyBean.o) });
    this.g = localStrategyBean;
    if (!z.c(paramap.d))
    {
      x.c("[Strategy] download url is null", new Object[0]);
      this.g.q = "";
    }
    if (!z.c(paramap.e))
    {
      x.c("[Strategy] download crashurl is null", new Object[0]);
      this.g.r = "";
    }
    p.a().b(2);
    paramap = new r();
    paramap.b = 2;
    paramap.a = localStrategyBean.d;
    paramap.e = localStrategyBean.e;
    paramap.g = z.a(localStrategyBean);
    p.a().a(paramap);
    a(localStrategyBean, true);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/bugly/crashreport/common/strategy/a:g	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
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
    //   25: goto +5 -> 30
    //   28: aload_2
    //   29: athrow
    //   30: goto -2 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localStrategyBean	StrategyBean
    //   22	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final StrategyBean c()
  {
    StrategyBean localStrategyBean = this.g;
    if (localStrategyBean != null)
    {
      if (!z.c(localStrategyBean.q)) {
        this.g.q = StrategyBean.b;
      }
      if (!z.c(this.g.r)) {
        this.g.r = StrategyBean.c;
      }
      return this.g;
    }
    if ((!z.a(i)) && (z.c(i)))
    {
      localStrategyBean = this.f;
      String str = i;
      localStrategyBean.q = str;
      localStrategyBean.r = str;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a
 * JD-Core Version:    0.7.0.1
 */