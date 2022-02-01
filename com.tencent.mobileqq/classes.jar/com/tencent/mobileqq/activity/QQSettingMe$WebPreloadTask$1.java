package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$WebPreloadTask$1
  implements WebProcessStartListener
{
  QQSettingMe$WebPreloadTask$1(QQSettingMe.WebPreloadTask paramWebPreloadTask, QQSettingMe paramQQSettingMe) {}
  
  public void onResult(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe) != null)) {
      QQSettingMe.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe).a();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("WebPreloadTask preloadWebProcess isProcessExist: ");
      if (paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQSettingRedesign", 2, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.WebPreloadTask.1
 * JD-Core Version:    0.7.0.1
 */