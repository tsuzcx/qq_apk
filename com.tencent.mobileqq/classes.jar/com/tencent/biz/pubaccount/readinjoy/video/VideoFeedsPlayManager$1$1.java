package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import qyz;
import rfo;
import rfs;
import rfu;

public class VideoFeedsPlayManager$1$1
  implements Runnable
{
  public VideoFeedsPlayManager$1$1(rfo paramrfo) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.a.a) != null) && (VideoFeedsPlayManager.b(this.a.a).a != null)) {
      VideoFeedsPlayManager.b(this.a.a).a.j(VideoFeedsPlayManager.b(this.a.a));
    }
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((rfu)localIterator.next()).c(VideoFeedsPlayManager.b(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */