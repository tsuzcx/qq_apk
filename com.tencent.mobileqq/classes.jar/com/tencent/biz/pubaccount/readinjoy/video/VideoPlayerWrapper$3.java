package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import qty;

public class VideoPlayerWrapper$3
  implements Runnable
{
  public VideoPlayerWrapper$3(qty paramqty, boolean paramBoolean) {}
  
  public void run()
  {
    if ((qty.a(this.this$0) != null) && (qty.a(this.this$0).get() != 6) && (qty.a(this.this$0).get() != 8)) {
      qty.a(this.this$0).setLoopback(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */