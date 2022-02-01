package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.DownloadProgressInfo;

class V2TIMImageElem$V2TIMImage$1
  implements V2TIMValueCallback<DownloadProgressInfo>
{
  V2TIMImageElem$V2TIMImage$1(V2TIMImageElem.V2TIMImage paramV2TIMImage, V2TIMDownloadCallback paramV2TIMDownloadCallback) {}
  
  public void onError(int paramInt, String paramString)
  {
    V2TIMDownloadCallback localV2TIMDownloadCallback = this.val$v2TIMDownloadCallback;
    if (localV2TIMDownloadCallback != null) {
      localV2TIMDownloadCallback.onError(paramInt, paramString);
    }
  }
  
  public void onSuccess(DownloadProgressInfo paramDownloadProgressInfo)
  {
    paramDownloadProgressInfo = new V2TIMElem.V2ProgressInfo(this.this$1.this$0, paramDownloadProgressInfo.getCurrentSize(), paramDownloadProgressInfo.getTotalSize());
    V2TIMDownloadCallback localV2TIMDownloadCallback = this.val$v2TIMDownloadCallback;
    if (localV2TIMDownloadCallback != null) {
      localV2TIMDownloadCallback.onProgress(paramDownloadProgressInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.1
 * JD-Core Version:    0.7.0.1
 */