package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

class VideoViewTVKImpl$8$1
  implements Runnable
{
  VideoViewTVKImpl$8$1(VideoViewTVKImpl.8 param8, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    if (this.b.a.q != null) {
      this.b.a.q.onSeekComplete(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.8.1
 * JD-Core Version:    0.7.0.1
 */