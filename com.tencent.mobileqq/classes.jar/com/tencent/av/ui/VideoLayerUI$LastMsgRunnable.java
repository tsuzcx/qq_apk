package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoLayerUI$LastMsgRunnable
  implements Runnable
{
  private VideoLayerUI$LastMsgRunnable(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.this$0.Y != null) {
      this.this$0.Y.a().removeCallbacks(VideoLayerUI.i(this.this$0));
    }
    VideoLayerUI.c(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.LastMsgRunnable
 * JD-Core Version:    0.7.0.1
 */