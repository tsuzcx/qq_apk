package com.tencent.luggage.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewParent;

class a$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  a$1$1(a.1 param1, ViewParent paramViewParent) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    int j = Color.argb(i, 255, 255, 255);
    a.b(this.b.b).setBackgroundColor(j);
    a.a(this.b.b, j, true);
    if (i == 0) {
      this.b.b.post(new a.1.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a.1.1
 * JD-Core Version:    0.7.0.1
 */