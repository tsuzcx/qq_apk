package com.tencent.ark.open.internal;

import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;
import java.nio.charset.StandardCharsets;

class ArkAppCGIMgr$3
  implements IArkDelegateHTTPCallback
{
  ArkAppCGIMgr$3(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.IQueryAppInfoRequestCallback paramIQueryAppInfoRequestCallback) {}
  
  public void onComplete(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.val$callback.onResult(new String(paramArrayOfByte, StandardCharsets.UTF_8));
      return;
    }
    this.val$callback.onResult(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.3
 * JD-Core Version:    0.7.0.1
 */