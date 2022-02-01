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
      QLog.d("QQGameCenterModule", 2, paramContext);
    }
    if (str == null) {
      return;
    }
    if ("action_qgame_messgae_change".equals(str))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext.getBoolean("is_update_publicaccount_only", false)) {
        return;
      }
      paramContext = GameCenterAPIJavaScript.parseGameMessageChange(paramContext);
      if (paramContext != null)
      {
        paramIntent = new HippyMap();
        paramIntent.pushJSONObject(paramContext);
        HippyQQEngine.dispatchEvent("QQGameCenter_sessionChanged", "QQGameCenter", paramIntent);
      }
    }
    else if ("action_qgame_unread_change".equals(str))
    {
      paramContext = GameCenterAPIJavaScript.parseGameMessageUnreadCount(paramIntent.getExtras());
      if (paramContext != null)
      {
        paramIntent = new HippyMap();
        paramIntent.pushJSONObject(paramContext);
        HippyQQEngine.dispatchEvent("QQGameCenter_newMsgCountChanged", "QQGameCenter", paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule.1
 * JD-Core Version:    0.7.0.1
 */