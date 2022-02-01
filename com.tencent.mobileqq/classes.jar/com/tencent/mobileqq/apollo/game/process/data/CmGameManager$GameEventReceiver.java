package com.tencent.mobileqq.apollo.game.process.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class CmGameManager$GameEventReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("cmgame_process.CmGameManager", 1, "[onReceive] intent null");
      return;
    }
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] action=", paramContext });
    }
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) {
      return;
    }
    if (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))) {
      return;
    }
    paramContext = paramIntent.getStringExtra("data");
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] data=", paramContext });
    }
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    ThreadManagerV2.excute(new CmGameManager.GameEventReceiver.1(this, paramContext), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameManager.GameEventReceiver
 * JD-Core Version:    0.7.0.1
 */