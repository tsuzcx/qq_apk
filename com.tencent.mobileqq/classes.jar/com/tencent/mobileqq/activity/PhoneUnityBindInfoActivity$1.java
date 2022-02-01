package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class PhoneUnityBindInfoActivity$1
  extends BroadcastReceiver
{
  PhoneUnityBindInfoActivity$1(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("PhoneUnityBindInfoActivity", 1, "bindMiBaoReceiver onReceive");
    if (PhoneUnityBindInfoActivity.access$000(this.a) == 1)
    {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B316", "0X800B316", 0, 0, "", "", "", "");
      return;
    }
    if (PhoneUnityBindInfoActivity.access$000(this.a) == 2) {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B326", "0X800B326", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */