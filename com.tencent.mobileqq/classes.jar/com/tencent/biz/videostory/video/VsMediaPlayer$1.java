package com.tencent.biz.videostory.video;

import abbr;
import abcj;
import android.media.MediaPlayer;
import java.util.TimerTask;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(abbr paramabbr) {}
  
  public void run()
  {
    abbr.a(this.this$0, abbr.a(this.this$0) + 1000);
    if (abbr.a(this.this$0) != null) {
      abcj.a().a(abbr.a(this.this$0).getCurrentPosition());
    }
    if ((abbr.a(this.this$0) != null) && (abbr.b(this.this$0) != -1) && (abbr.a(this.this$0) >= abbr.b(this.this$0))) {
      abbr.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */