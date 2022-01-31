package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import qjs;
import qqh;
import qql;
import qqn;

public class VideoFeedsPlayManager$1$1
  implements Runnable
{
  public VideoFeedsPlayManager$1$1(qqh paramqqh) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.a.a) != null) && (VideoFeedsPlayManager.b(this.a.a).a != null)) {
      VideoFeedsPlayManager.b(this.a.a).a.j(VideoFeedsPlayManager.b(this.a.a));
    }
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((qqn)localIterator.next()).c(VideoFeedsPlayManager.b(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */