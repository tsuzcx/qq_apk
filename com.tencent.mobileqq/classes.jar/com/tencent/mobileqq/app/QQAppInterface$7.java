package com.tencent.mobileqq.app;

import android.content.Intent;
import anvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

class QQAppInterface$7
  implements Runnable
{
  QQAppInterface$7(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!QQAppInterface.access$2400(this.this$0).verifyAuthentication())
    {
      QLog.e("QQAppInterface", 1, "", new RuntimeException("WTF"));
      if (this.this$0.isLogin()) {
        this.this$0.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", anvx.a(2131709575));
      localIntent.putExtra("msg", anvx.a(2131709577));
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.7
 * JD-Core Version:    0.7.0.1
 */