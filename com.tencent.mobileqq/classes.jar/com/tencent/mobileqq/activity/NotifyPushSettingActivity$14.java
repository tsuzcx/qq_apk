package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;

class NotifyPushSettingActivity$14
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$14(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBooleanAsync(this.a.getString(2131718678) + this.a.a, paramBoolean);
    if (AppSetting.d) {
      NotifyPushSettingActivity.e(this.a).setContentDescription(HardCodeUtil.a(2131707641));
    }
    QQAppInterface localQQAppInterface = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (String str = "1";; str = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_about_me", 0, i, str, "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */