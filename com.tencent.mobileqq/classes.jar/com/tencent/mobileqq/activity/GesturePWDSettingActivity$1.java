package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class GesturePWDSettingActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  GesturePWDSettingActivity$1(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    Object localObject = this.a;
    String str = this.a.app.getCurrentAccountUin();
    if (paramBoolean)
    {
      i = 2;
      GesturePWDUtils.setGesturePWDState((Context)localObject, str, i);
      this.a.a(paramBoolean);
      localObject = this.a.app;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = j;; i = 0)
    {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Setting_tab", "Setting_Gesture_password", 0, i, "", "", "", "");
      this.a.a();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */