package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

class EnhanceItemAnimator$4
  extends EnhanceItemAnimator.VpaListenerAdapter
{
  EnhanceItemAnimator$4(EnhanceItemAnimator paramEnhanceItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.c.dispatchRemoveFinished(this.a);
    EnhanceItemAnimator.d(this.c).remove(this.a);
    EnhanceItemAnimator.e(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchRemoveStarting(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.4
 * JD-Core Version:    0.7.0.1
 */