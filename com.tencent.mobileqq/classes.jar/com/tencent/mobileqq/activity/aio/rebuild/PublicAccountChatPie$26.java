package com.tencent.mobileqq.activity.aio.rebuild;

import agti;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import nrc;
import syb;

public class PublicAccountChatPie$26
  implements Runnable
{
  public PublicAccountChatPie$26(agti paramagti, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "updateUnfollowInfo");
    }
    if (this.this$0.aa)
    {
      int i = syb.a(this.a.accountFlag);
      if ((i == -3) || (i == -4)) {
        nrc.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.uin);
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a);
    }
    agti.b(this.this$0, this.a);
    agti.a(this.this$0).post(new PublicAccountChatPie.26.1(this));
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.26
 * JD-Core Version:    0.7.0.1
 */