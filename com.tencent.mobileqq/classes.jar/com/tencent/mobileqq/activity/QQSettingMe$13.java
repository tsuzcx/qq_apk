package com.tencent.mobileqq.activity;

import babh;
import com.tencent.mobileqq.app.BaseActivity;

class QQSettingMe$13
  implements Runnable
{
  QQSettingMe$13(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    String str2 = babh.i(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2.trim())) {}
    }
    else
    {
      str1 = this.a;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.13.1(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.13
 * JD-Core Version:    0.7.0.1
 */