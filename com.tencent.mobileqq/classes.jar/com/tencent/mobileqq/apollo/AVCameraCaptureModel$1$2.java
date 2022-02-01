package com.tencent.mobileqq.apollo;

import com.tencent.TMG.sdk.AVVideoCtrl.RemoteVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class AVCameraCaptureModel$1$2
  extends AVVideoCtrl.RemoteVideoPreviewCallback
{
  AVCameraCaptureModel$1$2(AVCameraCaptureModel.1 param1) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = CmGameUtil.a(AVCameraCaptureModel.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.2.1(this, paramVideoFrame, (ApolloSurfaceView)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2
 * JD-Core Version:    0.7.0.1
 */