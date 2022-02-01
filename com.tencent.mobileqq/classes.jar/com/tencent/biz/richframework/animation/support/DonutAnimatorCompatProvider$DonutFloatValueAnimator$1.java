package com.tencent.biz.richframework.animation.support;

import android.view.View;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator$1
  implements Runnable
{
  DonutAnimatorCompatProvider$DonutFloatValueAnimator$1(DonutAnimatorCompatProvider.DonutFloatValueAnimator paramDonutFloatValueAnimator) {}
  
  public void run()
  {
    float f = (float)(DonutAnimatorCompatProvider.DonutFloatValueAnimator.a(this.this$0) - DonutAnimatorCompatProvider.DonutFloatValueAnimator.b(this.this$0)) * 1.0F / (float)DonutAnimatorCompatProvider.DonutFloatValueAnimator.c(this.this$0);
    if ((f > 1.0F) || (this.this$0.c.getParent() == null)) {
      f = 1.0F;
    }
    DonutAnimatorCompatProvider.DonutFloatValueAnimator.a(this.this$0, f);
    DonutAnimatorCompatProvider.DonutFloatValueAnimator.d(this.this$0);
    if (DonutAnimatorCompatProvider.DonutFloatValueAnimator.e(this.this$0) >= 1.0F)
    {
      DonutAnimatorCompatProvider.DonutFloatValueAnimator.f(this.this$0);
      return;
    }
    this.this$0.c.postDelayed(DonutAnimatorCompatProvider.DonutFloatValueAnimator.g(this.this$0), 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.support.DonutAnimatorCompatProvider.DonutFloatValueAnimator.1
 * JD-Core Version:    0.7.0.1
 */