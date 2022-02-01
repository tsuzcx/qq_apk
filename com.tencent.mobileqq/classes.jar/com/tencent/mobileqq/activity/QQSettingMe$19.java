package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

class QQSettingMe$19
  implements Runnable
{
  QQSettingMe$19(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    String str;
    do
    {
      return;
      str = this.this$0.a.getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.b(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.19
 * JD-Core Version:    0.7.0.1
 */