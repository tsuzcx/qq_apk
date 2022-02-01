package com.tencent.ad.tangram.views.canvas;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.util.Set;

class AdCanvasJsonManager$1
  implements Runnable
{
  AdCanvasJsonManager$1(AdCanvasJsonManager paramAdCanvasJsonManager, String paramString1, Ad paramAd, String paramString2) {}
  
  public void run()
  {
    if (AdCanvasJsonManager.access$000(this.this$0).contains(this.val$canvasJsonUrl)) {
      return;
    }
    AdCanvasJsonManager.access$000(this.this$0).add(this.val$canvasJsonUrl);
    AdThreadManager.INSTANCE.post(new AdCanvasJsonManager.1.1(this), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager.1
 * JD-Core Version:    0.7.0.1
 */