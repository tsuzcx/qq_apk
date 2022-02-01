package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.request.BaseRequest;

class VSDispatchObserver$5
  implements Runnable
{
  VSDispatchObserver$5(VSDispatchObserver paramVSDispatchObserver, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong) {}
  
  public void run()
  {
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, -100002L, "网络错误", false, null);
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VSDispatchObserver: ParseException: CmdName:");
    localStringBuilder.append(this.val$request.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(this.val$request.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(this.val$request.getCurrentSeq());
    localStringBuilder.append(" | final dispatch costTime:");
    localStringBuilder.append(System.currentTimeMillis() - this.val$dispatchStartTimeStamp);
    localStringBuilder.append(" | errorMsg:BaseRequest or FromServiceMsg is null!");
    RFLog.e("VSNetworkHelper", i, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */