package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class VSDispatchObserver$4
  implements Runnable
{
  VSDispatchObserver$4(VSDispatchObserver paramVSDispatchObserver, VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong, Exception paramException) {}
  
  public void run()
  {
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, -100001L, "网络错误", false, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: ParseException: CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | errorMsg: inform VSBaseRequest resultcode fail | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp) + " | exception:" + this.val$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.4
 * JD-Core Version:    0.7.0.1
 */