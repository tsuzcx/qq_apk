package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class PublicAccountChatPie$42
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$42(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bi();
    if (!paramBoolean)
    {
      this.a.w(2131695222);
      return;
    }
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)localEntityManager.find(AccountDetail.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localAccountDetail != null) {
      localEntityManager.remove(localAccountDetail);
    }
    localEntityManager.close();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.K();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.42
 * JD-Core Version:    0.7.0.1
 */