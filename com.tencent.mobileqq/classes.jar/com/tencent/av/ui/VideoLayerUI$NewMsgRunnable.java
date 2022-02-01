package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import java.util.List;

class VideoLayerUI$NewMsgRunnable
  implements Runnable
{
  private VideoLayerUI$NewMsgRunnable(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.this$0.Y == null) {
      return;
    }
    if (VideoLayerUI.g(this.this$0).size() > 0)
    {
      this.this$0.Y.a().removeCallbacks(VideoLayerUI.h(this.this$0));
      this.this$0.Y.a().removeCallbacks(VideoLayerUI.i(this.this$0));
      RecvMsg localRecvMsg = (RecvMsg)VideoLayerUI.g(this.this$0).remove(0);
      VideoLayerUI.a(this.this$0, localRecvMsg);
      this.this$0.Y.a().postDelayed(VideoLayerUI.h(this.this$0), 3000L);
      this.this$0.Y.a().postDelayed(VideoLayerUI.i(this.this$0), 3000L);
      return;
    }
    this.this$0.Y.a().removeCallbacks(VideoLayerUI.h(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.NewMsgRunnable
 * JD-Core Version:    0.7.0.1
 */