package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import qhw;

public class VideoPlayerWrapper$3
  implements Runnable
{
  public VideoPlayerWrapper$3(qhw paramqhw, boolean paramBoolean) {}
  
  public void run()
  {
    if ((qhw.a(this.this$0) != null) && (qhw.a(this.this$0).get() != 6) && (qhw.a(this.this$0).get() != 8)) {
      qhw.a(this.this$0).setLoopback(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */