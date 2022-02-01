package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QQSettingSettingActivity$13
  extends CardObserver
{
  QQSettingSettingActivity$13(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      if (paramBoolean1)
      {
        paramString = this.a;
        paramString.a(paramString.app.getCurrentAccountUin());
      }
    }
    else
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramString = new StringBuilder();
      paramString.append("onGetAllowSeeLoginDays isSuccess ");
      paramString.append(paramBoolean1);
      paramString.append("isAllow:");
      paramString.append(paramBoolean2);
      paramString.append("uin ");
      paramString.append(str);
      QLog.e("QQSetting2Activity", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */