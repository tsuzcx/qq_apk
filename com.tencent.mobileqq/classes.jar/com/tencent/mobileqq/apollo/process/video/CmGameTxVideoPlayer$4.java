package com.tencent.mobileqq.apollo.process.video;

import akvr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class CmGameTxVideoPlayer$4
  implements Runnable
{
  public CmGameTxVideoPlayer$4(akvr paramakvr) {}
  
  public void run()
  {
    if (akvr.a(this.this$0) != null)
    {
      akvr.a(this.this$0).stop();
      akvr.a(this.this$0).release();
      akvr.a(this.this$0, null);
      akvr.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */