package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;

class VideoFilterViewPager$5$1
  implements Runnable
{
  VideoFilterViewPager$5$1(VideoFilterViewPager.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (VideoFilterTools.a().i() == null) {
      return;
    }
    VideoFilterTools.a().i().a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.5.1
 * JD-Core Version:    0.7.0.1
 */