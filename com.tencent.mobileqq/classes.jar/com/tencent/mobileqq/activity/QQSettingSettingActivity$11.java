package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QQSettingSettingActivity$11
  extends CardObserver
{
  QQSettingSettingActivity$11(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      if (paramBoolean1) {
        this.a.a(this.a.app.getCurrentAccountUin());
      }
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    QLog.e("QQSetting2Activity", 2, "onGetAllowSeeLoginDays isSuccess " + paramBoolean1 + "isAllow:" + paramBoolean2 + "uin " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */