package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.util.Utils;

class QQSettingMe$37
  extends AvatarObserver
{
  QQSettingMe$37(QQSettingMe paramQQSettingMe) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.a != null) && (Utils.a(paramString, this.a.a.getCurrentAccountUin()))) {
      this.a.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.37
 * JD-Core Version:    0.7.0.1
 */