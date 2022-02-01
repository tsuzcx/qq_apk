package com.tencent.av;

import android.media.MediaPlayer;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class VideoController$9
  extends VideoController.OnCustomCompletionListener
{
  VideoController$9(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    String str = VideoController.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompletion, request, mainSession[");
    localStringBuilder.append(this.a.k());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.k().m())
    {
      this.b = 0L;
      return;
    }
    this.a.k().a("OnCompletionListener", 6);
    paramMediaPlayer = this.a;
    long l = this.b;
    int i;
    if (this.a.k().aq == 2L) {
      i = 4;
    } else {
      i = 1;
    }
    paramMediaPlayer.a(l, 2131230813, i, VideoController.a(this.a, this.b));
    this.a.e.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.a.k().ay), this.a.k().s, Long.valueOf(this.b) });
    this.b = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.9
 * JD-Core Version:    0.7.0.1
 */