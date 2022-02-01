package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class PublicAccountChatPie$18
  implements Runnable
{
  PublicAccountChatPie$18(PublicAccountChatPie paramPublicAccountChatPie, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.b, 2, "saveReadedToDB uin=" + this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " uniseq=" + localChatMessage.uniseq + " extstr=" + localChatMessage.extStr);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.b, 4, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.18
 * JD-Core Version:    0.7.0.1
 */