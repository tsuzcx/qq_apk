package com.tencent.beacon.core.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.core.e.b;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.c;
import java.lang.ref.WeakReference;
import java.util.Map;

@TargetApi(14)
public class j
  implements Application.ActivityLifecycleCallbacks
{
  private static SparseArray<WeakReference<Activity>> a = new SparseArray();
  private boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 20000L;
  private String f = "";
  private Map<String, String> g = null;
  
  public j()
  {
    this.g.put("A63", "N");
    this.g.put("A66", "F");
  }
  
  private long a()
  {
    String str;
    if (this.e <= 20000L)
    {
      str = c.g().b("hotLauncher");
      if (str == null) {}
    }
    try
    {
      this.e = Long.valueOf(str).longValue();
      com.tencent.beacon.core.e.d.a("[strategy] -> change launcher time: %s ms", new Object[] { str });
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        com.tencent.beacon.core.e.d.b("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
      }
    }
    this.e += 1L;
    return this.e;
  }
  
  private void a(Activity paramActivity)
  {
    com.tencent.beacon.core.info.a.f = true;
    b(paramActivity);
    if (!this.b)
    {
      com.tencent.beacon.core.e.d.a("[event] lifecycle callback recover active user.", new Object[0]);
      d.a().a(new i(this, paramActivity));
      this.b = true;
    }
    if (a(paramActivity)) {
      c(paramActivity);
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity)
  {
    UserEventModule localUserEventModule = UserEventModule.getInstance();
    if (paramBoolean)
    {
      l1 = System.currentTimeMillis();
      if (this.c > 0L)
      {
        l2 = this.d;
        if ((l2 > 0L) && (l2 + a() <= l1))
        {
          com.tencent.beacon.core.e.d.a("[lifecycle] -> return foreground more than 20s.", new Object[0]);
          c(paramActivity);
          if (localUserEventModule != null) {
            localUserEventModule.onAppHotLaunch();
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
      com.tencent.beacon.core.e.d.a("[lifecycle] -> debounce activity switch.", new Object[0]);
      this.c = 0L;
      return;
    }
    if (l1 == 0L) {
      this.c = l2;
    }
    if (localUserEventModule != null) {
      localUserEventModule.onAppStop();
    }
    TunnelModule.flushObjectsToDB(false);
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = b.a();
    if ("".equals(this.f)) {
      this.f = f.a(paramContext).a("LAUEVE_DENGTA", "");
    }
    if (!str.equals(this.f))
    {
      f.a(paramContext).b().a("LAUEVE_DENGTA", str).a();
      bool1 = bool2;
      if (!"".equals(this.f))
      {
        com.tencent.beacon.core.e.d.a("[core] -> report new day launcher event.", new Object[0]);
        bool1 = true;
      }
      this.f = str;
    }
    return bool1;
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
  
  private void c(Activity paramActivity)
  {
    d.a().a(new h(this, paramActivity));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.j
 * JD-Core Version:    0.7.0.1
 */