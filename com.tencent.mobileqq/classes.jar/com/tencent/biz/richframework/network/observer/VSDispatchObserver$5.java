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
    RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: ParseException: CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp) + " | errorMsg:BaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */