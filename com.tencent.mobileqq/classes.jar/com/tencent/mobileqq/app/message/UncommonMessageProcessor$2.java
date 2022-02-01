package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;

class UncommonMessageProcessor$2
  extends SendMessageHandler.SendMessageRunnable
{
  UncommonMessageProcessor$2(UncommonMessageProcessor paramUncommonMessageProcessor, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    this.a.setTimeout(this.g);
    this.a.extraData.putInt("retryIndex", this.m);
    this.a.extraData.putLong("timeOut", this.g);
    UncommonMessageProcessor.b(this.this$0).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */