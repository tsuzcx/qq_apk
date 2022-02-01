package com.tencent.mobileqq.apollo;

import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class AVCameraCaptureModel$1$1
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  AVCameraCaptureModel$1$1(AVCameraCaptureModel.1 param1) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = CmGameUtil.a(AVCameraCaptureModel.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1
 * JD-Core Version:    0.7.0.1
 */