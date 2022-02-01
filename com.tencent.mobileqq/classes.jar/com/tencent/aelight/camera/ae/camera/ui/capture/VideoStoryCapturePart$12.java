package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.ExtractFrameRequest;
import com.tencent.mobileqq.app.ThreadManager;

class VideoStoryCapturePart$12
  implements AECameraGLSurfaceView.ExtractFrameRequest
{
  VideoStoryCapturePart$12(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void onExtract(Bitmap paramBitmap)
  {
    ThreadManager.excute(new VideoStoryCapturePart.12.1(this, paramBitmap), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.12
 * JD-Core Version:    0.7.0.1
 */