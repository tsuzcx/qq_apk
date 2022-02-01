package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoController$21
  implements Runnable
{
  VideoController$21(VideoController paramVideoController, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv() != 0)
    {
      if (this.this$0.a().c.size() == 0) {
        this.this$0.a().a(this.a, "StopGVideo", false, true);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.21
 * JD-Core Version:    0.7.0.1
 */