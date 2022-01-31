package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import ywh;
import ywz;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(ywh paramywh) {}
  
  public void run()
  {
    ywh.a(this.this$0, ywh.a(this.this$0) + 1000);
    if (ywh.a(this.this$0) != null) {
      ywz.a().a(ywh.a(this.this$0).getCurrentPosition());
    }
    if ((ywh.a(this.this$0) != null) && (ywh.b(this.this$0) != -1) && (ywh.a(this.this$0) >= ywh.b(this.this$0))) {
      ywh.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */