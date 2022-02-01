package com.tencent.imsdk.v2;

class V2TIMManagerImpl$2
  implements V2TIMCallback
{
  V2TIMManagerImpl$2(V2TIMManagerImpl paramV2TIMManagerImpl, V2TIMCallback paramV2TIMCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMCallback localV2TIMCallback = this.val$callback;
    if (localV2TIMCallback != null) {
      localV2TIMCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    V2TIMCallback localV2TIMCallback = this.val$callback;
    if (localV2TIMCallback != null) {
      localV2TIMCallback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */