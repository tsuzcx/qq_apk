package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import com.tencent.richframework.sender.chain.BaseSenderChain;

class QCircleSenderTask$1
  implements VSDispatchObserver.onVSRspCallBack<Object>
{
  QCircleSenderTask$1(QCircleSenderTask paramQCircleSenderTask) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    if ((this.a.o != null) && (this.a.o.a() != null))
    {
      Call.OnRspCallBack localOnRspCallBack = this.a.o.a();
      if (localOnRspCallBack != null) {
        localOnRspCallBack.a(paramBoolean, paramLong, paramString, paramBaseRequest, paramObject, this.a.o.b());
      }
    }
    QCircleSenderTask.a(this.a, paramBoolean, paramLong, paramString);
    this.a.b(paramLong);
    this.a.a(paramString);
    QCircleOutboxTaskQueue.b().a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleSenderTask.1
 * JD-Core Version:    0.7.0.1
 */