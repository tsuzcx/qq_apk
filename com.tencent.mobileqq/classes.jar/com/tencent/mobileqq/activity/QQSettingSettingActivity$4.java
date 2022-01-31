package com.tencent.mobileqq.activity;

import atzp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class QQSettingSettingActivity$4
  implements Runnable
{
  QQSettingSettingActivity$4(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    atzp localatzp = (atzp)this.this$0.app.getManager(221);
    localatzp.a();
    this.this$0.a = localatzp.a(0);
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide later init entry: %s ", new Object[] { this.this$0.a }));
    }
    this.this$0.runOnUiThread(new QQSettingSettingActivity.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */