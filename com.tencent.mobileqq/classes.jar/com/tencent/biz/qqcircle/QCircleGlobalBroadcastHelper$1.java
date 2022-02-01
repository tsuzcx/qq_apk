package com.tencent.biz.qqcircle;

import aogf;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class QCircleGlobalBroadcastHelper$1
  implements Runnable
{
  QCircleGlobalBroadcastHelper$1(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void run()
  {
    Object localObject = QCircleGlobalBroadcastHelper.a();
    if (localObject != null)
    {
      localObject = (aogf)((AppInterface)localObject).getBusinessHandler(87);
      if (localObject != null)
      {
        QLog.i(QCircleGlobalBroadcastHelper.a(), 1, "handleQQCirclePush sendRedpointReq");
        ((aogf)localObject).a(true, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.1
 * JD-Core Version:    0.7.0.1
 */