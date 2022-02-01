package com.google.android.material.transition;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;

final class TransitionUtils$2
  implements TransitionUtils.CornerSizeBinaryOperator
{
  TransitionUtils$2(RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  @NonNull
  public CornerSize a(@NonNull CornerSize paramCornerSize1, @NonNull CornerSize paramCornerSize2)
  {
    return new AbsoluteCornerSize(TransitionUtils.a(paramCornerSize1.a(this.jdField_a_of_type_AndroidGraphicsRectF), paramCornerSize2.a(this.jdField_b_of_type_AndroidGraphicsRectF), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.TransitionUtils.2
 * JD-Core Version:    0.7.0.1
 */