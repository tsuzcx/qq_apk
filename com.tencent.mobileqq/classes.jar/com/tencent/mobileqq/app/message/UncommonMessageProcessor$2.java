package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import aopk;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class UncommonMessageProcessor$2
  extends SendMessageHandler.SendMessageRunnable
{
  public UncommonMessageProcessor$2(aopk paramaopk, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    this.a.setTimeout(this.c);
    this.a.extraData.putInt("retryIndex", this.b);
    this.a.extraData.putLong("timeOut", this.c);
    aopk.b(this.this$0).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */