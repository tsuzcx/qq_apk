package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoControlUI$ToolbarAnimationRunnable
  implements Runnable
{
  VideoControlUI$ToolbarAnimationRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    this.this$0.al.a(new Object[] { Integer.valueOf(102) });
    if (!this.this$0.bi) {
      return;
    }
    VideoControlUI localVideoControlUI;
    if (this.this$0.af)
    {
      localVideoControlUI = this.this$0;
      localVideoControlUI.bh += 1;
    }
    else
    {
      localVideoControlUI = this.this$0;
      localVideoControlUI.bh -= 1;
    }
    if (this.this$0.bh > 5) {
      this.this$0.bh = 5;
    }
    if (this.this$0.bh < 0) {
      this.this$0.bh = 0;
    }
    this.this$0.al.a().postDelayed(this, VideoControlUI.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.ToolbarAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */