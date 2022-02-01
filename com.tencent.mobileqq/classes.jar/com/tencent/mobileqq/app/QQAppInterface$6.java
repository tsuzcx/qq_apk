package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

class QQAppInterface$6
  implements Runnable
{
  QQAppInterface$6(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!QQAppInterface.access$1800(this.this$0).verifyAuthentication())
    {
      QLog.e("QQAppInterface", 1, "", new RuntimeException("WTF"));
      if (this.this$0.isLogin()) {
        this.this$0.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", HardCodeUtil.a(2131710078));
      localIntent.putExtra("msg", HardCodeUtil.a(2131710080));
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.6
 * JD-Core Version:    0.7.0.1
 */