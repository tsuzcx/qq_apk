package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class AccountManageActivity$DelHistoryAccountObserver
  extends AccountObserver
{
  private String b;
  private boolean c = false;
  
  public AccountManageActivity$DelHistoryAccountObserver(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DelHistoryAccountObserver onDeleteAccount isSuccess ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",peerUin:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(",isDeleteHistory:");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("Switch_Account", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((AccountManageActivity)localObject).getSharedPreferences("Last_Login", i);
    if ((paramBoolean) && (localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.b)))
    {
      ((SharedPreferences)localObject).edit().remove("uin").commit();
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "delete Last_Login");
      }
    }
    if ((paramBoolean) && (this.c)) {
      this.a.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.DelHistoryAccountObserver
 * JD-Core Version:    0.7.0.1
 */