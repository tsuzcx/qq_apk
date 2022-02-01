package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.luggage.wxa.qz.o;

class e$3
  extends AnimatorListenerAdapter
{
  e$3(e parame, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator = this.c;
    e.a(paramAnimator, paramAnimator.getY(), true);
    e.a(this.c, this.a);
    e.b(this.c, this.b);
    paramAnimator = new StringBuilder();
    paramAnimator.append("startStickyAnimation, mStablePosX: ");
    paramAnimator.append(e.a(this.c));
    paramAnimator.append(", mStablePosY: ");
    paramAnimator.append(e.b(this.c));
    o.d("MicroMsg.AppBrand.AppBrandPipContainerView", paramAnimator.toString());
    paramAnimator = this.c;
    e.a(paramAnimator, e.a(paramAnimator), e.b(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.3
 * JD-Core Version:    0.7.0.1
 */