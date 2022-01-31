package com.tencent.mobileqq.activity.aio.rebuild;

import agot;
import agpq;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;

public class PublicAccountChatPie$34$1
  implements Runnable
{
  public PublicAccountChatPie$34$1(agpq paramagpq, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    AccountDetail localAccountDetail = new AccountDetail(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
    awbw localawbw = this.jdField_a_of_type_Agpq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_Agpq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
    if (localawbw != null) {
      localawbw.b(localAccountDetail);
    }
    this.jdField_a_of_type_Agpq.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount(localAccountDetail, 0L);
    this.jdField_a_of_type_Agpq.a.a(this.jdField_a_of_type_Agpq.a.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.34.1
 * JD-Core Version:    0.7.0.1
 */