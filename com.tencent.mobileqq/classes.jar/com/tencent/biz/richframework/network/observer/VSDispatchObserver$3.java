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
    if (VSNetworkHelper.isValidLog(this.val$request.getCmdName()))
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VSDispatchObserver: onReceive: dispatch Success CmdName:");
      localStringBuilder.append(this.val$request.getCmdName());
      localStringBuilder.append(" | TraceId:");
      localStringBuilder.append(this.val$request.getTraceId());
      localStringBuilder.append(" | SeqId:");
      localStringBuilder.append(this.val$request.getCurrentSeq());
      localStringBuilder.append(" | retCode:");
      localStringBuilder.append(this.val$retCode);
      localStringBuilder.append(" | retMessage:");
      localStringBuilder.append(this.val$errMsg);
      localStringBuilder.append(" | busiBuff size:");
      localStringBuilder.append(this.val$busiBuffData.length);
      localStringBuilder.append(" | final dispatch costTime:");
      localStringBuilder.append(System.currentTimeMillis() - this.val$dispatchStartTimeStamp);
      RFLog.d("VSNetworkHelper", i, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.3
 * JD-Core Version:    0.7.0.1
 */