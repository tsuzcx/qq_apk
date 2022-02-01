package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;

class QQSettingSettingActivity$15
  implements Runnable
{
  QQSettingSettingActivity$15(QQSettingSettingActivity paramQQSettingSettingActivity, FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    Card localCard = this.a.f(this.b);
    this.this$0.runOnUiThread(new QQSettingSettingActivity.15.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.15
 * JD-Core Version:    0.7.0.1
 */