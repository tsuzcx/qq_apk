package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;

class VideoPlayManager$4
  implements Runnable
{
  VideoPlayManager$4(VideoPlayManager paramVideoPlayManager) {}
  
  public void run()
  {
    VideoPlayManager.a(this.this$0, VideoPlayManager.a(this.this$0), VideoPlayManager.a(this.this$0), 7, null);
    if (VideoPlayManager.a(this.this$0) != null)
    {
      Iterator localIterator = VideoPlayManager.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        VideoPlayManager.VideoStatusListener localVideoStatusListener = (VideoPlayManager.VideoStatusListener)localIterator.next();
        if (localVideoStatusListener != null) {
          localVideoStatusListener.a(VideoPlayManager.a(this.this$0), VideoPlayManager.a(this.this$0).a());
        }
      }
    }
    if (VideoPlayManager.a(this.this$0) != null)
    {
      VideoPlayManager.a(this.this$0).e = -1;
      VideoPlayManager.a(this.this$0).d = 0L;
      VideoPlayManager.a(this.this$0, null);
    }
    if (VideoPlayManager.a(this.this$0) != null)
    {
      VideoPlayManager.a(this.this$0).l();
      VideoPlayManager.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.4
 * JD-Core Version:    0.7.0.1
 */