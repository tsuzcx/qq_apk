package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;

class MessageHandler$5
  extends SendMessageHandler.SendMessageRunnable
{
  MessageHandler$5(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, BusinessObserver paramBusinessObserver, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "--->sendRichTextMessageWith_MR : resend message");
    }
    MessageHandler.a(this.this$0, this.a, this.b, this.g, this.m, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.5
 * JD-Core Version:    0.7.0.1
 */