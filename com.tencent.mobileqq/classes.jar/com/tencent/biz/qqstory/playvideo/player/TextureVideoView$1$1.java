package com.tencent.biz.qqstory.playvideo.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;

class TextureVideoView$1$1
  implements Runnable
{
  TextureVideoView$1$1(TextureVideoView.1 param1, IMediaPlayer paramIMediaPlayer) {}
  
  public void run()
  {
    this.b.a.k = this.a.l();
    this.b.a.l = this.a.m();
    if ((this.b.a.k != 0) && (this.b.a.l != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.b.a.getSurfaceTexture().setDefaultBufferSize(this.b.a.k, this.b.a.l);
      }
      this.b.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */