package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class VideoLayerUI$LastMsgRunnable
  implements Runnable
{
  private VideoLayerUI$LastMsgRunnable(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.a().removeCallbacks(VideoLayerUI.b(this.this$0));
    }
    VideoLayerUI.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.LastMsgRunnable
 * JD-Core Version:    0.7.0.1
 */