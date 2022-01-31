package com.tencent.biz.videostory.capture;

import android.app.Activity;
import android.util.Log;
import wuh;
import wul;

public class VideoStoryCapturePart$12$2
  implements Runnable
{
  public VideoStoryCapturePart$12$2(wul paramwul) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (!this.a.a.a.isFinishing()))
    {
      Log.d("Q.videostory.capture", "failed");
      wuh.a(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryCapturePart.12.2
 * JD-Core Version:    0.7.0.1
 */