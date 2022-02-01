package com.tencent.biz.qqcircle.richframework.sender.iml.req;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;

class QCircleSenderReqInterceptor$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QCircleSenderReqInterceptor$1(QCircleSenderReqInterceptor paramQCircleSenderReqInterceptor, BaseSenderChain paramBaseSenderChain, QCircleBaseRequest paramQCircleBaseRequest) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    String str = this.c.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestCmd: ");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append("traceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append("isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    this.a.a(paramBoolean, paramLong, paramString, this.b, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleSenderReqInterceptor.1
 * JD-Core Version:    0.7.0.1
 */