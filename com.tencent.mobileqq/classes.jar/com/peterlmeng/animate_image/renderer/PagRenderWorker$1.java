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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pag start and duration is");
    ((StringBuilder)localObject).append(PagRenderWorker.access$000(this.this$0).getDuration());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.this$0.url);
    LogUtils.c("PagRenderWorker", ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    ((PagRenderWorker)localObject).loopedCount = 0;
    if (PagRenderWorker.access$100((PagRenderWorker)localObject) != 2) {
      PagRenderWorker.access$000(this.this$0).setCurrentPlayTime(0L);
    }
    if ((PagRenderWorker.access$100(this.this$0) == 2) && (Build.VERSION.SDK_INT >= 19)) {
      PagRenderWorker.access$000(this.this$0).resume();
    } else {
      PagRenderWorker.access$000(this.this$0).start();
    }
    PagRenderWorker.access$102(this.this$0, 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("animator start");
    ((StringBuilder)localObject).append(this.this$0.url);
    LogUtils.c("PagRenderWorker", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.1
 * JD-Core Version:    0.7.0.1
 */