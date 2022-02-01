package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
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
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localPublicAccountDetailActivityImpl.saveAccountDetailToDBAndCache(localPublicAccountDetailActivityImpl.accountDetail);
    this.this$0.publicAccountHandler.onFollowPublicAccount(this.this$0.accountDetail);
    this.this$0.sendDetailInfoRequest();
    boolean bool;
    if (this.this$0.mProfileParams == null) {
      bool = true;
    } else {
      bool = false;
    }
    PAStartupTracker.a("pubAcc_follow_confirm", null, this.this$0.uin);
    localPublicAccountDetailActivityImpl = this.this$0;
    if (localPublicAccountDetailActivityImpl.tryGoToWeatherWhenFollow(localPublicAccountDetailActivityImpl.accountDetail)) {
      return;
    }
    PublicAccountDetailActivityImpl.access$301(this.this$0, new PublicAccountDetailActivityImpl.6.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.6
 * JD-Core Version:    0.7.0.1
 */