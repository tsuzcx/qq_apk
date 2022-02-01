package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$8
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  VideoViewTVKImpl$8(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.8.1(this, paramTVK_IMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.8
 * JD-Core Version:    0.7.0.1
 */