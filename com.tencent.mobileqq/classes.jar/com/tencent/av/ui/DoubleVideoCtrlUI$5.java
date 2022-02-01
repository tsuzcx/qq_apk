package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$5
  implements Runnable
{
  DoubleVideoCtrlUI$5(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = this.this$0.am.k();
    String str = this.this$0.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckRemoteCameraRunnable, 5s has past, 对方视频数据没来, mRecvVideoData[");
    localStringBuilder.append(this.this$0.a);
    localStringBuilder.append("], SessionType[");
    localStringBuilder.append(localSessionInfo.g);
    localStringBuilder.append("], shutCameraAnswer[");
    localStringBuilder.append(localSessionInfo.M);
    localStringBuilder.append("], cameraPermission[");
    localStringBuilder.append(localSessionInfo.N);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((!this.this$0.a) && (localSessionInfo.g == 2))
    {
      this.this$0.am.onPauseVideo(localSessionInfo.s);
      if ((localSessionInfo.M) || (!localSessionInfo.N))
      {
        localSessionInfo.a(-1011L, "CheckRemoteCameraRunnable", 1);
        this.this$0.a("CheckRemoteCameraRunnable", 1);
      }
      this.this$0.I(-1011L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5
 * JD-Core Version:    0.7.0.1
 */