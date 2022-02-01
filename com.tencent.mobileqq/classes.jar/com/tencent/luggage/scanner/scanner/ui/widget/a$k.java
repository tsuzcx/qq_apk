package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView$showSuccessView$2$2"}, k=3, mv={1, 1, 16})
final class a$k
  implements ValueAnimator.AnimatorUpdateListener
{
  a$k(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = a.g(this.a);
      if (paramValueAnimator != null) {
        paramValueAnimator.setAlpha(1.0F - f);
      }
      paramValueAnimator = (Iterable)a.e(this.a);
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject = (View)localObject;
        if (i < a.h(this.a))
        {
          ((View)localObject).setAlpha(f);
          ((View)localObject).setScaleX(f);
          ((View)localObject).setScaleY(f);
        }
        i += 1;
      }
      if (a.i(this.a)) {
        a.j(this.a).setAlpha(f);
      }
      return;
    }
    paramValueAnimator = new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    for (;;)
    {
      throw paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a.k
 * JD-Core Version:    0.7.0.1
 */