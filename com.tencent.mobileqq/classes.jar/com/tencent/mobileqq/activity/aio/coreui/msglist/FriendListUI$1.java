package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendListUI$1
  implements Runnable
{
  FriendListUI$1(FriendListUI paramFriendListUI) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (!UinTypeUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(localSessionInfo.jdField_a_of_type_Int).d(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      this.this$0.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.a).a(this.this$0.jdField_a_of_type_Long);
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f = true;
    } while (this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.c != 0);
    QQMessageFacade.RefreshMessageContext localRefreshMessageContext = this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext;
    localRefreshMessageContext.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, 15, this.this$0.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI.1
 * JD-Core Version:    0.7.0.1
 */