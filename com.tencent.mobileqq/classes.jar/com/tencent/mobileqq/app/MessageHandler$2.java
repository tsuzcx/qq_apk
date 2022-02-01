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
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0.createToServiceMsg("MessageSvc.PbReceiptRead", null);
    ((ToServiceMsg)localObject).putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("msgSeq", this.jdField_a_of_type_Int);
    ((ToServiceMsg)localObject).extraData.putInt("msgtype", 1);
    ((ToServiceMsg)localObject).extraData.putString("uin", Long.toString(this.jdField_a_of_type_Long));
    ((ToServiceMsg)localObject).extraData.putLong("timeOut", this.c);
    ((ToServiceMsg)localObject).extraData.putInt("retryIndex", this.b);
    ((ToServiceMsg)localObject).setTimeout(this.c);
    this.this$0.sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.2
 * JD-Core Version:    0.7.0.1
 */