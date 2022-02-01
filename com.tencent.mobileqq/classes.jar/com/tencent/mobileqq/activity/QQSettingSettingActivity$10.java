package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

class QQSettingSettingActivity$10
  extends FriendListObserver
{
  QQSettingSettingActivity$10(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    this.a.a(this.a.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */