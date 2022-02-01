package com.tencent.biz.qqcircle;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;

class QCircleGlobalBroadcastHelper$1
  implements Runnable
{
  QCircleGlobalBroadcastHelper$1(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void run()
  {
    HostStaticInvokeHelper.redPointHandlerSendRedpointReq(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.1
 * JD-Core Version:    0.7.0.1
 */