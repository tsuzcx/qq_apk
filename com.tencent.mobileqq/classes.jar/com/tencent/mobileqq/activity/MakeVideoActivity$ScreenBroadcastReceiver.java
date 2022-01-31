package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MakeVideoActivity$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  public MakeVideoActivity$ScreenBroadcastReceiver(MakeVideoActivity paramMakeVideoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MakeVideoActivity.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */