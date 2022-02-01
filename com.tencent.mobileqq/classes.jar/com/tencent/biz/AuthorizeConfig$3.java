package com.tencent.biz;

import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class AuthorizeConfig$3
  implements WtTicketPromise
{
  AuthorizeConfig$3(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void Done(Ticket paramTicket)
  {
    AuthorizeConfig.a(this.a, false);
    this.a.h();
  }
  
  public void Failed(ErrMsg paramErrMsg) {}
  
  public void Timeout(ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.3
 * JD-Core Version:    0.7.0.1
 */