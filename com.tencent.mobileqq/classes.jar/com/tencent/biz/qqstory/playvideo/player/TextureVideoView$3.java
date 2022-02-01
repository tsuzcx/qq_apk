package com.tencent.biz.qqstory.playvideo.player;

import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnCompletionListener;

class TextureVideoView$3
  implements IMediaPlayer.OnCompletionListener
{
  TextureVideoView$3(TextureVideoView paramTextureVideoView) {}
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    paramIMediaPlayer = this.a;
    paramIMediaPlayer.f = 5;
    paramIMediaPlayer.g = 5;
    if (paramIMediaPlayer.m != null) {
      this.a.m.hide();
    }
    if (this.a.n != null) {
      this.a.n.a(this.a.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.3
 * JD-Core Version:    0.7.0.1
 */