package com.tencent.beacon.d.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.module.StatModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class c
  implements Application.ActivityLifecycleCallbacks
{
  private static SparseArray<WeakReference<Activity>> a = new SparseArray();
  private boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 20000L;
  private String f = "";
  private Map<String, String> g;
  private StatModule h;
  
  public c(StatModule paramStatModule)
  {
    this.h = paramStatModule;
    this.g = new HashMap(6);
    this.g.put("A63", "N");
    this.g.put("A66", "F");
  }
  
  public static SparseArray<WeakReference<Activity>> a()
  {
    return a;
  }
  
  private void a(Activity paramActivity)
  {
    com.tencent.beacon.a.c.b.d = true;
    b(paramActivity);
    if (!this.b)
    {
      com.tencent.beacon.base.util.c.a("[event] lifecycle callback recover active user.", new Object[0]);
      com.tencent.beacon.a.b.a.a().a(new b(this, paramActivity));
      this.b = true;
    }
    if (c()) {
      d();
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity)
  {
    if (paramBoolean)
    {
      l1 = System.currentTimeMillis();
      if (this.c > 0L)
      {
        l2 = this.d;
        if ((l2 > 0L) && (l2 + b() <= l1))
        {
          com.tencent.beacon.base.util.c.a("[lifecycle] -> return foreground more than 20s.", new Object[0]);
          d();
          paramActivity = this.h;
          if (paramActivity != null) {
            paramActivity.a();
          }
        }
      }
      this.c = l1;
      this.d = 0L;
      return;
    }
    this.d = System.currentTimeMillis();
    long l1 = this.c;
    long l2 = this.d;
    if (800L + l1 > l2)
    {
      com.tencent.beacon.base.util.c.a("[lifecycle] -> debounce activity switch.", new Object[0]);
      this.c = 0L;
      return;
    }
    if (l1 == 0L) {
      this.c = l2;
    }
    paramActivity = this.h;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  private long b()
  {
    String str;
    if (this.e <= 20000L)
    {
      str = com.tencent.beacon.e.a.a().b("hotLauncher");
      if (str == null) {}
    }
    try
    {
      this.e = Long.valueOf(str).longValue();
      com.tencent.beacon.base.util.c.a("[strategy] -> change launcher time: %s ms", new Object[] { str });
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label51:
      break label51;
    }
    com.tencent.beacon.base.util.c.b("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
    this.e += 1L;
    return this.e;
  }
  
  private static void b(Activity paramActivity)
  {
    if ((paramActivity != null) && (a != null))
    {
      int i = paramActivity.hashCode();
      if (a.get(i) == null)
      {
        paramActivity = new WeakReference(paramActivity);
        a.put(i, paramActivity);
      }
    }
  }
  
  private boolean c()
  {
    String str = com.tencent.beacon.base.util.b.c();
    if ("".equals(this.f)) {
      this.f = com.tencent.beacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
    }
    boolean bool3 = str.equals(this.f);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bool3)
    {
      com.tencent.beacon.a.d.a.a().edit().putString("LAUEVE_DENGTA", str);
      bool1 = bool2;
      if (!"".equals(this.f))
      {
        com.tencent.beacon.base.util.c.a("[core] -> report new day launcher event.", new Object[0]);
        bool1 = true;
      }
      this.f = str;
    }
    return bool1;
  }
  
  private void d()
  {
    com.tencent.beacon.a.b.a.a().a(new a(this));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
    a(true, paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity);
    a(false, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.d.a.c
 * JD-Core Version:    0.7.0.1
 */