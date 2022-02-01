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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.d = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.c();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.e = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer.d();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.d != 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.e != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.getSurfaceTexture().setDefaultBufferSize(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.d, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.e);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView$1.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
 * JD-Core Version:    0.7.0.1
 */