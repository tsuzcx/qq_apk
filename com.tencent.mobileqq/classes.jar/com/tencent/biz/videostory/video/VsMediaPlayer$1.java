package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import zyc;
import zyu;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(zyc paramzyc) {}
  
  public void run()
  {
    zyc.a(this.this$0, zyc.a(this.this$0) + 1000);
    if (zyc.a(this.this$0) != null) {
      zyu.a().a(zyc.a(this.this$0).getCurrentPosition());
    }
    if ((zyc.a(this.this$0) != null) && (zyc.b(this.this$0) != -1) && (zyc.a(this.this$0) >= zyc.b(this.this$0))) {
      zyc.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */