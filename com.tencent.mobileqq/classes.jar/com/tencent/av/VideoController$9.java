package com.tencent.av;

import android.media.MediaPlayer;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class VideoController$9
  extends VideoController.OnCustomCompletionListener
{
  VideoController$9(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.w(VideoController.jdField_a_of_type_JavaLangString, 1, "onCompletion, request, mainSession[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().o())
    {
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a("OnCompletionListener", 6);
    paramMediaPlayer = this.jdField_a_of_type_ComTencentAvVideoController;
    long l = this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 2L) {}
    for (int i = 4;; i = 1)
    {
      paramMediaPlayer.a(l, 2131230741, i, VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().z), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
      this.jdField_a_of_type_Long = 0L;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.9
 * JD-Core Version:    0.7.0.1
 */