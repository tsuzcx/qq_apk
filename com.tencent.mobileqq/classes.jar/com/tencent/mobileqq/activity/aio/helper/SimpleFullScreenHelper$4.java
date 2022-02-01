package com.tencent.mobileqq.activity.aio.helper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.LargeAreaPatchedButton;
import com.tencent.widget.XEditTextEx;

class SimpleFullScreenHelper$4
  implements ValueAnimator.AnimatorUpdateListener
{
  SimpleFullScreenHelper$4(SimpleFullScreenHelper paramSimpleFullScreenHelper, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f3 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = (int)(SimpleFullScreenHelper.d(this.e) + this.a * f3);
    int j = (int)(SimpleFullScreenHelper.e(this.e) + this.b * f3);
    float f1 = SimpleFullScreenHelper.f(this.e);
    float f2 = 1.0F - f3;
    int k = (int)(f1 * f2);
    paramValueAnimator = (FrameLayout.LayoutParams)SimpleFullScreenHelper.g(this.e).getLayoutParams();
    paramValueAnimator.width = j;
    paramValueAnimator.height = i;
    paramValueAnimator.leftMargin = k;
    paramValueAnimator = (FrameLayout.LayoutParams)SimpleFullScreenHelper.h(this.e).getLayoutParams();
    i = this.c;
    paramValueAnimator.leftMargin = ((int)(i * f3));
    paramValueAnimator.rightMargin = ((int)(i * f3));
    paramValueAnimator.topMargin = ((int)(this.d * f3));
    SimpleFullScreenHelper.h(this.e).setPadding((int)(SimpleFullScreenHelper.i(this.e) * f2), (int)(SimpleFullScreenHelper.j(this.e) * f2), (int)(SimpleFullScreenHelper.k(this.e) * f2), (int)(SimpleFullScreenHelper.l(this.e) * f2));
    paramValueAnimator = (FrameLayout.LayoutParams)SimpleFullScreenHelper.m(this.e).getLayoutParams();
    i = this.c;
    paramValueAnimator.leftMargin = ((int)(i + i * f2));
    j = SimpleFullScreenHelper.m(this.e).getChildCount();
    i = 0;
    while (i < j)
    {
      paramValueAnimator = SimpleFullScreenHelper.m(this.e).getChildAt(i);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramValueAnimator.getLayoutParams();
      f1 = SimpleFullScreenHelper.a(this.e, (j - i) * f3);
      localLayoutParams.leftMargin = ((int)(this.c * (1.0F - f1)));
      paramValueAnimator.setAlpha(f1);
      i += 1;
    }
    SimpleFullScreenHelper.n(this.e).setAlpha(f3);
    SimpleFullScreenHelper.o(this.e).setAlpha(f3);
    paramValueAnimator = SimpleFullScreenHelper.p(this.e);
    f2 = 2.0F * f3;
    f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    paramValueAnimator.setAlpha(f1);
    SimpleFullScreenHelper.g(this.e).setAlpha(f3 * 0.5F + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SimpleFullScreenHelper.4
 * JD-Core Version:    0.7.0.1
 */