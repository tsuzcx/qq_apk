package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;

class VideoFilterViewPager$3
  implements Runnable
{
  VideoFilterViewPager$3(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void run()
  {
    Bitmap localBitmap = VideoFilterTools.a().j();
    if (localBitmap == null)
    {
      AEQLog.d("VideoFilterViewPager", "bitmap is null.");
      return;
    }
    if (VideoFilterViewPager.c(this.this$0) == null) {
      VideoFilterViewPager.a(this.this$0, localBitmap.getWidth(), localBitmap.getHeight());
    }
    if (TextUtils.isEmpty(VideoFilterViewPager.e(this.this$0)))
    {
      localObject = this.this$0;
      VideoFilterViewPager.a((VideoFilterViewPager)localObject, VideoFilterViewPager.f((VideoFilterViewPager)localObject), localBitmap);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("aio photo ai label saved: ");
    ((StringBuilder)localObject).append(VideoFilterViewPager.e(this.this$0));
    ((StringBuilder)localObject).append(" isPreload: ");
    ((StringBuilder)localObject).append(VideoFilterViewPager.f(this.this$0));
    AEQLog.b("VideoFilterViewPager", ((StringBuilder)localObject).toString());
    if (!VideoFilterViewPager.f(this.this$0))
    {
      VideoFilterViewPager.g(this.this$0);
      VideoFilterViewPager.a(this.this$0, localBitmap);
      localObject = VideoFilterViewPager.b(this.this$0, localBitmap);
      if ((localObject != null) && (!((String)localObject).equals(VideoFilterViewPager.e(this.this$0)))) {
        VideoFilterViewPager.a(this.this$0, false, localBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.3
 * JD-Core Version:    0.7.0.1
 */