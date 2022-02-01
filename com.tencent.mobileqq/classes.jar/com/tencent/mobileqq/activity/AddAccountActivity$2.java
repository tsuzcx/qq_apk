package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AddAccountActivity$2
  extends BroadcastReceiver
{
  AddAccountActivity$2(AddAccountActivity paramAddAccountActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AddAccountActivity", 1, "AutoLoginReceiver onReceive");
    AddAccountActivity.access$002(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */