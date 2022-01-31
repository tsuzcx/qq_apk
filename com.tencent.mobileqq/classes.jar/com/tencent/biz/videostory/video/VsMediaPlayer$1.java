package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import zaw;
import zbo;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(zaw paramzaw) {}
  
  public void run()
  {
    zaw.a(this.this$0, zaw.a(this.this$0) + 1000);
    if (zaw.a(this.this$0) != null) {
      zbo.a().a(zaw.a(this.this$0).getCurrentPosition());
    }
    if ((zaw.a(this.this$0) != null) && (zaw.b(this.this$0) != -1) && (zaw.a(this.this$0) >= zaw.b(this.this$0))) {
      zaw.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */