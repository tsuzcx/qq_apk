package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchRemoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    EnhanceItemAnimator.d(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    EnhanceItemAnimator.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchRemoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.4
 * JD-Core Version:    0.7.0.1
 */