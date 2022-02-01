package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkIPCService
  extends QRouteApi
{
  public static final String NAME = "ArkQQAPIIPCModule";
  
  public abstract void call(IPCMethod paramIPCMethod);
  
  public abstract QIPCModule getModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkIPCService
 * JD-Core Version:    0.7.0.1
 */