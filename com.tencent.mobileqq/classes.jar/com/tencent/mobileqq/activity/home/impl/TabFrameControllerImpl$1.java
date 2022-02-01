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
    if (this.a.C() == null) {
      return;
    }
    RenderInSubThreadMonitor.disableMonitor();
    Object localObject1 = this.a;
    ((FrameFragment)localObject1).M = PreferenceManager.getDefaultSharedPreferences(((FrameFragment)localObject1).A.getApp());
    localObject1 = this.a.M;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("theme_voice_setting_");
    ((StringBuilder)localObject2).append(this.a.A.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = true;
    if (((SharedPreferences)localObject1).getBoolean((String)localObject2, true)) {
      bool = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).isSoundEffectsEnable(this.a.A, this.a.C());
    }
    this.this$0.dispatchResumeUpdateSound(this.a.G, bool);
    TabFrameControllerImpl.sFrameControllerInjectInterface.b(this.a);
    RenderInSubThreadMonitor.enableMonitor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */