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
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("value = ");
    localStringBuilder.append(f1);
    paramValueAnimator.println(localStringBuilder.toString());
    int i = 0;
    while (i < this.a - this.b)
    {
      paramValueAnimator = this.g.getChildAt(this.c + i);
      if (paramValueAnimator != null) {
        paramValueAnimator.setTranslationX(this.d * f1);
      }
      i += 1;
    }
    this.e.setTranslationX(f1 * -this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.1
 * JD-Core Version:    0.7.0.1
 */