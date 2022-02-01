package com.tencent.mobileqq.ark.api.module;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ArkQQAPIIPCModule$GetPSKeyAsyncHandler$2
  implements WtTicketPromise
{
  ArkQQAPIIPCModule$GetPSKeyAsyncHandler$2(ArkQQAPIIPCModule.GetPSKeyAsyncHandler paramGetPSKeyAsyncHandler, TicketManager paramTicketManager, AppRuntime paramAppRuntime, String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 2, "--- pskey async done---  ");
    }
    paramTicket = this.a.getPskey(this.b.getCurrentAccountUin(), this.c);
    ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler localOnGetPSKeyHandler = this.d;
    if (localOnGetPSKeyHandler != null) {
      localOnGetPSKeyHandler.a(paramTicket);
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--- pskey async failed---  ");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, localStringBuilder.toString());
    paramErrMsg = this.d;
    if (paramErrMsg != null) {
      paramErrMsg.a(null);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--- pskey async timeout---  ");
    localStringBuilder.append(paramErrMsg.getMessage());
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, localStringBuilder.toString());
    paramErrMsg = this.d;
    if (paramErrMsg != null) {
      paramErrMsg.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyAsyncHandler.2
 * JD-Core Version:    0.7.0.1
 */