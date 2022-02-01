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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Error: " + paramInt1 + "," + paramInt2);
    }
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(paramIMediaPlayer, paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    this.a.getContext().getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = 17039381;; paramInt1 = 17039377)
    {
      paramIMediaPlayer = TextureVideoView.a(this.a);
      if (paramIMediaPlayer == null) {
        break;
      }
      new AlertDialog.Builder(paramIMediaPlayer).setMessage(paramInt1).setPositiveButton(17039376, new TextureVideoView.5.1(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.TextureVideoView.5
 * JD-Core Version:    0.7.0.1
 */