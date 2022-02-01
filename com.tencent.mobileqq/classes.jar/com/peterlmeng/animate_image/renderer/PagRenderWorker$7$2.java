package com.peterlmeng.animate_image.renderer;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.peterlmeng.animate_image.support.log.LogUtils;

class PagRenderWorker$7$2
  implements Animator.AnimatorListener
{
  PagRenderWorker$7$2(PagRenderWorker.7 param7) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    LogUtils.c("PagRenderWorker", "onAnimationCancel");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LogUtils.c("PagRenderWorker", "onAnimationEnd");
    PagRenderWorker.access$600(this.this$1.this$0);
    PagRenderWorker.access$302(this.this$1.this$0, false);
    paramAnimator = this.this$1.this$0;
    paramAnimator.loopedCount += 1;
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    LogUtils.c("PagRenderWorker", "onAnimationRepeat");
    PagRenderWorker.access$600(this.this$1.this$0);
    paramAnimator = this.this$1.this$0;
    paramAnimator.loopedCount += 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    LogUtils.c("PagRenderWorker", "onAnimationStart");
    PagRenderWorker.access$302(this.this$1.this$0, true);
    this.this$1.this$0.loopedCount = 0;
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.7.2
 * JD-Core Version:    0.7.0.1
 */