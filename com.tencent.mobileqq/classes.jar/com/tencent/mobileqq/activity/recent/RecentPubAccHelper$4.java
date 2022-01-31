package com.tencent.mobileqq.activity.recent;

import ahoo;
import ahpd;
import akdh;
import bbfq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import nnu;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(ahoo paramahoo, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    nnu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
    Object localObject = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      ((akdh)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      ((akdh)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      localObject = ((akdh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      if (localObject != null) {
        ahoo.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    bbfq.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */