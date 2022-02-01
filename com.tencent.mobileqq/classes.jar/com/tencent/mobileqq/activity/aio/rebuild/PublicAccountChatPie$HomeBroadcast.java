package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PublicAccountChatPie$HomeBroadcast
  extends BroadcastReceiver
{
  private PublicAccountChatPie$HomeBroadcast(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      PublicAccountChatPie.a(this.a, 1);
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
      PublicAccountChatPie.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.HomeBroadcast
 * JD-Core Version:    0.7.0.1
 */