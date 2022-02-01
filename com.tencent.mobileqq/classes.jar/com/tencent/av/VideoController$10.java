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
    String str = VideoController.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompletion, onClose, mainSession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], timeOutTask[");
    localStringBuilder.append(VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController) != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController));
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, null);
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!localSessionInfo.n())
    {
      AVLog.printAllUserLog(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onClose is not Closing2");
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.c, 217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(217);
    this.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.c, this.jdField_a_of_type_ComTencentAvVideoController.a().z);
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.10
 * JD-Core Version:    0.7.0.1
 */