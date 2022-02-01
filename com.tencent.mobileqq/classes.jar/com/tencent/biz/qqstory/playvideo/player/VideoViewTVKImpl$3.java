package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$3
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoViewTVKImpl$3(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.3.1(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.3
 * JD-Core Version:    0.7.0.1
 */