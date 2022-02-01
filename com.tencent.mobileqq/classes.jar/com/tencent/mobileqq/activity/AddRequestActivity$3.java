package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class AddRequestActivity$3
  implements View.OnClickListener
{
  AddRequestActivity$3(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B757", "0X800B757", 0, 0, this.b, this.c, "", "");
      if (QLog.isColorLevel())
      {
        localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setEntityInfo jumpurl:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.3
 * JD-Core Version:    0.7.0.1
 */