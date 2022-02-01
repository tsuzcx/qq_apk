package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

class BottomSheetBehavior$2
  implements ValueAnimator.AnimatorUpdateListener
{
  BottomSheetBehavior$2(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (BottomSheetBehavior.a(this.a) != null) {
      BottomSheetBehavior.a(this.a).p(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.2
 * JD-Core Version:    0.7.0.1
 */