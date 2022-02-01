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
  public static boolean a = false;
  public static a b;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g = 0;
  private static long h = 0L;
  private static long i = 0L;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k;
  private static Class<?> l;
  private static boolean m = true;
  
  public static void a()
  {
    a locala = b;
    if (locala != null) {
      locala.a(2, false, 0L);
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
    long l1;
    if (paramBuglyStrategy != null)
    {
      l = paramBuglyStrategy.getUserInfoActivity();
      l1 = paramBuglyStrategy.getAppReportDelay();
    }
    else
    {
      l1 = 0L;
    }
    if (l1 <= 0L)
    {
      c(paramContext, paramBuglyStrategy);
      return;
    }
    w.a().a(new b.1(paramContext, paramBuglyStrategy), l1);
  }
  
  public static void a(StrategyBean paramStrategyBean, boolean paramBoolean)
  {
    a locala = b;
    if ((locala != null) && (!paramBoolean))
    {
      w localw = w.a();
      if (localw != null) {
        localw.a(new a.2(locala));
      }
    }
    if (paramStrategyBean == null) {
      return;
    }
    if (paramStrategyBean.p > 0L) {
      e = paramStrategyBean.p;
    }
    if (paramStrategyBean.u > 0) {
      c = paramStrategyBean.u;
    }
    if (paramStrategyBean.v > 0L) {
      d = paramStrategyBean.v;
    }
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
    else
    {
      bool1 = true;
      bool2 = false;
    }
    int n;
    if (bool2)
    {
      paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      localObject1 = paramBuglyStrategy.d;
      localObject1 = b.a((String)localObject1);
      if (localObject1 != null)
      {
        n = 0;
        while (n < ((List)localObject1).size())
        {
          localObject2 = (UserInfoBean)((List)localObject1).get(n);
          if ((((UserInfoBean)localObject2).n.equals(paramBuglyStrategy.m)) && (((UserInfoBean)localObject2).b == 1))
          {
            long l1 = z.b();
            if (l1 <= 0L) {
              break;
            }
            if (((UserInfoBean)localObject2).e >= l1)
            {
              if (((UserInfoBean)localObject2).f <= 0L)
              {
                paramBuglyStrategy = b;
                localObject1 = w.a();
                if (localObject1 != null) {
                  ((w)localObject1).a(new a.2(paramBuglyStrategy));
                }
              }
              n = 0;
              break label181;
            }
          }
          n += 1;
        }
      }
      n = 1;
      label181:
      if (n == 0) {
        return;
      }
      bool1 = false;
    }
    Object localObject2 = com.tencent.bugly.crashreport.common.info.a.b();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i2 = arrayOfStackTraceElement.length;
      paramBuglyStrategy = null;
      n = 0;
      int i1 = 0;
      while (n < i2)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[n];
        if (localStackTraceElement.getMethodName().equals("onCreate")) {
          paramBuglyStrategy = localStackTraceElement.getClassName();
        }
        if (localStackTraceElement.getClassName().equals("android.app.Activity")) {
          i1 = 1;
        }
        n += 1;
      }
      if (paramBuglyStrategy != null)
      {
        if (i1 != 0) {
          ((com.tencent.bugly.crashreport.common.info.a)localObject2).a(true);
        } else {
          paramBuglyStrategy = "background";
        }
      }
      else {
        paramBuglyStrategy = "unknown";
      }
      ((com.tencent.bugly.crashreport.common.info.a)localObject2).s = paramBuglyStrategy;
    }
    if ((bool1) && (Build.VERSION.SDK_INT >= 14))
    {
      paramBuglyStrategy = (BuglyStrategy)localObject1;
      if ((paramContext.getApplicationContext() instanceof Application)) {
        paramBuglyStrategy = (Application)paramContext.getApplicationContext();
      }
      if (paramBuglyStrategy != null) {
        try
        {
          if (k == null) {
            k = new b.2();
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          if (!x.a(paramContext)) {
            paramContext.printStackTrace();
          }
        }
      }
    }
    if (m)
    {
      i = System.currentTimeMillis();
      b.a(1, false, 0L);
      x.a("[session] launch app, new start", new Object[0]);
      b.a();
      paramContext = b;
      w.a().a(new a.c(paramContext, 21600000L), 21600000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.b
 * JD-Core Version:    0.7.0.1
 */