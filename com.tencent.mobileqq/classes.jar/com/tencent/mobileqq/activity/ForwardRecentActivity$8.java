package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentActivity$8
  extends BroadcastReceiver
{
  ForwardRecentActivity$8(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing())
    {
      this.a.finish();
      QLog.i("ForwardOption.ForwardEntranceActivity", 1, "ForwardRecentActivity has finished by broadcastReceiver.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.8
 * JD-Core Version:    0.7.0.1
 */