package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQAppInterface$5
  extends BroadcastReceiver
{
  QQAppInterface$5(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.isReleased)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.broadcast", 2, "qqHeadBroadcastReceiver onReceive, app isReleased");
      }
      return;
    }
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadreq".equals(paramIntent.getAction()))) {
      QQAppInterface.access$1700(this.this$0, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.5
 * JD-Core Version:    0.7.0.1
 */