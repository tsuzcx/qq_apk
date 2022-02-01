package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class MessageHandler$2
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$2(MessageHandler paramMessageHandler, msg_svc.PbSendMsgReq paramPbSendMsgReq, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendReceiptMessageRead.prepareRetryRunnable: ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0.createToServiceMsg("MessageSvc.PbReceiptRead", null);
    ((ToServiceMsg)localObject).putWupBuffer(this.a.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("msgSeq", this.b);
    ((ToServiceMsg)localObject).extraData.putInt("msgtype", 1);
    ((ToServiceMsg)localObject).extraData.putString("uin", Long.toString(this.c));
    ((ToServiceMsg)localObject).extraData.putLong("timeOut", this.g);
    ((ToServiceMsg)localObject).extraData.putInt("retryIndex", this.m);
    ((ToServiceMsg)localObject).setTimeout(this.g);
    this.this$0.sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.2
 * JD-Core Version:    0.7.0.1
 */