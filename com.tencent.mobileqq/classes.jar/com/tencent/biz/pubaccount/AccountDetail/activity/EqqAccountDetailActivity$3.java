package com.tencent.biz.pubaccount.AccountDetail.activity;

import android.os.Handler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivity$3
  implements Runnable
{
  EqqAccountDetailActivity$3(EqqAccountDetailActivity paramEqqAccountDetailActivity, EqqDetail paramEqqDetail, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "updateDetailInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      if (this.jdField_a_of_type_Boolean) {
        EqqAccountDetailActivity.a(this.this$0).sendEmptyMessage(1);
      }
    }
    else
    {
      return;
    }
    EqqAccountDetailActivity.a(this.this$0, new EqqAccountDetailActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */