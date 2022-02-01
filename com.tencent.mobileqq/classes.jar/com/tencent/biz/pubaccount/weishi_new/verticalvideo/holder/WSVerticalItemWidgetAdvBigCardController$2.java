package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVerticalItemWidgetAdvBigCardController$2
  extends AnimatorListenerAdapter
{
  private boolean d = false;
  
  WSVerticalItemWidgetAdvBigCardController$2(WSVerticalItemWidgetAdvBigCardController paramWSVerticalItemWidgetAdvBigCardController, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.d = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("ease-out onAnimationEnd, from:");
    paramAnimator.append(this.a);
    paramAnimator.append(" to:");
    paramAnimator.append(this.b);
    paramAnimator.append(", isCancel:");
    paramAnimator.append(this.d);
    WSLog.a("WSAdvBigCardController", paramAnimator.toString());
    if (this.d)
    {
      this.d = false;
      return;
    }
    WSVerticalItemWidgetAdvBigCardController.e(this.c);
    if (WSVerticalItemWidgetAdvBigCardController.b(this.c) != null) {
      WSVerticalItemWidgetAdvBigCardController.b(this.c).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController.2
 * JD-Core Version:    0.7.0.1
 */