package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class TrimTextureVideoView$3
  implements IMediaPlayer.OnErrorListener
{
  TrimTextureVideoView$3(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramIMediaPlayer = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TrimTextureVideoView MediaPlayer onError==>what:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|extra:");
      localStringBuilder.append(paramInt2);
      QLog.e(paramIMediaPlayer, 2, localStringBuilder.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.3
 * JD-Core Version:    0.7.0.1
 */