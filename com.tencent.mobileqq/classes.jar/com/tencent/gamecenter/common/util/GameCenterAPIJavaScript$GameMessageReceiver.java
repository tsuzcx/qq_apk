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
      if ("[onRecevier] action:" + str + ",data:" + paramIntent.getExtras() != null)
      {
        paramContext = paramIntent.getExtras().toString();
        QLog.d("GCApi", 2, paramContext);
      }
    }
    else {
      if (str != null) {
        break label70;
      }
    }
    label70:
    label104:
    do
    {
      do
      {
        do
        {
          return;
          paramContext = null;
          break;
          if (!"action_qgame_messgae_change".equals(str)) {
            break label104;
          }
          paramContext = GameCenterAPIJavaScript.parseGameMessageChange(paramIntent.getExtras());
        } while (paramContext == null);
        this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_SESSION_INFO, paramContext, null);
        return;
      } while (!"action_qgame_unread_change".equals(str));
      paramContext = GameCenterAPIJavaScript.parseGameMessageUnreadCount(paramIntent.getExtras());
    } while (paramContext == null);
    this.a.dispatchJsEvent(GameCenterAPIJavaScript.EVENT_UPDATE_UNREAD_CNT, paramContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript.GameMessageReceiver
 * JD-Core Version:    0.7.0.1
 */