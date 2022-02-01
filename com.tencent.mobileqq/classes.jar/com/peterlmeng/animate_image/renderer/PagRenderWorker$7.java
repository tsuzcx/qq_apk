package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

class PagRenderWorker$7
  implements Runnable
{
  PagRenderWorker$7(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    if (this.this$0.loopCount == 0) {
      return;
    }
    PagRenderWorker.access$002(this.this$0, ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
    if (this.this$0.loopCount < 0) {
      PagRenderWorker.access$000(this.this$0).setRepeatCount(-1);
    }
    for (;;)
    {
      PagRenderWorker.access$000(this.this$0).setInterpolator(new LinearInterpolator());
      PagRenderWorker.access$000(this.this$0).addUpdateListener(new PagRenderWorker.7.1(this));
      PagRenderWorker.access$000(this.this$0).addListener(new PagRenderWorker.7.2(this));
      return;
      PagRenderWorker.access$000(this.this$0).setRepeatCount(this.this$0.loopCount - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.7
 * JD-Core Version:    0.7.0.1
 */