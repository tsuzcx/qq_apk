package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityFacade$15
  implements Runnable
{
  ChatActivityFacade$15(ChatActivityFacade.SendMsgParams paramSendMsgParams, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityFacade$SendMsgParams.a) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.15
 * JD-Core Version:    0.7.0.1
 */