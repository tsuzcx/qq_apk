package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;

class VideoFilterViewPager$2
  implements Runnable
{
  VideoFilterViewPager$2(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void run()
  {
    Bitmap localBitmap = VideoFilterTools.a().a();
    if (localBitmap == null)
    {
      AEQLog.d("VideoFilterViewPager", "bitmap is null.");
      return;
    }
    if (VideoFilterViewPager.a(this.this$0) == null) {
      VideoFilterViewPager.a(this.this$0, localBitmap.getWidth(), localBitmap.getHeight());
    }
    if (TextUtils.isEmpty(VideoFilterViewPager.a(this.this$0)))
    {
      localObject = this.this$0;
      VideoFilterViewPager.a((VideoFilterViewPager)localObject, VideoFilterViewPager.a((VideoFilterViewPager)localObject), localBitmap);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("aio photo ai label saved: ");
    ((StringBuilder)localObject).append(VideoFilterViewPager.a(this.this$0));
    ((StringBuilder)localObject).append(" isPreload: ");
    ((StringBuilder)localObject).append(VideoFilterViewPager.a(this.this$0));
    AEQLog.b("VideoFilterViewPager", ((StringBuilder)localObject).toString());
    if (!VideoFilterViewPager.a(this.this$0))
    {
      VideoFilterViewPager.a(this.this$0);
      VideoFilterViewPager.a(this.this$0, localBitmap);
      localObject = VideoFilterViewPager.b(localBitmap);
      if ((localObject != null) && (!((String)localObject).equals(VideoFilterViewPager.a(this.this$0)))) {
        VideoFilterViewPager.a(this.this$0, false, localBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.2
 * JD-Core Version:    0.7.0.1
 */