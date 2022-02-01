package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.HandlerThread;
import com.gyailib.library.GYAISceneChain;

class VideoFilterViewPager$1
  implements Runnable
{
  VideoFilterViewPager$1(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void run()
  {
    if (VideoFilterViewPager.a(this.this$0) != null)
    {
      VideoFilterViewPager.a(this.this$0).cleanupModelData();
      VideoFilterViewPager.a(this.this$0, null);
    }
    VideoFilterViewPager.b(this.this$0).quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.1
 * JD-Core Version:    0.7.0.1
 */