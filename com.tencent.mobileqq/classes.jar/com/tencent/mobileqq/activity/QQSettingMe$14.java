package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ContactUtils;

class QQSettingMe$14
  implements Runnable
{
  QQSettingMe$14(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    String str2 = ContactUtils.getFriendNickName(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a);
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
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.14.1(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.14
 * JD-Core Version:    0.7.0.1
 */