package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$7
  implements Runnable
{
  EqqAccountDetailActivityImpl$7(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateFollowInfo");
    }
    if (this.this$0.eqqDetail != null)
    {
      this.this$0.saveEqqDetailToDBAndCache(this.this$0.eqqDetail);
      this.this$0.publicAccountHandler.a(this.this$0.eqqDetail);
      this.this$0.sendDetailInfoRequest();
      EnterpriseQQManager.a(this.this$0.app).a(this.this$0.app, this.this$0.eqqDetail.uin, true);
      if (this.this$0.mProfileParams != null) {
        break label130;
      }
    }
    for (;;)
    {
      if (i != 0) {
        EqqAccountDetailActivityImpl.access$101(this.this$0, new EqqAccountDetailActivityImpl.7.1(this));
      }
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.7
 * JD-Core Version:    0.7.0.1
 */