package com.tencent.beacon.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.a.b.j;
import com.tencent.beacon.event.UserAction;
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
  
  private long a()
  {
    String str;
    if (this.e <= 20000L)
    {
      str = com.tencent.beacon.a.e.a.a().b("hotLauncher");
      if (str == null) {}
    }
    try
    {
      this.e = Long.valueOf(str).longValue();
      this.e += 1L;
      return this.e;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        com.tencent.beacon.a.g.a.d("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    Context localContext = paramActivity.getApplicationContext();
    com.tencent.beacon.a.c.e.a(localContext);
    this.g.put("A33", com.tencent.beacon.a.c.e.i(localContext));
    Map localMap = this.g;
    if (com.tencent.beacon.a.c.a.a) {}
    for (paramActivity = "Y";; paramActivity = "N")
    {
      localMap.put("A85", paramActivity);
      this.g.put("A20", com.tencent.beacon.a.c.e.f(localContext));
      this.g.put("A69", com.tencent.beacon.a.c.e.g(localContext));
      UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, this.g, true);
      paramActivity = new Runnable()
      {
        public final void run()
        {
          j.c(true);
        }
      };
      b.a().a(paramActivity);
      return;
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity)
  {
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      if ((this.c > 0L) && (this.d > 0L) && (this.d + a() <= l)) {
        a(paramActivity);
      }
      this.c = l;
      this.d = 0L;
    }
    do
    {
      return;
      this.d = System.currentTimeMillis();
      if (this.c + 800L > this.d)
      {
        this.c = 0L;
        return;
      }
    } while (this.c != 0L);
    this.c = this.d;
  }
  
  private void b(Activity paramActivity)
  {
    int i = 1;
    com.tencent.beacon.a.c.a.a = true;
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
      b.a().a(new Runnable()
      {
        public final void run()
        {
          new com.tencent.beacon.a.b.e(e.this.getApplicationContext()).c();
        }
      });
      this.b = true;
    }
    Object localObject = com.tencent.beacon.a.a.f();
    if ("".equals(this.f)) {
      this.f = c.a(paramActivity).a("LAUEVE_DENGTA", "");
    }
    if (!((String)localObject).equals(this.f))
    {
      c.a(paramActivity).a().a("LAUEVE_DENGTA", localObject).b();
      if (!"".equals(this.f)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.e
 * JD-Core Version:    0.7.0.1
 */