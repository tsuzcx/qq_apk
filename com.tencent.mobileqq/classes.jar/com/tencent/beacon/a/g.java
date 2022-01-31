package com.tencent.beacon.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.beacon.d.a;
import com.tencent.beacon.event.i;
import java.lang.ref.WeakReference;

@TargetApi(14)
public final class g
  implements Application.ActivityLifecycleCallbacks
{
  private static SparseArray<WeakReference<Activity>> a = new SparseArray();
  private boolean b = false;
  
  private void a(Activity paramActivity)
  {
    b.a = true;
    if ((paramActivity != null) && (a != null))
    {
      int i = paramActivity.hashCode();
      if (a.get(i) == null)
      {
        WeakReference localWeakReference = new WeakReference(paramActivity);
        a.put(i, localWeakReference);
      }
    }
    if (!this.b)
    {
      a.b("lifecycle callback recover active user.", new Object[0]);
      c.a().a(new Runnable()
      {
        public final void run()
        {
          new i(g.this.getApplicationContext()).b();
        }
      });
      this.b = true;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g
 * JD-Core Version:    0.7.0.1
 */