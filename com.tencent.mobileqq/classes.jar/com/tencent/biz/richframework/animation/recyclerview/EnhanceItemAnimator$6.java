package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
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
    if (this.jdField_a_of_type_Int != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.b != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchMoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    EnhanceItemAnimator.f(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    EnhanceItemAnimator.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchMoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.6
 * JD-Core Version:    0.7.0.1
 */