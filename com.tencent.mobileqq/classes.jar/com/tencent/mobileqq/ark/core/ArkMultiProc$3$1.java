package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;
import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;

class ArkMultiProc$3$1
  implements IHTTPDownloadCallback
{
  ArkMultiProc$3$1(ArkMultiProc.3 param3, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    IArkDelegateHTTPCallback localIArkDelegateHTTPCallback = this.a;
    if (localIArkDelegateHTTPCallback != null) {
      localIArkDelegateHTTPCallback.onComplete(paramInt, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.3.1
 * JD-Core Version:    0.7.0.1
 */