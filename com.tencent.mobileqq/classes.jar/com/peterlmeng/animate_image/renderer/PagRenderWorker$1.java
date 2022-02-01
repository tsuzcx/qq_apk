package com.peterlmeng.animate_image.renderer;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import com.peterlmeng.animate_image.support.log.LogUtils;

class PagRenderWorker$1
  implements Runnable
{
  PagRenderWorker$1(PagRenderWorker paramPagRenderWorker) {}
  
  @RequiresApi(api=19)
  public void run()
  {
    if (PagRenderWorker.access$000(this.this$0) == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pag start and duration is");
    localStringBuilder.append(PagRenderWorker.access$000(this.this$0).getDuration());
    localStringBuilder.append(", ");
    localStringBuilder.append(this.this$0.url);
    LogUtils.c("PagRenderWorker", localStringBuilder.toString());
    this.this$0.loopedCount = 0;
    if (PagRenderWorker.access$100(this.this$0) != 2) {
      PagRenderWorker.access$000(this.this$0).setCurrentPlayTime(0L);
    }
    if (PagRenderWorker.access$100(this.this$0) == 2) {
      if (Build.VERSION.SDK_INT >= 19) {
        PagRenderWorker.access$000(this.this$0).resume();
      }
    }
    for (;;)
    {
      PagRenderWorker.access$102(this.this$0, 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("animator start");
      localStringBuilder.append(this.this$0.url);
      LogUtils.c("PagRenderWorker", localStringBuilder.toString());
      return;
      PagRenderWorker.access$000(this.this$0).start();
      continue;
      PagRenderWorker.access$000(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.1
 * JD-Core Version:    0.7.0.1
 */