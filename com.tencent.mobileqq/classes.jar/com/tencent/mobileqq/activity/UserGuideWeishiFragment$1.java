package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.accessibility.AccessibilityManager;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class UserGuideWeishiFragment$1
  implements Runnable
{
  UserGuideWeishiFragment$1(UserGuideWeishiFragment paramUserGuideWeishiFragment) {}
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.this$0.getActivity();
      if (localFragmentActivity == null) {
        return;
      }
      if (localFragmentActivity.isFinishing()) {
        return;
      }
      if (AppSetting.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack|true ");
        }
        localFragmentActivity.finish();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)localThrowable.getSystemService("accessibility");
    boolean bool1 = localAccessibilityManager.isEnabled();
    boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      AppSetting.c = bool1;
      if ((!AppSetting.c) || (localThrowable == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack:true");
      }
      localThrowable.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment.1
 * JD-Core Version:    0.7.0.1
 */