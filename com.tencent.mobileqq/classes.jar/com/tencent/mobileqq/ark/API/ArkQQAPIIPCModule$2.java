package com.tencent.mobileqq.ark.API;

import eipc.EIPCResult;

class ArkQQAPIIPCModule$2
  implements ArkQQAPIIPCModule.IPCMethodCallback
{
  ArkQQAPIIPCModule$2(ArkQQAPIIPCModule paramArkQQAPIIPCModule, ArkQQAPIIPCModule.IPCMethod paramIPCMethod) {}
  
  public void a(EIPCResult paramEIPCResult)
  {
    ArkQQAPIIPCModule.IPCMethod localIPCMethod = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkQQAPIIPCModule$IPCMethod;
    if (paramEIPCResult.code == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localIPCMethod.a(bool, paramEIPCResult.data);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.2
 * JD-Core Version:    0.7.0.1
 */