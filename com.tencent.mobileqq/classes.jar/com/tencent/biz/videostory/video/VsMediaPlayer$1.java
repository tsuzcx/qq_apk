package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import xho;
import xig;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(xho paramxho) {}
  
  public void run()
  {
    xho.a(this.this$0, xho.a(this.this$0) + 1000);
    if (xho.a(this.this$0) != null) {
      xig.a().a(xho.a(this.this$0).getCurrentPosition());
    }
    if ((xho.a(this.this$0) != null) && (xho.b(this.this$0) != -1) && (xho.a(this.this$0) >= xho.b(this.this$0))) {
      xho.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */