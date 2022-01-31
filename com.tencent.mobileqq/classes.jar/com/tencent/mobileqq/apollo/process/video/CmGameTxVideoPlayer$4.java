package com.tencent.mobileqq.apollo.process.video;

import alag;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class CmGameTxVideoPlayer$4
  implements Runnable
{
  public CmGameTxVideoPlayer$4(alag paramalag) {}
  
  public void run()
  {
    if (alag.a(this.this$0) != null)
    {
      alag.a(this.this$0).stop();
      alag.a(this.this$0).release();
      alag.a(this.this$0, null);
      alag.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */