package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$6
  implements Runnable
{
  PublicAccountDetailActivityImpl$6(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateFollowInfo");
    }
    this.this$0.saveAccountDetailToDBAndCache(this.this$0.accountDetail);
    this.this$0.publicAccountHandler.a(this.this$0.accountDetail);
    this.this$0.sendDetailInfoRequest();
    if (this.this$0.mProfileParams == null) {}
    for (boolean bool = true;; bool = false)
    {
      PAStartupTracker.a("pubAcc_follow_confirm", null, this.this$0.uin);
      if (!this.this$0.tryGoToWeatherWhenFollow(this.this$0.accountDetail)) {
        break;
      }
      return;
    }
    PublicAccountDetailActivityImpl.access$301(this.this$0, new PublicAccountDetailActivityImpl.6.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.6
 * JD-Core Version:    0.7.0.1
 */