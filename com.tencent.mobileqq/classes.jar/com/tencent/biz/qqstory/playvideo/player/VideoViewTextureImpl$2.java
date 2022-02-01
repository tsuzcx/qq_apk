package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;

class VideoViewTextureImpl$2
  implements IMediaPlayer.OnErrorListener
{
  VideoViewTextureImpl$2(VideoViewTextureImpl paramVideoViewTextureImpl, IVideoView.OnErrorListener paramOnErrorListener, Object paramObject) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    paramIMediaPlayer = this.a;
    VideoViewTextureImpl localVideoViewTextureImpl = this.c;
    return paramIMediaPlayer.a(localVideoViewTextureImpl, 0, paramInt1, localVideoViewTextureImpl.b.getCurrentPosition(), String.valueOf(paramInt2), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl.2
 * JD-Core Version:    0.7.0.1
 */