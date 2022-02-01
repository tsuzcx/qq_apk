package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PublicAccountChatPie$29
  implements Runnable
{
  PublicAccountChatPie$29(PublicAccountChatPie paramPublicAccountChatPie, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "updateUnfollowInfo");
    }
    if (this.this$0.U)
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.a.accountFlag);
      if ((i == -3) || (i == -4)) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.uin);
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a);
    }
    PublicAccountChatPie.b(this.this$0, this.a);
    PublicAccountChatPie.a(this.this$0).post(new PublicAccountChatPie.29.1(this));
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.29
 * JD-Core Version:    0.7.0.1
 */