package com.tencent.mobileqq.activity.recent;

import ahcb;
import ahcq;
import ajoy;
import badx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import ncw;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(ahcb paramahcb, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    ncw.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
    Object localObject = (ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      ((ajoy)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      ((ajoy)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      localObject = ((ajoy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      if (localObject != null) {
        ahcb.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    ahcq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    badx.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */