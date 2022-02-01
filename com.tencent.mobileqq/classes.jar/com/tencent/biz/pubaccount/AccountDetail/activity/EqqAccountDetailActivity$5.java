package com.tencent.biz.pubaccount.AccountDetail.activity;

import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivity$5
  implements Runnable
{
  EqqAccountDetailActivity$5(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailInSubThread");
    }
    this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity.5
 * JD-Core Version:    0.7.0.1
 */