package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoControlUI$ToolbarAnimationRunnable
  implements Runnable
{
  VideoControlUI$ToolbarAnimationRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    this.this$0.a.a(new Object[] { Integer.valueOf(102) });
    if (!this.this$0.l) {
      return;
    }
    VideoControlUI localVideoControlUI;
    if (this.this$0.h)
    {
      localVideoControlUI = this.this$0;
      localVideoControlUI.y += 1;
    }
    else
    {
      localVideoControlUI = this.this$0;
      localVideoControlUI.y -= 1;
    }
    if (this.this$0.y > 5) {
      this.this$0.y = 5;
    }
    if (this.this$0.y < 0) {
      this.this$0.y = 0;
    }
    this.this$0.a.a().postDelayed(this, VideoControlUI.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ToolbarAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */