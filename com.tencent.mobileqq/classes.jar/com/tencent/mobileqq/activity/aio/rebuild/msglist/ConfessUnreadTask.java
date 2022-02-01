package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class ConfessUnreadTask
  extends UnreadTask
{
  public ConfessUnreadTask(AIOContext paramAIOContext, BaseChatPie paramBaseChatPie)
  {
    super(paramAIOContext);
  }
  
  public int b()
  {
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.e);
    if (QLog.isColorLevel()) {
      QLog.d("ConfessUnreadTask", 2, "initHaveUnRead count " + i);
    }
    return i;
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    ConfessMsgUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.e, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessUnreadTask
 * JD-Core Version:    0.7.0.1
 */