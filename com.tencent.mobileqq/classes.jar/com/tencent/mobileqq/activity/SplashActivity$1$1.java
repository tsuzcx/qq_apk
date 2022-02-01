package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class SplashActivity$1$1
  extends BroadcastReceiver
{
  SplashActivity$1$1(SplashActivity.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "onReceive:before_account_change");
    }
    this.a.this$0.clearAIO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.1.1
 * JD-Core Version:    0.7.0.1
 */