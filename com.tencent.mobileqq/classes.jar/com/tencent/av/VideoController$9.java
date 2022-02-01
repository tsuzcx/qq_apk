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
    String str = VideoController.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompletion, request, mainSession[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().m())
    {
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a("OnCompletionListener", 6);
    paramMediaPlayer = this.jdField_a_of_type_ComTencentAvVideoController;
    long l = this.jdField_a_of_type_Long;
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 2L) {
      i = 4;
    } else {
      i = 1;
    }
    paramMediaPlayer.a(l, 2131230745, i, VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().z), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.9
 * JD-Core Version:    0.7.0.1
 */