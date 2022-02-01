package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoViewTextureImpl$4
  implements IMediaPlayer.OnPreparedListener
{
  VideoViewTextureImpl$4(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnPreparedListener paramOnPreparedListener) {}
  
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTextureImpl.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl.4
 * JD-Core Version:    0.7.0.1
 */