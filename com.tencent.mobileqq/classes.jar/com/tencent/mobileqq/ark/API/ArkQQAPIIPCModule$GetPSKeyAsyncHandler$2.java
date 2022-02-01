package com.tencent.mobileqq.ark.API;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ArkQQAPIIPCModule$GetPSKeyAsyncHandler$2
  implements WtTicketPromise
{
  ArkQQAPIIPCModule$GetPSKeyAsyncHandler$2(ArkQQAPIIPCModule.GetPSKeyAsyncHandler paramGetPSKeyAsyncHandler, TicketManager paramTicketManager, QQAppInterface paramQQAppInterface, String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.GetPSKeyAsyncHandler", 2, "--- pskey async done---  ");
    }
    paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler.a(paramTicket);
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "--- pskey async failed---  " + paramErrMsg.getMessage());
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler.a(null);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "--- pskey async timeout---  " + paramErrMsg.getMessage());
    if (this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$GetPSKeyAsyncHandler$OnGetPSKeyHandler.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.GetPSKeyAsyncHandler.2
 * JD-Core Version:    0.7.0.1
 */