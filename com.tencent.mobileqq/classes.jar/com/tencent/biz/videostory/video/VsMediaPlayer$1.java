package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import com.tencent.biz.videostory.widget.easylyric.VideoPlayStatusDispatcher;
import java.util.TimerTask;

class VsMediaPlayer$1
  extends TimerTask
{
  VsMediaPlayer$1(VsMediaPlayer paramVsMediaPlayer) {}
  
  public void run()
  {
    VsMediaPlayer localVsMediaPlayer = this.this$0;
    VsMediaPlayer.a(localVsMediaPlayer, VsMediaPlayer.a(localVsMediaPlayer) + 1000);
    if (VsMediaPlayer.b(this.this$0) != null) {
      VideoPlayStatusDispatcher.a().a(VsMediaPlayer.b(this.this$0).getCurrentPosition());
    }
    if ((VsMediaPlayer.c(this.this$0) != null) && (VsMediaPlayer.d(this.this$0) != -1) && (VsMediaPlayer.a(this.this$0) >= VsMediaPlayer.d(this.this$0))) {
      VsMediaPlayer.e(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */