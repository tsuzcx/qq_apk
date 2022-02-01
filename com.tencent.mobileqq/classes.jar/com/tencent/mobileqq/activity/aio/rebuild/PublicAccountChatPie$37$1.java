package com.tencent.mobileqq.activity.aio.rebuild;

import ainh;
import aioe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class PublicAccountChatPie$37$1
  implements Runnable
{
  public PublicAccountChatPie$37$1(aioe paramaioe, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    EntityManager localEntityManager = this.jdField_a_of_type_Aioe.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_Aioe.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localAccountDetail);
    }
    this.jdField_a_of_type_Aioe.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount(localAccountDetail, 0L);
    this.jdField_a_of_type_Aioe.a.a(this.jdField_a_of_type_Aioe.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.37.1
 * JD-Core Version:    0.7.0.1
 */