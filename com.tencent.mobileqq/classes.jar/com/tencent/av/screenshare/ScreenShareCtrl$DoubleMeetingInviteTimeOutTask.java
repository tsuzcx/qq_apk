package com.tencent.av.screenshare;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

class ScreenShareCtrl$DoubleMeetingInviteTimeOutTask
  implements Runnable
{
  public final SessionInfo a;
  private final WeakReference<VideoController> b;
  
  public ScreenShareCtrl$DoubleMeetingInviteTimeOutTask(VideoController paramVideoController, @NotNull SessionInfo paramSessionInfo)
  {
    this.b = new WeakReference(paramVideoController);
    this.a = paramSessionInfo;
  }
  
  public void run()
  {
    long l = AudioHelper.c();
    VideoController localVideoController = (VideoController)this.b.get();
    if ((localVideoController != null) && (this.a.i == 9))
    {
      if (localVideoController.e.f() > 0)
      {
        localVideoController.e.a(new Object[] { Integer.valueOf(404), Long.valueOf(l), Long.valueOf(this.a.aN) });
        return;
      }
      if (localVideoController.e.isBackgroundStop) {
        localVideoController.a(l, this.a.aN, true, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.DoubleMeetingInviteTimeOutTask
 * JD-Core Version:    0.7.0.1
 */