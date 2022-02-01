package com.tencent.biz.qqstory.playvideo.player;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class TextureVideoView$5
  implements IMediaPlayer.OnErrorListener
{
  TextureVideoView$5(TextureVideoView paramTextureVideoView) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.a;
    ((TextureVideoView)localObject).f = -1;
    ((TextureVideoView)localObject).g = -1;
    if (((TextureVideoView)localObject).m != null) {
      this.a.m.hide();
    }
    if ((this.a.r != null) && (this.a.r.a(paramIMediaPlayer, paramInt1, paramInt2))) {
      return true;
    }
    if (this.a.getWindowToken() != null)
    {
      this.a.getContext().getResources();
      if (paramInt1 == 200) {
        paramInt1 = 17039381;
      } else {
        paramInt1 = 17039377;
      }
      paramIMediaPlayer = TextureVideoView.a(this.a);
      if (paramIMediaPlayer != null) {
        new AlertDialog.Builder(paramIMediaPlayer).setMessage(paramInt1).setPositiveButton(17039376, new TextureVideoView.5.1(this)).setCancelable(false).show();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.5
 * JD-Core Version:    0.7.0.1
 */