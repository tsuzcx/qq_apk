package com.tencent.biz.videostory.video;

import aaxo;
import aayg;
import android.media.MediaPlayer;
import java.util.TimerTask;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(aaxo paramaaxo) {}
  
  public void run()
  {
    aaxo.a(this.this$0, aaxo.a(this.this$0) + 1000);
    if (aaxo.a(this.this$0) != null) {
      aayg.a().a(aaxo.a(this.this$0).getCurrentPosition());
    }
    if ((aaxo.a(this.this$0) != null) && (aaxo.b(this.this$0) != -1) && (aaxo.a(this.this$0) >= aaxo.b(this.this$0))) {
      aaxo.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */