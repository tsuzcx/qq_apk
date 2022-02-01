package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import com.peterlmeng.animate_image.support.log.LogUtils;

class PagRenderWorker$10
  implements Runnable
{
  PagRenderWorker$10(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    PagRenderWorker.access$302(this.this$0, false);
    PagRenderWorker.access$102(this.this$0, 2);
    if (PagRenderWorker.access$000(this.this$0) == null)
    {
      LogUtils.c("PagRenderWorker", "animator is null when pause");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.10
 * JD-Core Version:    0.7.0.1
 */