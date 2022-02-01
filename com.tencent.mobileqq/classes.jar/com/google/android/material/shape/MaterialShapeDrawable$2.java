package com.google.android.material.shape;

import androidx.annotation.NonNull;

class MaterialShapeDrawable$2
  implements ShapeAppearanceModel.CornerSizeUnaryOperator
{
  MaterialShapeDrawable$2(MaterialShapeDrawable paramMaterialShapeDrawable, float paramFloat) {}
  
  @NonNull
  public CornerSize a(@NonNull CornerSize paramCornerSize)
  {
    if ((paramCornerSize instanceof RelativeCornerSize)) {
      return paramCornerSize;
    }
    return new AdjustedCornerSize(this.a, paramCornerSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeDrawable.2
 * JD-Core Version:    0.7.0.1
 */