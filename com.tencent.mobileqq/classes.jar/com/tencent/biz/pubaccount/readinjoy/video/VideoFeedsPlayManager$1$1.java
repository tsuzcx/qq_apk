package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsPlayManager$1$1
  implements Runnable
{
  VideoFeedsPlayManager$1$1(VideoFeedsPlayManager.1 param1) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.a.a) != null) && (VideoFeedsPlayManager.a(this.a.a).a != null)) {
      VideoFeedsPlayManager.a(this.a.a).a.i(VideoFeedsPlayManager.a(this.a.a));
    }
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).b(VideoFeedsPlayManager.a(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */