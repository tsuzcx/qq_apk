package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdLifecycleManager;
import mqq.app.QActivityLifecycleCallbacks;

public final class GdtActivityLifecycleManager$GdtActivityLifecycleCallback
  implements QActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onProcessBackground()
  {
    AdLog.d("GdtActivityLifecycleManager", "onRunningBackground");
    AdLifecycleManager.INSTANCE.onRunningBackground();
  }
  
  public void onProcessForeground()
  {
    AdLog.d("GdtActivityLifecycleManager", "onRunningBackground");
    AdLifecycleManager.INSTANCE.onRunningForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtActivityLifecycleManager.GdtActivityLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */