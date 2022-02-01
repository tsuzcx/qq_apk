package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ipc.IPCMethodCallback;
import eipc.EIPCResult;

class ArkQQAPIIPCModule$GetPSKeyAsyncHandler$1
  implements ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler
{
  ArkQQAPIIPCModule$GetPSKeyAsyncHandler$1(ArkQQAPIIPCModule.GetPSKeyAsyncHandler paramGetPSKeyAsyncHandler, IPCMethodCallback paramIPCMethodCallback) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("pskey", paramString);
    }
    paramString = EIPCResult.createResult(0, localBundle);
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetPSKeyAsyncHandler.1
 * JD-Core Version:    0.7.0.1
 */