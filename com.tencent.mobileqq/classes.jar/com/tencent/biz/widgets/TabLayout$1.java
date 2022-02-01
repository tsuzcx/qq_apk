package com.tencent.biz.widgets;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.io.PrintStream;

class TabLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayout$1(TabLayout paramTabLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView, int paramInt5) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("value = ");
    localStringBuilder.append(f);
    paramValueAnimator.println(localStringBuilder.toString());
    int i = 0;
    while (i < this.jdField_a_of_type_Int - this.b)
    {
      paramValueAnimator = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getChildAt(this.c + i);
      if (paramValueAnimator != null) {
        paramValueAnimator.setTranslationX(this.d * f);
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationX(f * -this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.1
 * JD-Core Version:    0.7.0.1
 */