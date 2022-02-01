package com.tencent.biz.qqcircle.publish.common;

import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.request.QCircleBaseUploadRequest;
import com.tencent.biz.qqcircle.publish.request.QCircleRequest;
import com.tencent.qphone.base.util.QLog;

public class QCircleProtocolService
{
  private static Object a = new Object();
  private static volatile QCircleProtocolService b;
  
  public static QCircleProtocolService a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new QCircleProtocolService();
        }
      }
    }
    return b;
  }
  
  public int a(QCircleRequest paramQCircleRequest, IQZoneProtocolListener paramIQZoneProtocolListener)
  {
    if (paramQCircleRequest == null)
    {
      QLog.e("[QcirclePublish]QCircleProtocolService", 1, "request is null");
      return 1000004;
    }
    paramQCircleRequest.a(paramIQZoneProtocolListener);
    if ((paramQCircleRequest instanceof QCircleBaseUploadRequest)) {
      ((QCircleBaseUploadRequest)paramQCircleRequest).a(LoginData.a().e());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.common.QCircleProtocolService
 * JD-Core Version:    0.7.0.1
 */