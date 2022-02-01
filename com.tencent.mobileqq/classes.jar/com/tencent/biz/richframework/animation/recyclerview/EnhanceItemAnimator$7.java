package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import java.util.ArrayList;

class EnhanceItemAnimator$7
  extends EnhanceItemAnimator.VpaListenerAdapter
{
  EnhanceItemAnimator$7(EnhanceItemAnimator paramEnhanceItemAnimator, EnhanceItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    ViewCompat.setScaleX(paramView, 1.0F);
    ViewCompat.setScaleY(paramView, 1.0F);
    this.c.dispatchChangeFinished(this.a.a, true);
    EnhanceItemAnimator.h(this.c).remove(this.a.a);
    EnhanceItemAnimator.e(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchChangeStarting(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.7
 * JD-Core Version:    0.7.0.1
 */