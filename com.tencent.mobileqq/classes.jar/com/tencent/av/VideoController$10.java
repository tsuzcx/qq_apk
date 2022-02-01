package com.tencent.av;

import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class VideoController$10
  extends VideoController.OnCustomCompletionListener
{
  VideoController$10(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(VideoController.jdField_a_of_type_JavaLangString, 1, "onCompletion, onClose, mainSession[" + localSessionInfo + "], seq[" + this.jdField_a_of_type_Long + "], timeOutTask[" + VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController) + "]");
    if (VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController) != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController));
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, null);
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!localSessionInfo.p())
    {
      AVLog.printAllUserLog(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onClose is not Closing2");
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.d, 217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.d, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.10
 * JD-Core Version:    0.7.0.1
 */