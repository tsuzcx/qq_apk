package com.tencent.mobileqq.apollo.game.process.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class CmGameLauncher$1
  extends BroadcastReceiver
{
  CmGameLauncher$1(CmGameLauncher paramCmGameLauncher) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CmGameLauncher.a(this.a) == null) {
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
    {
      CmGameLauncher.b(this.a);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
      CmGameLauncher.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.1
 * JD-Core Version:    0.7.0.1
 */