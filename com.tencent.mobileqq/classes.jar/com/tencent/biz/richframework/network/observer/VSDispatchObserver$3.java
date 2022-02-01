package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;

class VSDispatchObserver$3
  implements Runnable
{
  VSDispatchObserver$3(VSDispatchObserver paramVSDispatchObserver, boolean paramBoolean, BaseRequest paramBaseRequest, long paramLong1, byte[] paramArrayOfByte, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, String paramString, Object paramObject, long paramLong2) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.val$request.isSuccessRetCode(this.val$retCode)) && (this.val$request.isEnableCache())) {
      VSDispatchObserver.access$200(this.this$0, this.val$request, this.val$busiBuffData);
    }
    VSDispatchObserver.access$100(this.this$0, this.val$request, this.val$cb, this.val$retCode, this.val$errMsg, this.val$isSuccess, this.val$finalRsp);
    if (VSNetworkHelper.isValidLog(this.val$request.getCmdName())) {
      RFLog.d("VSNetworkHelper", RFLog.USR, "VSDispatchObserver: onReceive: dispatch Success CmdName:" + this.val$request.getCmdName() + " | TraceId:" + this.val$request.getTraceId() + " | SeqId:" + this.val$request.getCurrentSeq() + " | retCode:" + this.val$retCode + " | retMessage:" + this.val$errMsg + " | busiBuff size:" + this.val$busiBuffData.length + " | final dispatch costTime:" + (System.currentTimeMillis() - this.val$dispatchStartTimeStamp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */