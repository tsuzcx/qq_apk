package com.tencent.beacon.pagepath;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.beacon.core.a.d;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class b
  implements Application.ActivityLifecycleCallbacks
{
  private long a = System.currentTimeMillis();
  private Map<Activity, Long> b = new HashMap();
  private long c = 0L;
  
  private void a(Activity paramActivity)
  {
    Long localLong2 = (Long)this.b.get(paramActivity);
    Long localLong1 = localLong2;
    if (localLong2 == null) {
      localLong1 = Long.valueOf(this.a);
    }
    long l = System.currentTimeMillis();
    a(paramActivity.getLocalClassName(), l - localLong1.longValue(), l);
    this.b.remove(paramActivity);
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    d.a().a(new a(this, paramLong2, paramString, paramLong1));
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.b.put(paramActivity, Long.valueOf(System.currentTimeMillis()));
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.pagepath.b
 * JD-Core Version:    0.7.0.1
 */