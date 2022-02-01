package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

class RecentPubAccHelper$4
  implements Runnable
{
  RecentPubAccHelper$4(RecentPubAccHelper paramRecentPubAccHelper, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      localObject = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
      if (localObject != null) {
        RecentPubAccHelper.a(this.this$0, (AccountDetail)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 1008);
    PAStartupTracker.a(" pubAcc_follow_cancel", null, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */