package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Handler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$3
  implements Runnable
{
  PublicAccountDetailActivityImpl$3(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateUnfollowInfo");
    }
    if (this.this$0.isNewSubscriptAIOUser)
    {
      int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.this$0.accountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(this.this$0.app, this.this$0.accountDetail.uin);
      }
    }
    this.this$0.mHandler.sendEmptyMessage(2);
    this.this$0.app.getMessageFacade().a(this.this$0.uin, 1008);
    this.this$0.publicAccountHandler.b(this.this$0.accountDetail);
    this.this$0.deleteAccount(this.this$0.accountDetail);
    RecentUtil.b(this.this$0.app, this.this$0.uin, 1008);
    ReportController.b(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "0X8004E43", "0X8004E43", 0, 0, this.this$0.uin, "", "", "");
    PAStartupTracker.a(" pubAcc_follow_cancel", null, this.this$0.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */