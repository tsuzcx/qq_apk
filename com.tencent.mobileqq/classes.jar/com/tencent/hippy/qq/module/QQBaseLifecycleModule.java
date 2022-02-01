package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.BaseHippyFragment.HippyActivityLifecycleListener;
import com.tencent.mtt.hippy.HippyEngineContext;

public class QQBaseLifecycleModule
  extends QQBaseModule
  implements BaseHippyFragment.HippyActivityLifecycleListener
{
  public QQBaseLifecycleModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    if ((getFragment() instanceof BaseHippyFragment)) {
      ((BaseHippyFragment)getFragment()).addActivityLifecycleListener(this);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if ((getFragment() instanceof BaseHippyFragment)) {
      ((BaseHippyFragment)getFragment()).removeActivityLifecycleListener(this);
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQBaseLifecycleModule
 * JD-Core Version:    0.7.0.1
 */