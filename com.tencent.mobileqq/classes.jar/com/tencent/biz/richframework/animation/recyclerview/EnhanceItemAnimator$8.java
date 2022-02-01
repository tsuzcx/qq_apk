package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import java.util.ArrayList;

class EnhanceItemAnimator$8
  extends EnhanceItemAnimator.VpaListenerAdapter
{
  EnhanceItemAnimator$8(EnhanceItemAnimator paramEnhanceItemAnimator, EnhanceItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(this.c, 1.0F);
    ViewCompat.setTranslationX(this.c, 0.0F);
    ViewCompat.setTranslationY(this.c, 0.0F);
    ViewCompat.setScaleX(this.c, 1.0F);
    ViewCompat.setScaleY(this.c, 1.0F);
    this.d.dispatchChangeFinished(this.a.b, false);
    EnhanceItemAnimator.h(this.d).remove(this.a.b);
    EnhanceItemAnimator.e(this.d);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.d.dispatchChangeStarting(this.a.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.8
 * JD-Core Version:    0.7.0.1
 */