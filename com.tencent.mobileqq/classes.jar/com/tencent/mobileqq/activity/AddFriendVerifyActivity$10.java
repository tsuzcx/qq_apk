package com.tencent.mobileqq.activity;

import android.content.Context;
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
    Object localObject = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    int i = 0;
    while (i < AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).size())
    {
      String str = ((EditText)AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).get(i)).getText().toString().trim();
      if ("".equals(str))
      {
        i = 1;
        break label92;
      }
      localObject = ((String)localObject).replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str));
      i += 1;
    }
    i = 0;
    label92:
    if (i != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity;
      QQToast.a((Context)localObject, 0, ((AddFriendVerifyActivity)localObject).getString(2131690017), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a((String)localObject, null, "");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.b), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.c)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_Int, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.10
 * JD-Core Version:    0.7.0.1
 */