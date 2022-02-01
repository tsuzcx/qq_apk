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
    if (this.a.I != null)
    {
      this.a.e.a().removeCallbacks(this.a.I);
      this.a.I = null;
    }
    AVLog.printAllUserLog(VideoController.a, "onCompletion onCloseDoubleVideoMeeting");
    if (this.a.k().an)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.a.k().aN;
      this.a.e.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.a.a(3, l, 85);
      this.a.k().e("OnCloseDoubleVideoMeetingListener", false);
      this.a.k().f("OnCloseDoubleVideoMeetingListener", false);
    }
    else
    {
      AVLog.printErrorLog(VideoController.a, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
    }
    this.b = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.12
 * JD-Core Version:    0.7.0.1
 */