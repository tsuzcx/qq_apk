package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class QQAppInterface$19
  implements Runnable
{
  QQAppInterface$19(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAppInterface", 2, "isCallTabShow needupdate,result=" + this.val$result);
    }
    SettingCloneUtil.writeValue(this.this$0.getApplication(), this.this$0.getCurrentAccountUin(), null, "qqsetting_calltab_show_key", this.val$result.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.19
 * JD-Core Version:    0.7.0.1
 */