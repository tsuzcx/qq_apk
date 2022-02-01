package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class QQSettingSettingActivity$12
  extends ProfileCardObserver
{
  QQSettingSettingActivity$12(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      String str = this.a.app.getCurrentAccountUin();
      paramObject = (Card)paramObject;
      if (str.equals(paramObject.uin)) {
        QQSettingSettingActivity.a(this.a, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */