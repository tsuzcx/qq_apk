package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;

class VideoViewTVKImpl$7
  implements TVK_IMediaPlayer.OnVideoOutputFrameListener
{
  VideoViewTVKImpl$7(VideoViewTVKImpl paramVideoViewTVKImpl) {}
  
  public void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SLog.a(this.a.a, "OnVideoOutputFrame width=%d height=%d rotation=%d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.7
 * JD-Core Version:    0.7.0.1
 */