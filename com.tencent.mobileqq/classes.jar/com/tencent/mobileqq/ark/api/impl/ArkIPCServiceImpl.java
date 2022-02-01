package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.core.ArkIPCService;
import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.mobileqq.qipc.QIPCModule;

public class ArkIPCServiceImpl
  implements IArkIPCService
{
  public void call(IPCMethod paramIPCMethod)
  {
    ArkIPCService.a().a(paramIPCMethod);
  }
  
  public QIPCModule getModule()
  {
    return ArkIPCService.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkIPCServiceImpl
 * JD-Core Version:    0.7.0.1
 */