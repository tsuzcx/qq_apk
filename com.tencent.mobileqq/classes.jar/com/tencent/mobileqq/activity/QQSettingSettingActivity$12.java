package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

class QQSettingSettingActivity$12
  extends FriendListObserver
{
  QQSettingSettingActivity$12(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString == null) {
        return;
      }
      paramString = this.a;
      paramString.a(paramString.app.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */