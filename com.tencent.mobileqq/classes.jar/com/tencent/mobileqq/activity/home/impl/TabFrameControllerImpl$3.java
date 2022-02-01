package com.tencent.mobileqq.activity.home.impl;

import android.content.SharedPreferences;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class TabFrameControllerImpl$3
  implements Runnable
{
  TabFrameControllerImpl$3(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, int paramInt) {}
  
  public void run()
  {
    String str = this.this$0.getCurrentTabTag(this.a.s);
    Object localObject;
    if ((FrameControllerUtil.l.equals(str)) || (FrameControllerUtil.m.equals(str)))
    {
      if (FrameControllerUtil.l.equals(str)) {
        localObject = "Msg_tab";
      } else {
        localObject = "Contacts_tab";
      }
      ReportController.b(this.a.A, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
    if (this.a.M != null)
    {
      localObject = this.a.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("theme_voice_setting_");
      localStringBuilder.append(this.a.A.getCurrentAccountUin());
      if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true)) {
        TabFrameControllerImpl.sFrameControllerInjectInterface.a(this.a, this.b);
      }
    }
    if ((str != null) && (AppSetting.e)) {
      this.this$0.dispatchTabContentDescription(this.a, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */