package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$7
  implements View.OnClickListener
{
  AddFriendVerifyActivity$7(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a("", null, "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportClickEvent action: 0X80077B4  sourceId = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" subSourceId = ");
      localStringBuilder.append(this.b);
      QLog.d("AddFriendVerifyActivity", 2, localStringBuilder.toString());
    }
    if (Utils.b(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.7
 * JD-Core Version:    0.7.0.1
 */