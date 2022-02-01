package com.tencent.avgame.floatwindow;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class FloatWindowController$7
  implements Application.ActivityLifecycleCallbacks
{
  FloatWindowController$7(FloatWindowController paramFloatWindowController) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      localStringBuilder.append(" mIsFloatWindowShowing: ");
      localStringBuilder.append(FloatWindowController.b(this.a));
      localStringBuilder.append(" mIgnoreByOpenSdkForeGround: ");
      localStringBuilder.append(FloatWindowController.f(this.a));
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
    if ((FloatWindowController.a(this.a)) && (!FloatWindowController.b(this.a)))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.a.e);
      ThreadManager.getUIHandlerV2().postDelayed(this.a.e, 1000L);
      paramActivity.finish();
      return;
    }
    if (FloatWindowController.f(this.a))
    {
      FloatWindowController.a(this.a, false);
      paramActivity = this.a;
      paramActivity.a = true;
      paramActivity.a(true);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStarted: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStopped: ");
      localStringBuilder.append(paramActivity.getClass().getName());
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.7
 * JD-Core Version:    0.7.0.1
 */