package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;
import eipc.EIPCResult;

class ArkIPCService$2
  implements IPCMethodCallback
{
  ArkIPCService$2(ArkIPCService paramArkIPCService, IPCMethod paramIPCMethod) {}
  
  public void a(EIPCResult paramEIPCResult)
  {
    IPCMethod localIPCMethod = this.a;
    boolean bool;
    if (paramEIPCResult.code == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localIPCMethod.a(bool, paramEIPCResult.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkIPCService.2
 * JD-Core Version:    0.7.0.1
 */