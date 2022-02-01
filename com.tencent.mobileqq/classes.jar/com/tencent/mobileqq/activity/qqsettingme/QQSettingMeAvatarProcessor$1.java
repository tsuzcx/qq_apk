package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.util.Utils;
import mqq.app.AppRuntime;

class QQSettingMeAvatarProcessor$1
  extends AvatarObserver
{
  QQSettingMeAvatarProcessor$1(QQSettingMeAvatarProcessor paramQQSettingMeAvatarProcessor) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_MqqAppAppRuntime != null) && (Utils.a(paramString, this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))) {
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeAvatarProcessor.1
 * JD-Core Version:    0.7.0.1
 */