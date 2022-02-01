package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ScreenShareCtrl$ShareOpsTimeOutTask
  implements Runnable
{
  private final WeakReference<VideoController> a;
  private final SessionInfo b;
  private final int c;
  private final int d;
  
  public ScreenShareCtrl$ShareOpsTimeOutTask(VideoController paramVideoController, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    this.a = new WeakReference(paramVideoController);
    this.b = paramSessionInfo;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void run()
  {
    VideoController localVideoController = (VideoController)this.a.get();
    if ((localVideoController != null) && (this.b != null))
    {
      int i;
      if (this.c == 1) {
        i = 86;
      } else {
        i = 89;
      }
      int j;
      if (this.b.H) {
        j = 2;
      } else {
        j = 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShareOpsTimeOutTask, actionResult[");
        localStringBuilder.append(i);
        localStringBuilder.append("], session[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("], multiAVSubType[");
        localStringBuilder.append(j);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      localVideoController.onShareOpsCallback(i, this.d, this.b.aQ, this.b.aN, this.b.o, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareOpsTimeOutTask
 * JD-Core Version:    0.7.0.1
 */