package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ar;
import com.tencent.bugly.proguard.as;
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
  
  public final void a(as paramas)
  {
    if (paramas == null) {}
    while ((this.g != null) && (paramas.h == this.g.p)) {
      return;
    }
    localStrategyBean = new StrategyBean();
    localStrategyBean.g = paramas.a;
    localStrategyBean.i = paramas.c;
    localStrategyBean.h = paramas.b;
    if ((z.a(i)) || (!z.c(i)))
    {
      if (z.c(paramas.d))
      {
        x.c("[Strategy] Upload url changes to %s", new Object[] { paramas.d });
        localStrategyBean.r = paramas.d;
      }
      if (z.c(paramas.e))
      {
        x.c("[Strategy] Exception upload url changes to %s", new Object[] { paramas.e });
        localStrategyBean.s = paramas.e;
      }
    }
    if ((paramas.f != null) && (!z.a(paramas.f.a))) {
      localStrategyBean.u = paramas.f.a;
    }
    if (paramas.h != 0L) {
      localStrategyBean.p = paramas.h;
    }
    String str;
    if ((paramas.g != null) && (paramas.g.size() > 0))
    {
      localStrategyBean.v = paramas.g;
      str = (String)paramas.g.get("B11");
      if ((str == null) || (!str.equals("1"))) {
        break label633;
      }
    }
    label633:
    for (localStrategyBean.j = true;; localStrategyBean.j = false)
    {
      str = (String)paramas.g.get("B3");
      if (str != null) {
        localStrategyBean.y = Long.valueOf(str).longValue();
      }
      localStrategyBean.q = paramas.i;
      localStrategyBean.x = paramas.i;
      str = (String)paramas.g.get("B27");
      if ((str != null) && (str.length() > 0)) {}
      try
      {
        int j = Integer.parseInt(str);
        if (j > 0) {
          localStrategyBean.w = j;
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
      str = (String)paramas.g.get("B25");
      if ((str == null) || (!str.equals("1"))) {
        break;
      }
      localStrategyBean.l = true;
      x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", new Object[] { Boolean.valueOf(localStrategyBean.g), Boolean.valueOf(localStrategyBean.i), Boolean.valueOf(localStrategyBean.h), Boolean.valueOf(localStrategyBean.j), Boolean.valueOf(localStrategyBean.k), Boolean.valueOf(localStrategyBean.n), Boolean.valueOf(localStrategyBean.o), Long.valueOf(localStrategyBean.q), Boolean.valueOf(localStrategyBean.l), Long.valueOf(localStrategyBean.p) });
      this.g = localStrategyBean;
      if (!z.c(paramas.d))
      {
        x.c("[Strategy] download url is null", new Object[0]);
        this.g.r = "";
      }
      if (!z.c(paramas.e))
      {
        x.c("[Strategy] download crashurl is null", new Object[0]);
        this.g.s = "";
      }
      p.a().b(2);
      paramas = new r();
      paramas.b = 2;
      paramas.a = localStrategyBean.e;
      paramas.e = localStrategyBean.f;
      paramas.g = z.a(localStrategyBean);
      p.a().a(paramas);
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
    //   3: getfield 37	com/tencent/bugly/crashreport/common/strategy/a:g	Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
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
    if (this.g != null)
    {
      if (!z.c(this.g.r)) {
        this.g.r = StrategyBean.b;
      }
      if (!z.c(this.g.s)) {
        this.g.s = StrategyBean.c;
      }
      return this.g;
    }
    if ((!z.a(i)) && (z.c(i)))
    {
      this.f.r = i;
      this.f.s = i;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.common.strategy.a
 * JD-Core Version:    0.7.0.1
 */