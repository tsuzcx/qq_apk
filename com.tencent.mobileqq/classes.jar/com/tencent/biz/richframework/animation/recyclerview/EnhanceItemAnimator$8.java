package com.tencent.biz.richframework.animation.recyclerview;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)null);
    ViewCompat.setAlpha(this.jdField_a_of_type_AndroidViewView, 1.0F);
    ViewCompat.setTranslationX(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewCompat.setTranslationY(this.jdField_a_of_type_AndroidViewView, 0.0F);
    ViewCompat.setScaleX(this.jdField_a_of_type_AndroidViewView, 1.0F);
    ViewCompat.setScaleY(this.jdField_a_of_type_AndroidViewView, 1.0F);
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchChangeFinished(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.b, false);
    EnhanceItemAnimator.g(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator).remove(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.b);
    EnhanceItemAnimator.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator.dispatchChangeStarting(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationRecyclerviewEnhanceItemAnimator$ChangeInfo.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.8
 * JD-Core Version:    0.7.0.1
 */