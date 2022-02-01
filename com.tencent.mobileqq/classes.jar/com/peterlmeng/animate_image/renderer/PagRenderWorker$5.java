package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;

class PagRenderWorker$5
  implements Runnable
{
  PagRenderWorker$5(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    if ((PagRenderWorker.access$000(this.this$0) != null) && (PagRenderWorker.access$000(this.this$0).isRunning())) {
      PagRenderWorker.access$000(this.this$0).cancel();
    }
    this.this$0.startLoadResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.5
 * JD-Core Version:    0.7.0.1
 */