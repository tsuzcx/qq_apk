package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.os.Handler;
import com.peterlmeng.animate_image.support.log.LogUtils;

class PagRenderWorker$9
  implements Runnable
{
  PagRenderWorker$9(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    PagRenderWorker.access$302(this.this$0, false);
    PagRenderWorker.access$102(this.this$0, 4);
    if (this.this$0.handler != null) {
      this.this$0.handler.removeCallbacksAndMessages(this);
    }
    if (PagRenderWorker.access$000(this.this$0) == null)
    {
      LogUtils.c("PagRenderWorker", "animator is null when stop");
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      PagRenderWorker.access$000(this.this$0).pause();
      LogUtils.c("PagRenderWorker", "paused");
      return;
    }
    PagRenderWorker.access$000(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.9
 * JD-Core Version:    0.7.0.1
 */