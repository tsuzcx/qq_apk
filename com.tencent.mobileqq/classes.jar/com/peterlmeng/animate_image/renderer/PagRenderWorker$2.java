package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import com.peterlmeng.animate_image.support.log.LogUtils;

class PagRenderWorker$2
  implements Runnable
{
  PagRenderWorker$2(PagRenderWorker paramPagRenderWorker) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((PagRenderWorker)localObject).loopedCount = 0;
    if ((PagRenderWorker.access$000((PagRenderWorker)localObject) != null) && (!PagRenderWorker.access$000(this.this$0).isRunning()))
    {
      PagRenderWorker.access$000(this.this$0).setCurrentPlayTime(0L);
      PagRenderWorker.access$000(this.this$0).start();
      PagRenderWorker.access$102(this.this$0, 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("restart");
      ((StringBuilder)localObject).append(this.this$0.url);
      LogUtils.c("PagRenderWorker", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.2
 * JD-Core Version:    0.7.0.1
 */