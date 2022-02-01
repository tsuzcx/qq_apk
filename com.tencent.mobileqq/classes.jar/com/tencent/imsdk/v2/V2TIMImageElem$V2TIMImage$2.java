package com.tencent.imsdk.v2;

class V2TIMImageElem$V2TIMImage$2
  implements V2TIMCallback
{
  V2TIMImageElem$V2TIMImage$2(V2TIMImageElem.V2TIMImage paramV2TIMImage, V2TIMDownloadCallback paramV2TIMDownloadCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMDownloadCallback localV2TIMDownloadCallback = this.val$v2TIMDownloadCallback;
    if (localV2TIMDownloadCallback != null) {
      localV2TIMDownloadCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    V2TIMDownloadCallback localV2TIMDownloadCallback = this.val$v2TIMDownloadCallback;
    if (localV2TIMDownloadCallback != null) {
      localV2TIMDownloadCallback.onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.2
 * JD-Core Version:    0.7.0.1
 */