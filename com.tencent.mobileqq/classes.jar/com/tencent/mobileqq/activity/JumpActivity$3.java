package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class JumpActivity$3
  extends BroadcastReceiver
{
  JumpActivity$3(JumpActivity paramJumpActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing())
    {
      QLog.i("JumpAction", 1, "JumpActivity has finished by broadcastReceiver.");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.3
 * JD-Core Version:    0.7.0.1
 */