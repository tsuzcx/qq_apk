package com.tencent.mobileqq.activity;

import awwg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$13
  implements Runnable
{
  public ChatActivityFacade$13(boolean paramBoolean1, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, boolean paramBoolean2) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((awwg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ChatActivityFacade", 1, "life circle2:", localException);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.13
 * JD-Core Version:    0.7.0.1
 */