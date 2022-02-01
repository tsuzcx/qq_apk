package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.regex.Matcher;

class AddFriendVerifyActivity$10
  implements View.OnClickListener
{
  AddFriendVerifyActivity$10(AddFriendVerifyActivity paramAddFriendVerifyActivity, StringBuffer paramStringBuffer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
    String str1 = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    int i = 0;
    String str2;
    if (i < AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).size())
    {
      str2 = ((EditText)AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).get(i)).getText().toString().trim();
      if (!"".equals(str2)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131690101), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.jdField_a_of_type_Int + " subSourceId = " + this.b);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_Int, this.c);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str1 = str1.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str2));
        i += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(str1, null, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.10
 * JD-Core Version:    0.7.0.1
 */