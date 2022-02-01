package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

class LayoutPreLoader$1
  implements Application.ActivityLifecycleCallbacks
{
  LayoutPreLoader$1(LayoutPreLoader paramLayoutPreLoader) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    LayoutPreLoader.a(this.a, new WeakReference(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    LayoutPreLoader.a(this.a, paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    LayoutPreLoader.a(this.a, new WeakReference(paramActivity));
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.1
 * JD-Core Version:    0.7.0.1
 */