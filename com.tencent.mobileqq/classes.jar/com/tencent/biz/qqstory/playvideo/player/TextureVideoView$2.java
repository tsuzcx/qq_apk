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
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer == null) {
      return;
    }
    TextureVideoView localTextureVideoView = this.a;
    localTextureVideoView.jdField_a_of_type_Int = 2;
    localTextureVideoView.jdField_d_of_type_Boolean = true;
    localTextureVideoView.c = true;
    localTextureVideoView.jdField_b_of_type_Boolean = true;
    if (localTextureVideoView.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnPreparedListener.a_(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer);
    }
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
    }
    this.a.jdField_d_of_type_Int = paramIMediaPlayer.c();
    this.a.e = paramIMediaPlayer.d();
    int i = this.a.g;
    if (i != 0) {
      this.a.seekTo(i);
    }
    if ((this.a.jdField_d_of_type_Int != 0) && (this.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.jdField_d_of_type_Int, this.a.e);
      }
      if (this.a.jdField_b_of_type_Int == 3)
      {
        this.a.start();
        if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
          this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        }
      }
      else if ((!this.a.isPlaying()) && ((i != 0) || (this.a.getCurrentPosition() > 0)) && (this.a.jdField_a_of_type_AndroidWidgetMediaController != null))
      {
        this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      }
    }
    else if (this.a.jdField_b_of_type_Int == 3)
    {
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.2
 * JD-Core Version:    0.7.0.1
 */