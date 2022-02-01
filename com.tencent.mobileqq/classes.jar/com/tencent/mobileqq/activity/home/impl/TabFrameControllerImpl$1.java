package com.tencent.mobileqq.activity.home.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import mqq.app.AppRuntime;

class TabFrameControllerImpl$1
  implements Runnable
{
  TabFrameControllerImpl$1(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    boolean bool2 = true;
    if (this.a.getActivity() == null) {
      return;
    }
    RenderInSubThreadMonitor.disableMonitor();
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a.jdField_a_of_type_MqqAppAppRuntime.getApp());
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("theme_voice_setting_" + this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), true))
    {
      Object localObject = ThemeUtil.a(this.a.jdField_a_of_type_MqqAppAppRuntime);
      localObject = ThemeUtil.a(this.a.getActivity(), (String)localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((ThemeUtil.ThemeInfo)localObject).status.equals("5"))
        {
          bool1 = bool2;
          if (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme) {
            bool1 = false;
          }
        }
      }
    }
    this.this$0.dispatchResumeUpdateSound(this.a.jdField_a_of_type_JavaUtilHashMap, bool1);
    TabFrameControllerImpl.sFrameControllerInjectInterface.b(this.a);
    RenderInSubThreadMonitor.enableMonitor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */