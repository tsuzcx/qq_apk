package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment
  extends CornerTreatment
{
  float a = -1.0F;
  
  public void a(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramShapePath.a(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    double d3 = Math.sin(Math.toRadians(paramFloat1));
    double d1 = paramFloat3;
    Double.isNaN(d1);
    double d2 = paramFloat2;
    Double.isNaN(d2);
    paramFloat2 = (float)(d3 * d1 * d2);
    d3 = Math.sin(Math.toRadians(90.0F - paramFloat1));
    Double.isNaN(d1);
    Double.isNaN(d2);
    paramShapePath.b(paramFloat2, (float)(d3 * d1 * d2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.CutCornerTreatment
 * JD-Core Version:    0.7.0.1
 */