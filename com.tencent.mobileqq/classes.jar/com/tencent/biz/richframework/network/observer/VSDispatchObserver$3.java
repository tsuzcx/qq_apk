package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

class VSDispatchObserver$3
  implements Runnable
{
  VSDispatchObserver$3(VSDispatchObserver paramVSDispatchObserver, boolean paramBoolean, long paramLong1, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, String paramString, MessageMicro paramMessageMicro, long paramLong2) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.val$retCode == 0L) && (this.val$request.isEnableCache())) {
      VSDispatchObserver.access$200(this.this$0, this.val$request, this.val$busiBuffData);
    }
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, this.val$retCode, this.val$errMsg, this.val$isSuccess, this.val$finalRsp);
    if (VSNetworkHelper.isValidLog(this.val$request.getCmdName())) {
      QLog.d("VSNetworkHelper", 1, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | retCode:" + this.val$retCode + " | retMessage:" + this.val$errMsg + " | busiBuff size:" + this.val$busiBuffData.length + " | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */