package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;

class ArkAppSSOIPCHandler$1
  implements BusinessObserver
{
  ArkAppSSOIPCHandler$1(ArkAppSSOIPCHandler paramArkAppSSOIPCHandler, Bundle paramBundle, String paramString, IPCMethodCallback paramIPCMethodCallback) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ArkAppSSOIPCHandler.a(paramInt, paramBoolean, (String)paramObject, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppSSOIPCHandler.1
 * JD-Core Version:    0.7.0.1
 */