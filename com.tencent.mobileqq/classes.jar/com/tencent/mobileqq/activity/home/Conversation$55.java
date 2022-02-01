package com.tencent.mobileqq.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class Conversation$55
  extends BroadcastReceiver
{
  Conversation$55(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext))) {
      ThreadManager.getSubThreadHandler().post(Conversation.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.55
 * JD-Core Version:    0.7.0.1
 */