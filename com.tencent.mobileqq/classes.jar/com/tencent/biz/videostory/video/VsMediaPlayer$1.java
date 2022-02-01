package com.tencent.biz.videostory.video;

import aano;
import aaog;
import android.media.MediaPlayer;
import java.util.TimerTask;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(aano paramaano) {}
  
  public void run()
  {
    aano.a(this.this$0, aano.a(this.this$0) + 1000);
    if (aano.a(this.this$0) != null) {
      aaog.a().a(aano.a(this.this$0).getCurrentPosition());
    }
    if ((aano.a(this.this$0) != null) && (aano.b(this.this$0) != -1) && (aano.a(this.this$0) >= aano.b(this.this$0))) {
      aano.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */