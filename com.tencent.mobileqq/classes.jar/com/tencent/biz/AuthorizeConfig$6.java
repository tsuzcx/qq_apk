package com.tencent.biz;

import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

class AuthorizeConfig$6
  implements Runnable
{
  AuthorizeConfig$6(AuthorizeConfig paramAuthorizeConfig, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        this.a.getPskey(this.b, 16L, this.c, this.this$0.B);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, new Object[] { "[preload] preloadPskey exception ", localException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.6
 * JD-Core Version:    0.7.0.1
 */