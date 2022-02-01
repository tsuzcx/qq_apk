package com.tencent.mobileqq.activity.recent;

import alhu;
import alik;
import aoan;
import bhfm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import okn;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(alhu paramalhu, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    okn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    Object localObject = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      ((aoan)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      ((aoan)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      localObject = ((aoan)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      if (localObject != null) {
        alhu.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    alik.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    bhfm.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */