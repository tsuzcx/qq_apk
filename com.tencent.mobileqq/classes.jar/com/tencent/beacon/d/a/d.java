package com.tencent.beacon.d.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class d
  implements Application.ActivityLifecycleCallbacks
{
  private long a = System.currentTimeMillis();
  private Map<Activity, Long> b = new HashMap(3);
  private StatModule c;
  
  public d(StatModule paramStatModule)
  {
    this.c = paramStatModule;
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject2 = (Long)this.b.get(paramActivity);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(this.a);
    }
    long l = System.currentTimeMillis();
    localObject2 = paramActivity.getLocalClassName();
    this.c.b((String)localObject2, l - ((Long)localObject1).longValue(), l);
    this.b.remove(paramActivity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.d.a.d
 * JD-Core Version:    0.7.0.1
 */