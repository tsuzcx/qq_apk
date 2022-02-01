package com.tencent.mobileqq.activity.recent;

import alol;
import alpb;
import aody;
import bhnx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import obj;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(alol paramalol, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    obj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    Object localObject = (aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      ((aody)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      ((aody)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      localObject = ((aody)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      if (localObject != null) {
        alol.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    alpb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    bhnx.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */