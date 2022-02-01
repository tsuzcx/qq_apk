package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$2
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoViewTVKImpl$2(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoViewTVKImpl.a(this.a).d = paramTVK_IMediaPlayer.getDuration();
    VideoViewTVKImpl.a(this.a).e = paramTVK_IMediaPlayer.getCurrentPostion();
    paramTVK_IMediaPlayer = this.a.a;
    if (paramTVK_IMediaPlayer != null) {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.2.1(this, paramTVK_IMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.2
 * JD-Core Version:    0.7.0.1
 */