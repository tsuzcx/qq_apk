package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BadgeUtils;

class NotifyPushSettingActivity$13
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$13(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      BadgeUtils.a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label91;
      }
      str1 = "0X8004BE7";
      label23:
      if (!paramBoolean) {
        break label97;
      }
    }
    label91:
    label97:
    for (String str2 = "0X8004BE7";; str2 = "0X8004BE6")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "1", "", "", "");
      if (AppSetting.d) {
        NotifyPushSettingActivity.d(this.a).setContentDescription(HardCodeUtil.a(2131707625));
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      BadgeUtils.b();
      break;
      str1 = "0X8004BE6";
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */