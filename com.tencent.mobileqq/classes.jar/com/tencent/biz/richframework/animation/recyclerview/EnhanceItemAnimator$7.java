package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    ViewCompat.setScaleX(paramView, 1.0F);
    ViewCompat.setScaleY(paramView, 1.0F);
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchChangeFinished(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.a, true);
    EnhanceItemAnimator.g(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator).remove(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.a);
    EnhanceItemAnimator.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchChangeStarting(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.7
 * JD-Core Version:    0.7.0.1
 */