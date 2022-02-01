package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$21
  implements Runnable
{
  PublicAccountDetailActivityImpl$21(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, AccountDetail paramAccountDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.this$0.saveAccountDetailToDBAndCache(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs)) {
      this.this$0.publicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    if (this.this$0.tryGoToWeatherWhenGetInfo(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.mHandler.sendEmptyMessage(1);
      return;
    }
    PublicAccountDetailActivityImpl.access$1301(this.this$0, new PublicAccountDetailActivityImpl.21.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.21
 * JD-Core Version:    0.7.0.1
 */