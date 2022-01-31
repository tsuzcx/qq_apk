package com.tencent.mobileqq.activity.aio.rebuild;

import aegy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ncw;
import rtr;

public class PublicAccountChatPie$25
  implements Runnable
{
  public PublicAccountChatPie$25(aegy paramaegy, AccountDetail paramAccountDetail) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "updateUnfollowInfo");
    }
    if (this.this$0.aa)
    {
      int i = rtr.a(this.a.accountFlag);
      if ((i == -3) || (i == -4)) {
        ncw.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.uin);
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a);
    }
    aegy.b(this.this$0, this.a);
    aegy.a(this.this$0).post(new PublicAccountChatPie.25.1(this));
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.25
 * JD-Core Version:    0.7.0.1
 */