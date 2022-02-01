package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import mqq.app.AppRuntime;

public class HostHttpUtils
{
  public static void cancel(NetReq paramNetReq)
  {
    ((IHttpEngineService)QCircleServiceImpl.getAppRunTime().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(paramNetReq);
  }
  
  public static void httpEngineServiceSendRequest(HttpNetReq paramHttpNetReq)
  {
    ((IHttpEngineService)QCircleServiceImpl.getAppRunTime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(paramHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils
 * JD-Core Version:    0.7.0.1
 */