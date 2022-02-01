package com.tencent.imsdk.v2;

class V2TIMManagerImpl$7
  implements V2TIMSendCallback<V2TIMMessage>
{
  V2TIMManagerImpl$7(V2TIMManagerImpl paramV2TIMManagerImpl, V2TIMValueCallback paramV2TIMValueCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  public void onProgress(int paramInt) {}
  
  public void onSuccess(V2TIMMessage paramV2TIMMessage)
  {
    V2TIMValueCallback localV2TIMValueCallback = this.val$callback;
    if (localV2TIMValueCallback != null) {
      localV2TIMValueCallback.onSuccess(paramV2TIMMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */