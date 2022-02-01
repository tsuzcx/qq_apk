package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
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
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(this.a, this.b.getRecentUserUin());
    Object localObject = (IPublicAccountDataManager)this.a.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      ((IPublicAccountDataManager)localObject).delPublicAccountInfoCache(this.b.getRecentUserUin());
      ((IPublicAccountDataManager)localObject).delPublicAccountInfo(this.b.getRecentUserUin());
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.b.getRecentUserUin());
      if (localObject != null) {
        RecentPubAccHelper.a(this.this$0, (IPublicAccountDetail)localObject, this.a);
      }
    }
    this.a.getMessageFacade().c(this.b.getRecentUserUin(), 1008);
    RecentUtil.b(this.a, this.b.getRecentUserUin(), 1008);
    PAStartupTracker.a(" pubAcc_follow_cancel", null, this.b.getRecentUserUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */