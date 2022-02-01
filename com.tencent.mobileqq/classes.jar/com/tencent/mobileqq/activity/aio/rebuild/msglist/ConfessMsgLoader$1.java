package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class ConfessMsgLoader$1
  implements Runnable
{
  ConfessMsgLoader$1(ConfessMsgLoader paramConfessMsgLoader, AIOContext paramAIOContext) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.e, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessMsgLoader.1
 * JD-Core Version:    0.7.0.1
 */