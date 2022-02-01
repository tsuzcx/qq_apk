package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class NotificationDeleteReceiver
  extends QQBroadcastReceiver
{
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    QLog.d("NotificationDeleteReceiver", 2, "NotificationDeleteReceiver");
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    ReportController.b(paramAppRuntime, "CliOper", "", "", "0X80046A6", "0X80046A6", 0, 0, "", "", "", "");
    paramContext = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive: invoked.  notifyId: ");
      paramIntent.append(i);
      paramIntent.append(" friendOrTroopUin: ");
      paramIntent.append(paramContext);
      QLog.i("NotificationDeleteReceiver", 2, paramIntent.toString());
    }
    if ((i >= 512) && (i <= 522)) {
      NotifyIdManager.a(paramAppRuntime).a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NotificationDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */