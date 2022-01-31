package com.tencent.biz.qqcircle;

import alwx;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver$1
  implements Runnable
{
  QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver$1(QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver paramQCircleGlobalBroadcastReceiver) {}
  
  public void run()
  {
    Object localObject = QCircleGlobalBroadcastHelper.a();
    if (localObject != null)
    {
      localObject = (alwx)((AppInterface)localObject).getBusinessHandler(87);
      if (localObject != null)
      {
        QLog.i(QCircleGlobalBroadcastHelper.a(), 1, "handleQQCirclePush sendRedpointReq");
        ((alwx)localObject).a(true, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */