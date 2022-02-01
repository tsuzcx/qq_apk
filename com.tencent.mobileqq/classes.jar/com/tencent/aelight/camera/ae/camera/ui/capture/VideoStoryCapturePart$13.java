package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest;
import com.tencent.mobileqq.app.ThreadManager;

class VideoStoryCapturePart$13
  implements AECameraGLSurfaceView.ExtractFrameRequest
{
  VideoStoryCapturePart$13(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void onExtract(Bitmap paramBitmap)
  {
    ThreadManager.excute(new VideoStoryCapturePart.13.1(this, paramBitmap), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.13
 * JD-Core Version:    0.7.0.1
 */