package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import wyr;
import wzj;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(wyr paramwyr) {}
  
  public void run()
  {
    wyr.a(this.this$0, wyr.a(this.this$0) + 1000);
    if (wyr.a(this.this$0) != null) {
      wzj.a().a(wyr.a(this.this$0).getCurrentPosition());
    }
    if ((wyr.a(this.this$0) != null) && (wyr.b(this.this$0) != -1) && (wyr.a(this.this$0) >= wyr.b(this.this$0))) {
      wyr.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */