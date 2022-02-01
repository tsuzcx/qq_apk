package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnVideoSizeChangedListener;

class TextureVideoView$1
  implements IMediaPlayer.OnVideoSizeChangedListener
{
  TextureVideoView$1(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.a.getHandler() == null) {
      return;
    }
    this.a.getHandler().post(new TextureVideoView.1.1(this, paramIMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1
 * JD-Core Version:    0.7.0.1
 */