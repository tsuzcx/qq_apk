package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class VSDispatchObserver$2
  implements Runnable
{
  VSDispatchObserver$2(VSDispatchObserver paramVSDispatchObserver, VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong1, String paramString, long paramLong2) {}
  
  public void run()
  {
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, this.val$retCode, this.val$errMsg, false, null);
    QLog.e("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp) + " | errorMsg: inform VSBaseRequest finalRsp is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.2
 * JD-Core Version:    0.7.0.1
 */