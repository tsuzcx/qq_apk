package com.tencent.beacon.core.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.a;
import java.lang.ref.WeakReference;
import java.util.Map;

@TargetApi(14)
public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private static SparseArray<WeakReference<Activity>> a = new SparseArray();
  private boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 20000L;
  private String f = "";
  private Map<String, String> g = null;
  
  public e()
  {
    this.g.put("A63", "N");
    this.g.put("A66", "F");
  }
  
  private void a(Activity paramActivity)
  {
    paramActivity = new e.1(this, paramActivity.getApplicationContext());
    b.b().a(paramActivity);
  }
  
  private void a(boolean paramBoolean, Activity paramActivity)
  {
    UserEventModule localUserEventModule = UserEventModule.getInstance();
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      if ((this.c > 0L) && (this.d > 0L) && (this.d + b() <= l))
      {
        com.tencent.beacon.core.d.b.b("[lifecycle] -> return foreground more than 20s.", new Object[0]);
        a(paramActivity);
        if (localUserEventModule != null) {
          localUserEventModule.onAppResumed();
        }
      }
      this.c = l;
      this.d = 0L;
      return;
    }
    this.d = System.currentTimeMillis();
    if (this.c + 800L > this.d)
    {
      com.tencent.beacon.core.d.b.b("[lifecycle] -> debounce activity switch.", new Object[0]);
      this.c = 0L;
      return;
    }
    if (this.c == 0L) {
      this.c = this.d;
    }
    if (localUserEventModule != null) {
      localUserEventModule.onAppStop();
    }
    TunnelModule.flushObjectsToDB(false);
  }
  
  private long b()
  {
    String str;
    if (this.e <= 20000L)
    {
      str = a.a().b("hotLauncher");
      if (str == null) {}
    }
    try
    {
      this.e = Long.valueOf(str).longValue();
      com.tencent.beacon.core.d.b.b("[strategy] -> change launcher time: %s ms", new Object[] { str });
      this.e += 1L;
      return this.e;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        com.tencent.beacon.core.d.b.d("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
      }
    }
  }
  
  private void b(Activity paramActivity)
  {
    int i = 1;
    com.tencent.beacon.core.b.a.a = true;
    if ((paramActivity != null) && (a != null))
    {
      int j = paramActivity.hashCode();
      if (a.get(j) == null)
      {
        localObject = new WeakReference(paramActivity);
        a.put(j, localObject);
      }
    }
    if (!this.b)
    {
      com.tencent.beacon.core.d.b.b("[event] lifecycle callback recover active user.", new Object[0]);
      b.b().a(new e.3(paramActivity));
      this.b = true;
    }
    Object localObject = i.a();
    if ("".equals(this.f)) {
      this.f = c.a(paramActivity).a("LAUEVE_DENGTA", "");
    }
    if (!((String)localObject).equals(this.f))
    {
      c.a(paramActivity).a().a("LAUEVE_DENGTA", localObject).b();
      if (!"".equals(this.f))
      {
        com.tencent.beacon.core.d.b.b("[core] -> report new day launcher event.", new Object[0]);
        this.f = ((String)localObject);
      }
    }
    for (;;)
    {
      if (i != 0) {
        a(paramActivity);
      }
      return;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    b(paramActivity);
    a(true, paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    b(paramActivity);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    b(paramActivity);
    a(false, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.e
 * JD-Core Version:    0.7.0.1
 */