package com.tencent.av;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class VideoMsgBroadcastReceiver$2
  implements Runnable
{
  VideoMsgBroadcastReceiver$2(VideoMsgBroadcastReceiver paramVideoMsgBroadcastReceiver, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = VideoController.f();
    if (localObject != null) {
      ((VideoController)localObject).n.receiveSharpVideoOfflineMsg(this.a);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processSharpVideoOfflineMsg, data[");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("], async");
    QLog.i("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver.2
 * JD-Core Version:    0.7.0.1
 */