package com.tencent.mobileqq.activity.aio.tim;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class TIMUserManager$1
  implements Runnable
{
  TIMUserManager$1(TIMUserManager paramTIMUserManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if (TIMUserManager.a(this.this$0, this.a, this.b) == 0)
    {
      if (TIMUserManager.a(this.this$0, this.b))
      {
        TIMUserManager.a(this.this$0);
        TIMUserManager.a(this.this$0, false);
        TIMUserManager.a(this.this$0, 2);
        localObject = PreferenceManager.getDefaultSharedPreferences(this.c.getApp()).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("tim_user_special_need_force_download", TIMUserManager.b(this.this$0));
        ((SharedPreferences.Editor)localObject).commit();
      }
      else
      {
        TIMUserManager.a(this.this$0, 4);
      }
    }
    else {
      TIMUserManager.a(this.this$0, 3);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" startDownLoadTimTheme TimIconsState ");
      ((StringBuilder)localObject).append(TIMUserManager.c(this.this$0));
      QLog.i("TIMUserManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.1
 * JD-Core Version:    0.7.0.1
 */