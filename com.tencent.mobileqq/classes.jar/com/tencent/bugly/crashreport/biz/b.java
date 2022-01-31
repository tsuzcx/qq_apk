package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

public class b
{
  public static boolean a;
  public static a b;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g;
  private static long h;
  private static long i;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k = null;
  private static Class<?> l = null;
  private static boolean m = true;
  
  public static void a()
  {
    if (b != null) {
      b.a(2, false, 0L);
    }
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    if (a) {
      return;
    }
    m = com.tencent.bugly.crashreport.common.info.a.a(paramContext).f;
    b = new a(paramContext, m);
    a = true;
    if (paramBuglyStrategy != null) {
      l = paramBuglyStrategy.getUserInfoActivity();
    }
    for (long l1 = paramBuglyStrategy.getAppReportDelay();; l1 = 0L)
    {
      if (l1 <= 0L)
      {
        c(paramContext, paramBuglyStrategy);
        return;
      }
      w.a().a(new b.1(paramContext, paramBuglyStrategy), l1);
      return;
    }
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    if ((b != null) && (!paramBoolean))
    {
      a locala = b;
      w localw = w.a();
      if (localw != null) {
        localw.a(new a.2(locala));
      }
    }
    if (paramStrategyBean == null) {}
    do
    {
      return;
      if (paramStrategyBean.p > 0L) {
        e = paramStrategyBean.p;
      }
      if (paramStrategyBean.v > 0) {
        c = paramStrategyBean.v;
      }
    } while (paramStrategyBean.w <= 0L);
    d = paramStrategyBean.w;
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    boolean bool2;
    boolean bool1;
    if (paramBuglyStrategy != null)
    {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    }
    for (;;)
    {
      int n;
      Object localObject2;
      if (bool2)
      {
        paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
        localObject1 = paramBuglyStrategy.d;
        localObject1 = b.a((String)localObject1);
        if (localObject1 != null)
        {
          n = 0;
          if (n < ((List)localObject1).size())
          {
            localObject2 = (UserInfoBean)((List)localObject1).get(n);
            if ((((UserInfoBean)localObject2).n.equals(paramBuglyStrategy.l)) && (((UserInfoBean)localObject2).b == 1))
            {
              long l1 = z.b();
              if (l1 <= 0L) {
                break label172;
              }
              if (((UserInfoBean)localObject2).e >= l1) {
                if (((UserInfoBean)localObject2).f <= 0L)
                {
                  paramBuglyStrategy = b;
                  localObject1 = w.a();
                  if (localObject1 != null) {
                    ((w)localObject1).a(new a.2(paramBuglyStrategy));
                  }
                }
              }
            }
          }
        }
        label172:
        for (n = 0;; n = 1)
        {
          if (n != 0) {
            break label177;
          }
          return;
          n += 1;
          break;
        }
        label177:
        bool1 = false;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.b();
      if (localObject1 != null)
      {
        int i1 = 0;
        localObject2 = Thread.currentThread().getStackTrace();
        int i2 = localObject2.length;
        paramBuglyStrategy = null;
        n = 0;
        while (n < i2)
        {
          Object localObject3 = localObject2[n];
          if (localObject3.getMethodName().equals("onCreate")) {
            paramBuglyStrategy = localObject3.getClassName();
          }
          if (localObject3.getClassName().equals("android.app.Activity")) {
            i1 = 1;
          }
          n += 1;
        }
        if (paramBuglyStrategy == null) {
          break label412;
        }
        if (i1 == 0) {
          break label405;
        }
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).a(true);
      }
      for (;;)
      {
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).r = paramBuglyStrategy;
        if (bool1)
        {
          paramBuglyStrategy = null;
          if (Build.VERSION.SDK_INT >= 14)
          {
            if ((paramContext.getApplicationContext() instanceof Application)) {
              paramBuglyStrategy = (Application)paramContext.getApplicationContext();
            }
            if (paramBuglyStrategy == null) {}
          }
        }
        try
        {
          if (k == null) {
            k = new b.2();
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            if (!x.a(paramContext)) {
              paramContext.printStackTrace();
            }
          }
        }
        if (!m) {
          break;
        }
        i = System.currentTimeMillis();
        b.a(1, false, 0L);
        x.a("[session] launch app, new start", new Object[0]);
        b.a();
        paramContext = b;
        w.a().a(new a.c(paramContext, 21600000L), 21600000L);
        return;
        label405:
        paramBuglyStrategy = "background";
        continue;
        label412:
        paramBuglyStrategy = "unknown";
      }
      bool1 = true;
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.b
 * JD-Core Version:    0.7.0.1
 */