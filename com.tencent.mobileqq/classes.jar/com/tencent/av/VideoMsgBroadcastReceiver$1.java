package com.tencent.av;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class VideoMsgBroadcastReceiver$1
  implements Runnable
{
  VideoMsgBroadcastReceiver$1(VideoMsgBroadcastReceiver paramVideoMsgBroadcastReceiver, VideoController paramVideoController, Bundle paramBundle) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a.receiveMultiVideoOfflineMsg(this.jdField_a_of_type_AndroidOsBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg, async");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */