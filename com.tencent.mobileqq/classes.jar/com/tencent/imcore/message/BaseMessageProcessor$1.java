package com.tencent.imcore.message;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class BaseMessageProcessor$1
  extends SendMessageHandler.SendMessageRunnable
{
  BaseMessageProcessor$1(BaseMessageProcessor paramBaseMessageProcessor, BaseMessageProcessor.RequestBuilder paramRequestBuilder, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.a.a();
    if (localToServiceMsg == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareRetryRunnable cmd=");
      localStringBuilder.append(localToServiceMsg.getServiceCmd());
      localStringBuilder.append(",reqSeq=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" timeout: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" retryIndex:");
      localStringBuilder.append(this.m);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    localToServiceMsg.extraData.putLong("timeOut", this.g);
    localToServiceMsg.extraData.putLong("startTime", this.c);
    localToServiceMsg.extraData.putInt("retryIndex", this.m);
    localToServiceMsg.setTimeout(this.g);
    this.this$0.a(localToServiceMsg, this.b, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */