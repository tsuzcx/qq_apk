package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment
  extends EdgeTreatment
{
  private final float a;
  private final boolean b;
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    paramShapePath.b(paramFloat2 - this.a * paramFloat3, 0.0F);
    float f;
    if (this.b) {
      f = this.a;
    } else {
      f = -this.a;
    }
    paramShapePath.b(paramFloat2, f * paramFloat3);
    paramShapePath.b(paramFloat2 + this.a * paramFloat3, 0.0F);
    paramShapePath.b(paramFloat1, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.TriangleEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */