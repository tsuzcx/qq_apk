package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$6
  implements Runnable
{
  EqqAccountDetailActivityImpl$6(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateUnfollowInfo");
    }
    if (this.this$0.eqqDetail != null) {}
    try
    {
      this.this$0.publicAccountHandler.b(this.this$0.eqqDetail);
      this.this$0.deleteAccount(this.this$0.eqqDetail);
      this.this$0.mHandler.sendEmptyMessage(2);
      this.this$0.app.getMessageFacade().a(this.this$0.uin, 1008);
      this.this$0.app.getMessageFacade().a(this.this$0.uin, 1024);
      this.this$0.app.getMessageFacade().a(this.this$0.uin, 0);
      ReportController.b(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", this.this$0.uin, "0X8004E43", "0X8004E43", 0, 0, this.this$0.uin, "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.6
 * JD-Core Version:    0.7.0.1
 */