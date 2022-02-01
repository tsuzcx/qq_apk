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
    if (paramBoolean) {
      BadgeUtils.a();
    } else {
      BadgeUtils.b();
    }
    QQAppInterface localQQAppInterface = this.a.app;
    String str1;
    if (paramBoolean) {
      str1 = "0X8004BE7";
    } else {
      str1 = "0X8004BE6";
    }
    String str2;
    if (paramBoolean) {
      str2 = "0X8004BE7";
    } else {
      str2 = "0X8004BE6";
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "1", "", "", "");
    if (AppSetting.d) {
      NotifyPushSettingActivity.d(this.a).setContentDescription(HardCodeUtil.a(2131707650));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */