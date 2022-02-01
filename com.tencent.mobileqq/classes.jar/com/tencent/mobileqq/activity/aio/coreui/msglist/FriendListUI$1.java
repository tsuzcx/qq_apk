package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendListUI$1
  implements Runnable
{
  FriendListUI$1(FriendListUI paramFriendListUI) {}
  
  public void run()
  {
    BaseSessionInfo localBaseSessionInfo = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (!UinTypeUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageProxy(localBaseSessionInfo.jdField_a_of_type_Int).d(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int))) {
      return;
    }
    this.this$0.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    ((ChatContext)this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.a).a(this.this$0.jdField_a_of_type_Long);
    this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.e = false;
    this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.f = true;
    if (this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.c == 0)
    {
      RefreshMessageContext localRefreshMessageContext = this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
      localRefreshMessageContext.c += 1;
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int, 15, this.this$0.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI.1
 * JD-Core Version:    0.7.0.1
 */