package com.tencent.gamecenter.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class GameCenterAPIJavaScript$GameMessageReceiver
  extends BroadcastReceiver
{
  private GameCenterAPIJavaScript$GameMessageReceiver(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[onRecevier] action:");
      paramContext.append(str);
      paramContext.append(",data:");
      paramContext.append(paramIntent.getExtras());
      if (paramContext.toString() != null) {
        paramContext = paramIntent.getExtras().toString();
      } else {
        paramContext = null;
      }
      QLog.d("GCApi", 2, paramContext);
    }
    if (str == null) {
      return;
    }
    if ("action_qgame_messgae_change".equals(str))
    {
      paramContext = GameCenterAPIJavaScript.parseGameMessageChange(paramIntent.getExtras());
      if (paramContext != null) {
        this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_SESSION_INFO, paramContext, null);
      }
    }
    else if ("action_qgame_unread_change".equals(str))
    {
      paramContext = GameCenterAPIJavaScript.parseGameMessageUnreadCount(paramIntent.getExtras());
      if (paramContext != null) {
        this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_UNREAD_CNT, paramContext, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.GameMessageReceiver
 * JD-Core Version:    0.7.0.1
 */