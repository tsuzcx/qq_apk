package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import rlr;
import rrj;
import rrm;
import rro;

public class VideoFeedsPlayManager$1$1
  implements Runnable
{
  public VideoFeedsPlayManager$1$1(rrj paramrrj) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.a.a) != null) && (VideoFeedsPlayManager.a(this.a.a).a != null)) {
      VideoFeedsPlayManager.a(this.a.a).a.i(VideoFeedsPlayManager.a(this.a.a));
    }
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((rro)localIterator.next()).c(VideoFeedsPlayManager.a(this.a.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.1.1
 * JD-Core Version:    0.7.0.1
 */