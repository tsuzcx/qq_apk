package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ArkIPCService$3
  implements EIPCResultCallback
{
  ArkIPCService$3(ArkIPCService paramArkIPCService, IPCMethod paramIPCMethod) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool;
    if (paramEIPCResult.code == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call.async, method=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArkIpcIPCMethod.a());
      ((StringBuilder)localObject).append(" result=");
      ((StringBuilder)localObject).append(paramEIPCResult);
      QLog.i("ArkApp.ArkIPCService", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkIpcIPCMethod;
    if (paramEIPCResult.data != null) {
      paramEIPCResult = paramEIPCResult.data;
    } else {
      paramEIPCResult = new Bundle();
    }
    ((IPCMethod)localObject).a(bool, paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkIPCService.3
 * JD-Core Version:    0.7.0.1
 */