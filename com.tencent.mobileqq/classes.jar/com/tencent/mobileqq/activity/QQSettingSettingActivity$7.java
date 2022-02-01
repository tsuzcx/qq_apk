package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class QQSettingSettingActivity$7
  implements Runnable
{
  QQSettingSettingActivity$7(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    CUOpenCardGuideMng localCUOpenCardGuideMng = (CUOpenCardGuideMng)this.this$0.app.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
    localCUOpenCardGuideMng.b();
    this.this$0.j = localCUOpenCardGuideMng.a(0);
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide later init entry: %s ", new Object[] { this.this$0.j }));
    }
    this.this$0.runOnUiThread(new QQSettingSettingActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */