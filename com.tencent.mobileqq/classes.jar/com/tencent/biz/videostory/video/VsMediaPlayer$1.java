package com.tencent.biz.videostory.video;

import android.media.MediaPlayer;
import java.util.TimerTask;
import xhr;
import xij;

public class VsMediaPlayer$1
  extends TimerTask
{
  public VsMediaPlayer$1(xhr paramxhr) {}
  
  public void run()
  {
    xhr.a(this.this$0, xhr.a(this.this$0) + 1000);
    if (xhr.a(this.this$0) != null) {
      xij.a().a(xhr.a(this.this$0).getCurrentPosition());
    }
    if ((xhr.a(this.this$0) != null) && (xhr.b(this.this$0) != -1) && (xhr.a(this.this$0) >= xhr.b(this.this$0))) {
      xhr.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.video.VsMediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */