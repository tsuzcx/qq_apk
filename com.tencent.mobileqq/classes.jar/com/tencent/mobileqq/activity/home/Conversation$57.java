package com.tencent.mobileqq.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import common.config.service.QzoneConfig;

class Conversation$57
  extends BroadcastReceiver
{
  Conversation$57(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("0".equals(QzoneConfig.getInstance().getConfig("sweet_miniapp", "is_can_enter_aio", "0"))) {
      WTEntranceHelper.a(this.a.s(), this.a.P(), paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.57
 * JD-Core Version:    0.7.0.1
 */