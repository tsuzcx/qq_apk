package com.tencent.biz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AuthorizeConfig$5
  implements Runnable
{
  AuthorizeConfig$5(AuthorizeConfig paramAuthorizeConfig, String paramString, long paramLong) {}
  
  public void run()
  {
    this.this$0.o();
    if (QLog.isColorLevel())
    {
      int i = 0;
      if (this.this$0.C != null) {
        i = this.this$0.C.size();
      }
      QLog.d("AuthorizeConfig", 2, new Object[] { "[preload] preloadPskey list:", Integer.valueOf(i), " waitPt4Token:", Boolean.valueOf(AuthorizeConfig.a(this.this$0)) });
    }
    if (!AuthorizeConfig.a(this.this$0))
    {
      this.this$0.p();
      SharedPreferences.Editor localEditor = this.this$0.w.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lastPreloadPskey");
      localStringBuilder.append(this.a);
      localEditor.putLong(localStringBuilder.toString(), this.b).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.5
 * JD-Core Version:    0.7.0.1
 */