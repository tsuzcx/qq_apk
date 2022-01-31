package com.tencent.mobileqq.apollo.process.video;

import ajef;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class CmGameTxVideoPlayer$4
  implements Runnable
{
  public CmGameTxVideoPlayer$4(ajef paramajef) {}
  
  public void run()
  {
    if (ajef.a(this.this$0) != null)
    {
      ajef.a(this.this$0).stop();
      ajef.a(this.this$0).release();
      ajef.a(this.this$0, null);
      ajef.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */