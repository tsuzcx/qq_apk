package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQSettingMe$35
  extends CardObserver
{
  QQSettingMe$35(QQSettingMe paramQQSettingMe) {}
  
  public void onAnonymousSettingMeRedPoint(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onAnonymousSettingMeRedPoint success=%s enable=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    if ((paramBoolean1) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
  }
  
  public void onGetMedal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.a.c), Boolean.valueOf(paramBoolean2) }));
    }
  }
  
  public void onGetSignInInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new QQSettingMe.35.1(this));
    }
  }
  
  public void onSetMedal(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onSetMedal [%b %b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.a.c) }));
    }
  }
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.a != null) && (Utils.a(paramString, this.a.a.getCurrentAccountUin()))) {
      this.a.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.35
 * JD-Core Version:    0.7.0.1
 */