package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class MessageHandler$3
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$3(MessageHandler paramMessageHandler, msg_svc.PbSendMsgReq paramPbSendMsgReq, int paramInt, long paramLong) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = this.this$0.createToServiceMsg("MessageSvc.PbReceiptRead", null);
    localToServiceMsg.putWupBuffer(this.a.toByteArray());
    localToServiceMsg.extraData.putLong("msgSeq", this.b);
    localToServiceMsg.extraData.putInt("msgtype", 2);
    localToServiceMsg.extraData.putString("uin", Long.toString(this.c));
    localToServiceMsg.extraData.putLong("timeOut", this.g);
    localToServiceMsg.extraData.putInt("retryIndex", this.m);
    localToServiceMsg.setTimeout(this.g);
    this.this$0.sendPbReq(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.3
 * JD-Core Version:    0.7.0.1
 */