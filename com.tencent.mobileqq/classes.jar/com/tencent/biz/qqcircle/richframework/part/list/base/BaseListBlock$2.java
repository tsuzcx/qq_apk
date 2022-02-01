package com.tencent.biz.qqcircle.richframework.part.list.base;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

class BaseListBlock$2
  implements VSDispatchObserver.onVSRspCallBack<T>
{
  BaseListBlock$2(BaseListBlock paramBaseListBlock, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, T paramT)
  {
    String str = this.d.getLogTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | isLoadMore:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" | isCache:");
    localStringBuilder.append(this.c);
    QLog.d(str, 1, localStringBuilder.toString());
    this.d.handleResponse(paramBoolean, this.b, paramLong, this.a, paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock.2
 * JD-Core Version:    0.7.0.1
 */