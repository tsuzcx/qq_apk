package com.tencent.hippy.qq.module.gamecenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

class QQGameCenterModule$1
  extends BroadcastReceiver
{
  QQGameCenterModule$1(QQGameCenterModule paramQQGameCenterModule) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      if ("[onRecevier] action:" + str + ",data:" + paramIntent.getExtras() != null)
      {
        paramContext = paramIntent.getExtras().toString();
        QLog.d("QQGameCenterModule", 2, paramContext);
      }
    }
    else {
      if (str != null) {
        break label70;
      }
    }
    label70:
    label113:
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
            break label113;
          }
          paramContext = GameCenterAPIJavaScript.parseGameMessageChange(paramIntent.getExtras());
        } while (paramContext == null);
        paramIntent = new HippyMap();
        paramIntent.pushJSONObject(paramContext);
        HippyQQEngine.dispatchEvent("QQGameCenter_sessionChanged", "QQGameCenter", paramIntent);
        return;
      } while (!"action_qgame_unread_change".equals(str));
      paramContext = GameCenterAPIJavaScript.parseGameMessageUnreadCount(paramIntent.getExtras());
    } while (paramContext == null);
    paramIntent = new HippyMap();
    paramIntent.pushJSONObject(paramContext);
    HippyQQEngine.dispatchEvent("QQGameCenter_newMsgCountChanged", "QQGameCenter", paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule.1
 * JD-Core Version:    0.7.0.1
 */