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
    if (this.this$0.a == null) {
      return;
    }
    if (VideoLayerUI.a(this.this$0).size() > 0)
    {
      this.this$0.a.a().removeCallbacks(VideoLayerUI.a(this.this$0));
      this.this$0.a.a().removeCallbacks(VideoLayerUI.b(this.this$0));
      RecvMsg localRecvMsg = (RecvMsg)VideoLayerUI.a(this.this$0).remove(0);
      VideoLayerUI.a(this.this$0, localRecvMsg);
      this.this$0.a.a().postDelayed(VideoLayerUI.a(this.this$0), 3000L);
      this.this$0.a.a().postDelayed(VideoLayerUI.b(this.this$0), 3000L);
      return;
    }
    this.this$0.a.a().removeCallbacks(VideoLayerUI.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.NewMsgRunnable
 * JD-Core Version:    0.7.0.1
 */