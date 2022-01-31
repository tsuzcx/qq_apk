package com.tencent.mobileqq.activity.recent;

import ajfx;
import ajgm;
import aluw;
import bdel;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import nrc;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(ajfx paramajfx, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    nrc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
    Object localObject = (aluw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null)
    {
      ((aluw)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      ((aluw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      localObject = ((aluw)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      if (localObject != null) {
        ajfx.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    ajgm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), 1008);
    bdel.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */