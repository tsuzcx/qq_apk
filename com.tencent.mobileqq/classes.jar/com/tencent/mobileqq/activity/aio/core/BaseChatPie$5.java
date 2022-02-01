package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$5
  implements Runnable
{
  BaseChatPie$5(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSession_forwardType, postDelayed Run! needToBottom=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("forward", 1, ((StringBuilder)localObject).toString());
    }
    this.this$0.f(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_Boolean) {
      BaseChatPie.c(this.this$0);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false))
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("forward_type");
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("isFromShare");
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("leftBackText");
      if (str != null)
      {
        localObject = str;
        if (!"".equals(str)) {}
      }
      else
      {
        localObject = this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131690706);
      }
      if (QLog.isColorLevel())
      {
        str = this.this$0.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set left text from forward: ");
        localStringBuilder.append((String)localObject);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.this$0.ai();
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.5
 * JD-Core Version:    0.7.0.1
 */