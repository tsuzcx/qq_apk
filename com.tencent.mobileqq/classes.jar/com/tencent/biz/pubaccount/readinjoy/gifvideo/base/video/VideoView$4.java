package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

class VideoView$4
  implements Runnable
{
  VideoView$4(VideoView paramVideoView, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      VideoView.a(this.this$0, TVK_SDKMgr.getProxyFactory());
      if (VideoView.a(this.this$0) != null)
      {
        VideoView.a(this.this$0, VideoView.a(this.this$0));
        VideoView.a(this.this$0, VideoView.a(this.this$0).createMediaPlayer(VideoView.a(this.this$0), VideoView.b(this.this$0)));
        if (VideoView.a(this.this$0) != null)
        {
          VideoView.a(this.this$0).updatePlayerVideoView(VideoView.b(this.this$0));
          VideoView.a(this.this$0, false);
          VideoView.d(this.this$0);
          this.a.run();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */