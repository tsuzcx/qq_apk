package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

class EnhanceItemAnimator$6
  extends EnhanceItemAnimator.VpaListenerAdapter
{
  EnhanceItemAnimator$6(EnhanceItemAnimator paramEnhanceItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (this.b != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.c != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.d.setListener((ViewPropertyAnimatorListener)null);
    this.e.dispatchMoveFinished(this.a);
    EnhanceItemAnimator.g(this.e).remove(this.a);
    EnhanceItemAnimator.e(this.e);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.e.dispatchMoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.6
 * JD-Core Version:    0.7.0.1
 */