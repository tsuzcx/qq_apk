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
    this.a.jdField_a_of_type_Int = 5;
    this.a.b = 5;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnCompletionListener.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.3
 * JD-Core Version:    0.7.0.1
 */