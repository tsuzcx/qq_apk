package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

public class QCircleSenderReqInterceptor
  implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  public String a()
  {
    return "QCircleSenderReqInterceptor";
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (paramQCircleBaseRequest != null)
    {
      if (paramBaseSenderChain == null) {
        return;
      }
      VSNetworkHelper.getInstance().sendRequest(QCircleApplication.APP, paramQCircleBaseRequest, new QCircleSenderReqInterceptor.1(this, paramBaseSenderChain, paramQCircleBaseRequest));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleSenderReqInterceptor
 * JD-Core Version:    0.7.0.1
 */