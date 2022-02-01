package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountChatPie$38$1
  implements Runnable
{
  PublicAccountChatPie$38$1(PublicAccountChatPie.38 param38, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class)).init(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$38.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$38.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localIPublicAccountDetail.getEntity());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$38.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount(localIPublicAccountDetail, 0L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$38.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie$38.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38.1
 * JD-Core Version:    0.7.0.1
 */