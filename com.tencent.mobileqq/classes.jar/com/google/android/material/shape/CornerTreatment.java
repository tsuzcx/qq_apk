package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class CornerTreatment
{
  @Deprecated
  public void a(float paramFloat1, float paramFloat2, @NonNull ShapePath paramShapePath) {}
  
  public void a(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramShapePath);
  }
  
  public void a(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, @NonNull RectF paramRectF, @NonNull CornerSize paramCornerSize)
  {
    a(paramShapePath, paramFloat1, paramFloat2, paramCornerSize.a(paramRectF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.CornerTreatment
 * JD-Core Version:    0.7.0.1
 */