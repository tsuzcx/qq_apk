package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class a$d
  implements ValueAnimator.AnimatorUpdateListener
{
  a$d(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f2 = ((Float)paramValueAnimator).floatValue();
      a.a(this.a).setTranslationY(f2);
      float f1 = a.b(this.a).height() * a.c(this.a);
      f2 -= a.b(this.a).top;
      if (f2 <= f1)
      {
        f1 = (f1 - f2) / f1;
        a.a(this.a).setAlpha(1.0F - f1);
        return;
      }
      float f3 = a.b(this.a).height();
      float f4 = 1;
      if (f2 >= f3 * (f4 - a.c(this.a)))
      {
        f1 = (f2 - a.b(this.a).height() * (f4 - a.c(this.a))) / f1;
        a.a(this.a).setAlpha(1.0F - f1);
        return;
      }
      a.a(this.a).setAlpha(1.0F);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */