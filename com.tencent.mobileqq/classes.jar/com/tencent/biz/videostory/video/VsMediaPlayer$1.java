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
    VsMediaPlayer.a(this.this$0, VsMediaPlayer.a(this.this$0) + 1000);
    if (VsMediaPlayer.a(this.this$0) != null) {
      VideoPlayStatusDispatcher.a().a(VsMediaPlayer.a(this.this$0).getCurrentPosition());
    }
    if ((VsMediaPlayer.a(this.this$0) != null) && (VsMediaPlayer.b(this.this$0) != -1) && (VsMediaPlayer.a(this.this$0) >= VsMediaPlayer.b(this.this$0))) {
      VsMediaPlayer.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */