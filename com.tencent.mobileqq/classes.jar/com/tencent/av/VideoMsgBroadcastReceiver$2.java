package com.tencent.av;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class VideoMsgBroadcastReceiver$2
  implements Runnable
{
  VideoMsgBroadcastReceiver$2(VideoMsgBroadcastReceiver paramVideoMsgBroadcastReceiver, Bundle paramBundle) {}
  
  public void run()
  {
    VideoController localVideoController = VideoController.a();
    if (localVideoController != null) {
      localVideoController.a.receiveSharpVideoOfflineMsg(this.a);
    }
    QLog.i("VideoMsgBroadcastReceiver", 1, "processSharpVideoOfflineMsg, data[" + this.a + "], async");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver.2
 * JD-Core Version:    0.7.0.1
 */