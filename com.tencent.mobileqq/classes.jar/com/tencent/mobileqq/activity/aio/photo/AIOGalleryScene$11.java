package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AIOGalleryScene$11
  implements EIPCResultCallback
{
  AIOGalleryScene$11(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      AIOGalleryScene.w(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.11
 * JD-Core Version:    0.7.0.1
 */