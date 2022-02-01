package com.google.android.material.transition;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator;

final class TransitionUtils$1
  implements ShapeAppearanceModel.CornerSizeUnaryOperator
{
  TransitionUtils$1(RectF paramRectF) {}
  
  @NonNull
  public CornerSize a(@NonNull CornerSize paramCornerSize)
  {
    if ((paramCornerSize instanceof RelativeCornerSize)) {
      return paramCornerSize;
    }
    return new RelativeCornerSize(paramCornerSize.a(this.a) / this.a.height());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.TransitionUtils.1
 * JD-Core Version:    0.7.0.1
 */