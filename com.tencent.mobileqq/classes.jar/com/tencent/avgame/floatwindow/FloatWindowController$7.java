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
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityResumed: " + paramActivity.getClass().getName() + " mHoldByPermission: " + this.a.b + " mIsFloatWindowShowing: " + FloatWindowController.b(this.a) + " mIgnoreByOpenSdkForeGround: " + FloatWindowController.c(this.a));
    }
    if ((this.a.b) && (!FloatWindowController.b(this.a)))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
      paramActivity.finish();
    }
    while (!FloatWindowController.c(this.a)) {
      return;
    }
    FloatWindowController.a(this.a, false);
    this.a.jdField_a_of_type_Boolean = true;
    this.a.a(true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.7
 * JD-Core Version:    0.7.0.1
 */