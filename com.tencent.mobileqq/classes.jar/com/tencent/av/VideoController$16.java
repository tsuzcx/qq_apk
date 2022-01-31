package com.tencent.av;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lga;

class VideoController$16
  implements Runnable
{
  VideoController$16(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.this$0.a().g), Boolean.valueOf(true) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoController.16
 * JD-Core Version:    0.7.0.1
 */