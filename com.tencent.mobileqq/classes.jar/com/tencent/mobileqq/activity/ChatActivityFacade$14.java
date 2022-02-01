package com.tencent.mobileqq.activity;

import acwc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ChatActivityFacade$14
  implements Runnable
{
  public ChatActivityFacade$14(acwc paramacwc, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acwc.a) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearDraftText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.14
 * JD-Core Version:    0.7.0.1
 */