package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.view.accessibility.AccessibilityManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class UserGuideWeishiFragment$1
  implements Runnable
{
  UserGuideWeishiFragment$1(UserGuideWeishiFragment paramUserGuideWeishiFragment) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        BaseActivity localBaseActivity = this.this$0.getBaseActivity();
        if (localBaseActivity != null)
        {
          if (localBaseActivity.isFinishing()) {
            return;
          }
          bool1 = AppSetting.d;
          if (bool1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack|true ");
            }
            localBaseActivity.finish();
            return;
          }
          AccessibilityManager localAccessibilityManager = (AccessibilityManager)localBaseActivity.getSystemService("accessibility");
          bool1 = localAccessibilityManager.isEnabled();
          boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
          if ((!bool1) || (!bool2)) {
            break label122;
          }
          bool1 = true;
          AppSetting.d = bool1;
          if ((AppSetting.d) && (localBaseActivity != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("UserGuideWeishiFragment", 2, "needAutoFinishForTalkBack:true");
            }
            localBaseActivity.finish();
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label122:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserGuideWeishiFragment.1
 * JD-Core Version:    0.7.0.1
 */