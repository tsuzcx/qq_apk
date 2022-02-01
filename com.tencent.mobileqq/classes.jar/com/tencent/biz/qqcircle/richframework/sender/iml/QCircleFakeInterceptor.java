package com.tencent.biz.qqcircle.richframework.sender.iml;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;

public abstract class QCircleFakeInterceptor
  implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>, RspInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  private Object a;
  private boolean b;
  
  public QCircleFakeInterceptor(boolean paramBoolean, Object paramObject)
  {
    this.b = paramBoolean;
    this.a = paramObject;
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (this.b)
    {
      a(paramQCircleBaseRequest, this.a, paramBaseSenderChain);
      paramBaseSenderChain.b(true, 0L, "", paramQCircleBaseRequest, this.a);
    }
    paramBaseSenderChain.a(paramQCircleBaseRequest);
  }
  
  public abstract void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain);
  
  public abstract void a(QCircleBaseRequest paramQCircleBaseRequest, Object paramObject1, BaseSenderChain paramBaseSenderChain, Object paramObject2);
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, BaseSenderChain paramBaseSenderChain)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("interceptReturnRsp retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramString);
    QLog.d("QCircleFakeInterceptor", 1, localStringBuilder.toString());
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramQCircleBaseRequest, paramObject);
    if ((this.b) && (paramLong != 0L))
    {
      a(paramQCircleBaseRequest, paramObject, paramBaseSenderChain, this.a);
      paramBaseSenderChain.b(false, paramLong, "", paramQCircleBaseRequest, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
 * JD-Core Version:    0.7.0.1
 */