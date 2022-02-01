package com.tencent.mobileqq.ark.API;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ArkQQAPIIPCModule$3
  implements EIPCResultCallback
{
  ArkQQAPIIPCModule$3(ArkQQAPIIPCModule paramArkQQAPIIPCModule, ArkQQAPIIPCModule.IPCMethod paramIPCMethod) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$IPCMethod.a() + " result=" + paramEIPCResult);
    }
    ArkQQAPIIPCModule.IPCMethod localIPCMethod = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$IPCMethod;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localIPCMethod.a(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.3
 * JD-Core Version:    0.7.0.1
 */