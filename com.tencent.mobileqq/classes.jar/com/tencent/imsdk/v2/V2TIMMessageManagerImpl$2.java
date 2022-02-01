package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.message.MessageUploadProgressCallback;

class V2TIMMessageManagerImpl$2
  extends MessageUploadProgressCallback
{
  V2TIMMessageManagerImpl$2(V2TIMMessageManagerImpl paramV2TIMMessageManagerImpl, V2TIMSendCallback paramV2TIMSendCallback) {}
  
  public void onUploadProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    IMContext.getInstance().runOnMainThread(new V2TIMMessageManagerImpl.2.1(this, paramInt3, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */