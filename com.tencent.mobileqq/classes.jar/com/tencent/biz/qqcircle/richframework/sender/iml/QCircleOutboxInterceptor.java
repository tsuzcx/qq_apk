package com.tencent.biz.qqcircle.richframework.sender.iml;

import android.os.Handler;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.outbox.BaseOutboxTaskQueue;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleSenderTask;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;

public class QCircleOutboxInterceptor
  implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>, RspInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  private QCircleSenderTask a;
  private boolean b;
  
  public String a()
  {
    return "QCircleOutboxInterceptor";
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interceptAddReq reqCmd:");
    localStringBuilder.append(paramQCircleBaseRequest.getCmdName());
    QLog.d(str, 1, localStringBuilder.toString());
    this.a = new QCircleSenderTask(paramQCircleBaseRequest, paramBaseSenderChain);
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      if (this.b) {
        RFThreadManager.getUIHandler().post(new QCircleOutboxInterceptor.1(this));
      }
      QCircleOutboxTaskQueue.b().b(this.a);
    }
    else
    {
      QCircleOutboxTaskQueue.b().a(this.a);
    }
    paramBaseSenderChain.a(paramQCircleBaseRequest);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interceptReturnRsp result:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    this.a.b(paramLong);
    this.a.a(paramString);
    QCircleOutboxTaskQueue.b().a(this.a, paramBoolean);
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.QCircleOutboxInterceptor
 * JD-Core Version:    0.7.0.1
 */