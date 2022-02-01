package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Handler;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$21
  implements Runnable
{
  PublicAccountDetailActivityImpl$21(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, PublicAccountDetailImpl paramPublicAccountDetailImpl, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.this$0.saveAccountDetailToDBAndCache(this.a);
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.a;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.followType == 1) && (this.a.isSyncLbs)) {
      this.this$0.publicAccountHandler.onFollowPublicAccount(this.a);
    }
    if (this.this$0.tryGoToWeatherWhenGetInfo(this.a)) {
      return;
    }
    if (this.b)
    {
      this.this$0.mHandler.sendEmptyMessage(1);
      return;
    }
    PublicAccountDetailActivityImpl.access$1301(this.this$0, new PublicAccountDetailActivityImpl.21.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.21
 * JD-Core Version:    0.7.0.1
 */