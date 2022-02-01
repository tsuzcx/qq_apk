package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import aiel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

public class PublicAccountChatPie$37$1
  implements Runnable
{
  public PublicAccountChatPie$37$1(aiel paramaiel, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    EntityManager localEntityManager = this.jdField_a_of_type_Aiel.a.app.getEntityManagerFactory(this.jdField_a_of_type_Aiel.a.app.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localAccountDetail);
    }
    this.jdField_a_of_type_Aiel.a.a = PublicAccountInfo.createPublicAccount(localAccountDetail, 0L);
    this.jdField_a_of_type_Aiel.a.a(this.jdField_a_of_type_Aiel.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.37.1
 * JD-Core Version:    0.7.0.1
 */