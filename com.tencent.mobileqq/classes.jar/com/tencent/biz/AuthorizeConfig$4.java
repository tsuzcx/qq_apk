package com.tencent.biz;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class AuthorizeConfig$4
  implements WtTicketPromise
{
  AuthorizeConfig$4(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void Done(Ticket paramTicket)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preload] Done ticket:");
    localStringBuilder.append(paramTicket._type);
    QLog.i("AuthorizeConfig", 1, localStringBuilder.toString());
    if (paramTicket._type == 1048576)
    {
      AuthorizeConfig.a(this.a, false);
      this.a.p();
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preload] Failed error:");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.e("AuthorizeConfig", 1, localStringBuilder.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preload] Timeout :");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.e("AuthorizeConfig", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.4
 * JD-Core Version:    0.7.0.1
 */