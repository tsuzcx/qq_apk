package com.tencent.mobileqq.apollo.process.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class CmGameTxVideoPlayer$4
  implements Runnable
{
  CmGameTxVideoPlayer$4(CmGameTxVideoPlayer paramCmGameTxVideoPlayer) {}
  
  public void run()
  {
    if (CmGameTxVideoPlayer.a(this.this$0) != null)
    {
      CmGameTxVideoPlayer.a(this.this$0).stop();
      CmGameTxVideoPlayer.a(this.this$0).release();
      CmGameTxVideoPlayer.a(this.this$0, null);
      CmGameTxVideoPlayer.a(this.this$0, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */