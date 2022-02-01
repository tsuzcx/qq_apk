package com.tencent.av;

import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

class VideoController$12
  extends VideoController.OnCustomCompletionListener
{
  VideoController$12(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.c != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvVideoController.c);
      this.jdField_a_of_type_ComTencentAvVideoController.c = null;
    }
    AVLog.printAllUserLog(VideoController.jdField_a_of_type_JavaLangString, "onCompletion onCloseDoubleVideoMeeting");
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, l, 85);
      this.jdField_a_of_type_ComTencentAvVideoController.a().d("OnCloseDoubleVideoMeetingListener", false);
      this.jdField_a_of_type_ComTencentAvVideoController.a().e("OnCloseDoubleVideoMeetingListener", false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      return;
      AVLog.printErrorLog(VideoController.jdField_a_of_type_JavaLangString, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.12
 * JD-Core Version:    0.7.0.1
 */