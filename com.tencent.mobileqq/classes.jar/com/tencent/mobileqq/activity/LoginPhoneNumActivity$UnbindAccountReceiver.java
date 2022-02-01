package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class LoginPhoneNumActivity$UnbindAccountReceiver
  extends BroadcastReceiver
{
  private LoginPhoneNumActivity$UnbindAccountReceiver(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a;
    paramContext.doReceive(paramIntent, LoginPhoneNumActivity.access$700(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.UnbindAccountReceiver
 * JD-Core Version:    0.7.0.1
 */