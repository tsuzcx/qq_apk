package com.tencent.mobileqq.activity.aio.qim;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QIMUserManager$1
  implements Runnable
{
  QIMUserManager$1(QIMUserManager paramQIMUserManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if (QIMUserManager.a(this.this$0, this.a, this.b) == 0)
    {
      if (QIMUserManager.a(this.this$0, this.b))
      {
        QIMUserManager.a(this.this$0);
        QIMUserManager.a(this.this$0, false);
        QIMUserManager.a(this.this$0, 2);
        localObject = PreferenceManager.getDefaultSharedPreferences(this.c.getApp()).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("qim_user_special_need_force_download", QIMUserManager.b(this.this$0));
        ((SharedPreferences.Editor)localObject).commit();
      }
      else
      {
        QIMUserManager.a(this.this$0, 4);
      }
    }
    else {
      QIMUserManager.a(this.this$0, 3);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" startDownLoadQimTheme QimIconsState ");
      ((StringBuilder)localObject).append(QIMUserManager.c(this.this$0));
      QLog.i("QIMUserManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */