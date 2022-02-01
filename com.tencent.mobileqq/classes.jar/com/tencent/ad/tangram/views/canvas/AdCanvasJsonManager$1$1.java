package com.tencent.ad.tangram.views.canvas;

import com.tencent.ad.tangram.thread.AdThreadManager;

class AdCanvasJsonManager$1$1
  implements Runnable
{
  AdCanvasJsonManager$1$1(AdCanvasJsonManager.1 param1) {}
  
  public void run()
  {
    AdCanvasJsonManager.access$100(this.this$1.this$0, this.this$1.val$ad, this.this$1.val$canvasJsonKey, this.this$1.val$canvasJsonUrl);
    AdThreadManager.INSTANCE.post(new AdCanvasJsonManager.1.1.1(this), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager.1.1
 * JD-Core Version:    0.7.0.1
 */