package com.tencent.biz.pubaccount.AccountDetail.activity;

import android.os.Handler;
import awqx;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivity$6
  implements Runnable
{
  EqqAccountDetailActivity$6(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "updateUnfollowInfo");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    try
    {
      EqqAccountDetailActivity.a(this.this$0).b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.this$0.c(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      EqqAccountDetailActivity.b(this.this$0).sendEmptyMessage(2);
      EqqAccountDetailActivity.b(this.this$0).a().a(EqqAccountDetailActivity.b(this.this$0), EqqAccountDetailActivity.c(this.this$0));
      EqqAccountDetailActivity.c(this.this$0).a().a(EqqAccountDetailActivity.c(this.this$0), 1024);
      EqqAccountDetailActivity.d(this.this$0).a().a(EqqAccountDetailActivity.d(this.this$0), 0);
      awqx.b(EqqAccountDetailActivity.e(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.e(this.this$0), "0X8004E43", "0X8004E43", 0, 0, EqqAccountDetailActivity.f(this.this$0), "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */