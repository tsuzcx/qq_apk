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
    RFLog.e("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: ParseException: CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | errorMsg: inform BaseRequest result code fail | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp) + " | exception:" + this.val$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */