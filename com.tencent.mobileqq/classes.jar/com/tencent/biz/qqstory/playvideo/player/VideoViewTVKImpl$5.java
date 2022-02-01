package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$5
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoViewTVKImpl$5(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.executeOnSubThread(new VideoViewTVKImpl.5.1(this, paramTVK_IMediaPlayer));
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5
 * JD-Core Version:    0.7.0.1
 */