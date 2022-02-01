package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class MessageHandler$16
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$16(MessageHandler paramMessageHandler, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.this$0.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.extraData.putLong("timeOut", this.g);
    localToServiceMsg.extraData.putLong("startTime", this.b);
    localToServiceMsg.extraData.putInt("retryIndex", this.m);
    localToServiceMsg.extraData.putLong("msgSeq", this.c);
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.setTimeout(this.g);
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.16
 * JD-Core Version:    0.7.0.1
 */