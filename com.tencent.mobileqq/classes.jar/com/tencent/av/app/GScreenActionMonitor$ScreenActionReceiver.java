package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.qphone.base.util.QLog;

class GScreenActionMonitor$ScreenActionReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_ON");
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_OFF");
      VideoNodeManager.a(19, 1L);
      return;
    }
    if (paramContext.equals("android.intent.action.USER_PRESENT"))
    {
      QLog.d("GScreenActionMonitor", 1, "avideACTION_USER_PRESENT");
      VideoNodeManager.a(19, 2L);
      return;
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      paramIntent = new StringBuilder();
      paramIntent.append("avideo ACTION_CLOSE_SYSTEM_DIALOGS, reason[");
      paramIntent.append(paramContext);
      paramIntent.append("]");
      QLog.d("GScreenActionMonitor", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GScreenActionMonitor.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */