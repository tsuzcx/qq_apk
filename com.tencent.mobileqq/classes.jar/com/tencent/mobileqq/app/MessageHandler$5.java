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
    MessageHandler.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbSendMsgReq, this.c, this.b, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.5
 * JD-Core Version:    0.7.0.1
 */