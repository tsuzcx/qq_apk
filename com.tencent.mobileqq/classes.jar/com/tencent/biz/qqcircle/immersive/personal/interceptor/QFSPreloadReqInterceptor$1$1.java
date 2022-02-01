package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;

class QFSPreloadReqInterceptor$1$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QFSPreloadReqInterceptor$1$1(QFSPreloadReqInterceptor.1 param1, OnPreLoadListener paramOnPreLoadListener) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    String str = this.b.b.a();
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
    this.a.onLoaded(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSPreloadReqInterceptor.1.1
 * JD-Core Version:    0.7.0.1
 */