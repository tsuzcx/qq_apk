package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class AuthorizeConfig$7
  implements Runnable
{
  AuthorizeConfig$7(AuthorizeConfig paramAuthorizeConfig, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.a == null) {
        break label101;
      }
      if ((this.a.getPskey(this.b, 16L, this.c, this.this$0.B) == null) || (TextUtils.isEmpty(this.a.getSkey(this.b)))) {
        break label106;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        label101:
        continue;
        label106:
        boolean bool = false;
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre hits result : ");
    localStringBuilder.append(bool);
    QLog.d("AuthorizeConfig", 1, localStringBuilder.toString());
    return;
    QLog.e("AuthorizeConfig", 1, "preload k exception ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.7
 * JD-Core Version:    0.7.0.1
 */