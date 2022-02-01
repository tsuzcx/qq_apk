package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment
  extends CornerTreatment
{
  float a = -1.0F;
  
  public void a(@NonNull ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramShapePath.a(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    paramFloat2 = paramFloat3 * 2.0F * paramFloat2;
    paramShapePath.a(0.0F, 0.0F, paramFloat2, paramFloat2, 180.0F, paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.RoundedCornerTreatment
 * JD-Core Version:    0.7.0.1
 */