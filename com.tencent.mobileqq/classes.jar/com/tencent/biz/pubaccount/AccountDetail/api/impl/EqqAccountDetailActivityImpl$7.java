package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$7
  implements Runnable
{
  EqqAccountDetailActivityImpl$7(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateFollowInfo");
    }
    if (this.this$0.eqqDetail != null)
    {
      Object localObject = this.this$0;
      ((EqqAccountDetailActivityImpl)localObject).saveEqqDetailToDBAndCache(((EqqAccountDetailActivityImpl)localObject).eqqDetail);
      this.this$0.publicAccountHandler.onFollowPublicAccount(this.this$0.eqqDetail);
      this.this$0.sendDetailInfoRequest();
      localObject = EnterpriseQQManager.a(this.this$0.app);
      QQAppInterface localQQAppInterface = this.this$0.app;
      String str = this.this$0.eqqDetail.uin;
      int i = 1;
      ((EnterpriseQQManager)localObject).a(localQQAppInterface, str, true);
      if (this.this$0.mProfileParams != null) {
        i = 0;
      }
      if (i != 0) {
        EqqAccountDetailActivityImpl.access$101(this.this$0, new EqqAccountDetailActivityImpl.7.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.7
 * JD-Core Version:    0.7.0.1
 */