package com.tencent.livesdk.livesdkplayer.renderview;

import android.view.View;

class TPPlayerVideoView$2
  implements Runnable
{
  TPPlayerVideoView$2(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void run()
  {
    if (TPPlayerVideoView.access$900(this.this$0)) {
      TPPlayerVideoView.access$1002(this.this$0, null);
    }
    for (;;)
    {
      TPPlayerVideoView.access$1100(this.this$0).setOpaqueInfo(true);
      ((View)TPPlayerVideoView.access$1100(this.this$0)).requestFocus();
      return;
      if (TPPlayerVideoView.access$1000(this.this$0) != null) {
        this.this$0.removeView((View)TPPlayerVideoView.access$1000(this.this$0));
      }
      TPPlayerVideoView.access$1002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView.2
 * JD-Core Version:    0.7.0.1
 */