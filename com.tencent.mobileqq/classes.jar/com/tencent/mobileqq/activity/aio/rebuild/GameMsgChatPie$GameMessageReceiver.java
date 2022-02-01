package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class GameMsgChatPie$GameMessageReceiver
  extends BroadcastReceiver
{
  private WeakReference<GameMsgChatPie> a;
  
  public GameMsgChatPie$GameMessageReceiver(GameMsgChatPie paramGameMsgChatPie)
  {
    this.a = new WeakReference(paramGameMsgChatPie);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("GameMessageReceiver [onRecevier] action:");
      paramContext.append(str);
      paramContext.append(",data:");
      paramContext.append(paramIntent.getExtras());
      if (paramContext.toString() != null) {
        paramContext = paramIntent.getExtras().toString();
      } else {
        paramContext = null;
      }
      QLog.d("GameMsgChatPie", 2, paramContext);
    }
    if (str == null) {
      return;
    }
    if ("action_qgame_unread_change".equals(str))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        int i = paramContext.getInt("key_msg_unread_cnt");
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("GameMessageReceiver [onReceive] cnt:");
          paramContext.append(i);
          QLog.d("GameMsgChatPie", 2, paramContext.toString());
        }
        if (this.a.get() != null)
        {
          ((GameMsgChatPie)this.a.get()).l(i);
          return;
        }
        QLog.i("GameMsgChatPie", 1, "GameMessageReceiver [onReceive] chatpie is null.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.GameMessageReceiver
 * JD-Core Version:    0.7.0.1
 */