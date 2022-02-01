package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;

class MessageHandler$12
  implements Runnable
{
  MessageHandler$12(MessageHandler paramMessageHandler, long paramLong1, String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    long l1 = 480000L;
    long l2 = 3L - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Long == 0L) {
      if (this.this$0.app.getMessageFacade().getLastMessage(this.jdField_a_of_type_JavaLangString, 1001).hasReply) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      MessageHandler.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Byte, bool, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, l1);
      return;
      l1 = l2 * 480000L / 3L - l2 * 2000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.12
 * JD-Core Version:    0.7.0.1
 */