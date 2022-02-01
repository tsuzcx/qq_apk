package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;

class QQSettingSettingActivity$13
  implements Runnable
{
  QQSettingSettingActivity$13(QQSettingSettingActivity paramQQSettingSettingActivity, FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    this.this$0.runOnUiThread(new QQSettingSettingActivity.13.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */