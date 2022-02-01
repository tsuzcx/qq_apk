package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class PublicAccountChatPie$13
  implements ValueAnimator.AnimatorUpdateListener
{
  PublicAccountChatPie$13(PublicAccountChatPie paramPublicAccountChatPie, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
      paramValueAnimator = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_a_of_type_Int;
      paramValueAnimator.height = ((int)(i + f * (this.b - i)));
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.13
 * JD-Core Version:    0.7.0.1
 */