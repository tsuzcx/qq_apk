package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnPreparedListener;

class TextureVideoView$2
  implements IMediaPlayer.OnPreparedListener
{
  TextureVideoView$2(TextureVideoView paramTextureVideoView) {}
  
  @TargetApi(15)
  public void a_(IMediaPlayer paramIMediaPlayer)
  {
    if (this.a.i == null) {
      return;
    }
    TextureVideoView localTextureVideoView = this.a;
    localTextureVideoView.f = 2;
    localTextureVideoView.w = true;
    localTextureVideoView.v = true;
    localTextureVideoView.u = true;
    if (localTextureVideoView.o != null) {
      this.a.o.a_(this.a.i);
    }
    if (this.a.m != null) {
      this.a.m.setEnabled(true);
    }
    this.a.k = paramIMediaPlayer.l();
    this.a.l = paramIMediaPlayer.m();
    int i = this.a.t;
    if (i != 0) {
      this.a.seekTo(i);
    }
    if ((this.a.k != 0) && (this.a.l != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.k, this.a.l);
      }
      if (this.a.g == 3)
      {
        this.a.start();
        if (this.a.m != null) {
          this.a.m.show();
        }
      }
      else if ((!this.a.isPlaying()) && ((i != 0) || (this.a.getCurrentPosition() > 0)) && (this.a.m != null))
      {
        this.a.m.show(0);
      }
    }
    else if (this.a.g == 3)
    {
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.2
 * JD-Core Version:    0.7.0.1
 */