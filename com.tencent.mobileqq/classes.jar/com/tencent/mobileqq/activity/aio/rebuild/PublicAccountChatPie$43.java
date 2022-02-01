package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountChatPie$43
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$43(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.ao();
    if (!paramBoolean)
    {
      this.a.m(2131695217);
      return;
    }
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    IPublicAccountDetail localIPublicAccountDetail = (IPublicAccountDetail)localEntityManager.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localIPublicAccountDetail != null) {
      localEntityManager.remove(localIPublicAccountDetail.getEntity());
    }
    localEntityManager.close();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1008);
    this.a.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.43
 * JD-Core Version:    0.7.0.1
 */