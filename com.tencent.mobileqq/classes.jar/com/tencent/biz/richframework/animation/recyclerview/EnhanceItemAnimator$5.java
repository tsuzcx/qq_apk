package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

class EnhanceItemAnimator$5
  extends EnhanceItemAnimator.VpaListenerAdapter
{
  EnhanceItemAnimator$5(EnhanceItemAnimator paramEnhanceItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener((ViewPropertyAnimatorListener)null);
    this.c.dispatchAddFinished(this.a);
    EnhanceItemAnimator.f(this.c).remove(this.a);
    EnhanceItemAnimator.e(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchAddStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.5
 * JD-Core Version:    0.7.0.1
 */