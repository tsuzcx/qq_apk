package com.tencent.biz.videostory.capture;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import mqq.os.MqqHandler;
import wuh;
import wun;

public class VideoStoryCapturePart$6$1
  implements Runnable
{
  public VideoStoryCapturePart$6$1(wun paramwun) {}
  
  public void run()
  {
    wuh.a(this.a.a).setOnFrameDraw(null);
    ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.6.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryCapturePart.6.1
 * JD-Core Version:    0.7.0.1
 */