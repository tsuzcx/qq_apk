package com.tencent.mobileqq.activity.home.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor;
import mqq.app.AppRuntime;

class TabFrameControllerImpl$1
  implements Runnable
{
  TabFrameControllerImpl$1(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment) {}
  
  public void run()
  {
    if (this.a.a() == null) {
      return;
    }
    RenderInSubThreadMonitor.disableMonitor();
    Object localObject1 = this.a;
    ((FrameFragment)localObject1).jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(((FrameFragment)localObject1).jdField_a_of_type_MqqAppAppRuntime.getApp());
    localObject1 = this.a.jdField_a_of_type_AndroidContentSharedPreferences;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("theme_voice_setting_");
    ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = true;
    if (((SharedPreferences)localObject1).getBoolean((String)localObject2, true)) {
      bool = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).isSoundEffectsEnable(this.a.jdField_a_of_type_MqqAppAppRuntime, this.a.a());
    }
    this.this$0.dispatchResumeUpdateSound(this.a.jdField_a_of_type_JavaUtilHashMap, bool);
    TabFrameControllerImpl.sFrameControllerInjectInterface.a(this.a);
    RenderInSubThreadMonitor.enableMonitor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */