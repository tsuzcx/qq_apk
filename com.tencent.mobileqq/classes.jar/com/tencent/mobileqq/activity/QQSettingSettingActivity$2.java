package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QQSettingSettingActivity$2
  extends BroadcastReceiver
{
  QQSettingSettingActivity$2(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("bindMiBaoReceiver onReceive mIsBindMb：");
      paramContext.append(QQSettingSettingActivity.a(this.a));
      QLog.d("QQSetting2Activity", 1, paramContext.toString());
    }
    if (QQSettingSettingActivity.a(this.a)) {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B312", "0X800B312", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */