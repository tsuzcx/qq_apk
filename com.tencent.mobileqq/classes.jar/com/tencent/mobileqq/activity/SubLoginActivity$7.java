package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class SubLoginActivity$7
  extends BroadcastReceiver
{
  SubLoginActivity$7(SubLoginActivity paramSubLoginActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Q.subaccount.SubLoginActivity", 1, "AutoLoginReceiver onReceive");
    SubLoginActivity.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.7
 * JD-Core Version:    0.7.0.1
 */