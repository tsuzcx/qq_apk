package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class MarkerEdgeTreatment
  extends EdgeTreatment
{
  private final float a;
  
  public MarkerEdgeTreatment(float paramFloat)
  {
    this.a = (paramFloat - 0.001F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    double d1 = this.a;
    double d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    paramFloat1 = (float)(d1 * d2 / 2.0D);
    paramFloat3 = (float)Math.sqrt(Math.pow(this.a, 2.0D) - Math.pow(paramFloat1, 2.0D));
    d1 = this.a;
    d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    double d3 = this.a;
    Double.isNaN(d3);
    paramShapePath.a(paramFloat2 - paramFloat1, (float)-(d1 * d2 - d3) + paramFloat3);
    d1 = this.a;
    d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    d3 = this.a;
    Double.isNaN(d3);
    paramShapePath.b(paramFloat2, (float)-(d1 * d2 - d3));
    d1 = this.a;
    d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    d3 = this.a;
    Double.isNaN(d3);
    paramShapePath.b(paramFloat2 + paramFloat1, (float)-(d1 * d2 - d3) + paramFloat3);
  }
  
  boolean f()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.MarkerEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */