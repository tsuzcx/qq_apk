package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$3
  implements Runnable
{
  EqqAccountDetailActivityImpl$3(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, EqqDetail paramEqqDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "updateDetailInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.this$0.saveEqqDetailToDBAndCache(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.this$0.notifyUpdateDetailInfo(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      if (this.jdField_a_of_type_Boolean) {
        this.this$0.mHandler.sendEmptyMessage(1);
      }
    }
    else
    {
      return;
    }
    EqqAccountDetailActivityImpl.access$001(this.this$0, new EqqAccountDetailActivityImpl.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */