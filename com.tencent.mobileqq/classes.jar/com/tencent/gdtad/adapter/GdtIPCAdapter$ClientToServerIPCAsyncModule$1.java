package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.gdtad.log.GdtLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class GdtIPCAdapter$ClientToServerIPCAsyncModule$1
  implements EIPCResultCallback
{
  GdtIPCAdapter$ClientToServerIPCAsyncModule$1(GdtIPCAdapter.ClientToServerIPCAsyncModule paramClientToServerIPCAsyncModule, AdIPCManager.Params paramParams, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject = this.a;
    String str = null;
    if (localObject != null) {
      localObject = ((AdIPCManager.Params)localObject).getAction();
    } else {
      localObject = null;
    }
    boolean bool = false;
    AdIPCManager.Params localParams = this.a;
    if (localParams != null) {
      str = localParams.getToProcessName();
    }
    if (paramEIPCResult != null) {
      bool = paramEIPCResult.isSuccess();
    }
    GdtLog.b("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCallback action:%s to:%s success:%b", new Object[] { localObject, str, Boolean.valueOf(bool) }));
    this.c.callbackResult(this.b, paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCAsyncModule.1
 * JD-Core Version:    0.7.0.1
 */