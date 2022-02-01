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
    SessionInfo localSessionInfo = this.a.k();
    String str = VideoController.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompletion, onClose, mainSession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], timeOutTask[");
    localStringBuilder.append(VideoController.a(this.a));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (VideoController.a(this.a) != null)
    {
      this.a.e.a().removeCallbacks(VideoController.a(this.a));
      VideoController.a(this.a, null);
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!localSessionInfo.n())
    {
      AVLog.printAllUserLog(VideoController.a, "onCompletion onClose is not Closing2");
      this.b = 0L;
      return;
    }
    this.a.a(localSessionInfo.s, 217);
    this.a.b(217);
    this.a.b(localSessionInfo.s, this.a.k().ay);
    this.b = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.10
 * JD-Core Version:    0.7.0.1
 */