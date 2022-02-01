package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$12
  implements Runnable
{
  PublicAccountDetailActivityImpl$12(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "initData loadDatabase");
    }
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localPublicAccountDetailActivityImpl.isFirst = (localPublicAccountDetailActivityImpl.loadDatabase() ^ true);
    PublicAccountDetailActivityImpl.access$1101(this.this$0, new PublicAccountDetailActivityImpl.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.12
 * JD-Core Version:    0.7.0.1
 */