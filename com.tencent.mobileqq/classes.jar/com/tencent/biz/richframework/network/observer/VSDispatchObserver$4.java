package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.request.BaseRequest;

class VSDispatchObserver$4
  implements Runnable
{
  VSDispatchObserver$4(VSDispatchObserver paramVSDispatchObserver, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong, Exception paramException) {}
  
  public void run()
  {
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, -100001L, "网络错误", false, null);
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VSDispatchObserver: ParseException: CmdName:");
    localStringBuilder.append(this.val$request.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(this.val$request.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(this.val$request.getCurrentSeq());
    localStringBuilder.append(" | errorMsg: inform BaseRequest result code fail | final dispatch costTime:");
    localStringBuilder.append(System.currentTimeMillis() - this.val$dispatchStartTimeStamp);
    localStringBuilder.append(" | exception:");
    localStringBuilder.append(this.val$e);
    RFLog.e("VSNetworkHelper", i, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */