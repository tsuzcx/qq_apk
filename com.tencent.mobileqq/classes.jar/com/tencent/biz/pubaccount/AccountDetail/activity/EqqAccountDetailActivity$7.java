package com.tencent.biz.pubaccount.AccountDetail.activity;

import annt;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivity$7
  implements Runnable
{
  EqqAccountDetailActivity$7(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "updateFollowInfo");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      EqqAccountDetailActivity.b(this.this$0).a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.this$0.d();
      annt.a(EqqAccountDetailActivity.g(this.this$0)).a(EqqAccountDetailActivity.f(this.this$0), this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, true);
      if (EqqAccountDetailActivity.a(this.this$0) != null) {
        break label130;
      }
    }
    for (;;)
    {
      if (i != 0) {
        EqqAccountDetailActivity.b(this.this$0, new EqqAccountDetailActivity.7.1(this));
      }
      return;
      label130:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.7
 * JD-Core Version:    0.7.0.1
 */