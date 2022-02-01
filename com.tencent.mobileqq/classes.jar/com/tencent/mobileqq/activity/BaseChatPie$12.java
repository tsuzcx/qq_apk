package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$12
  implements Runnable
{
  BaseChatPie$12(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("forward", 1, "updateSession_forwardType, postDelayed Run! needToBottom=" + this.jdField_a_of_type_Boolean);
    }
    this.this$0.f(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.X();
    }
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.removeExtra("isFromShare");
      String str2 = this.b.getStringExtra("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131690563);
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 2, "set left text from forward: " + str1);
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      this.this$0.aU();
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.12
 * JD-Core Version:    0.7.0.1
 */