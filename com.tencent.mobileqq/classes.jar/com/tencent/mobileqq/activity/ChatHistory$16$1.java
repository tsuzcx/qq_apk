package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class ChatHistory$16$1
  implements Runnable
{
  ChatHistory$16$1(ChatHistory.16 param16) {}
  
  public void run()
  {
    int i = this.a.a.app.getMessageFacade().a(this.a.a.b, this.a.a.jdField_a_of_type_Int);
    Message localMessage = this.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(13);
    localMessage.arg1 = i;
    this.a.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.16.1
 * JD-Core Version:    0.7.0.1
 */