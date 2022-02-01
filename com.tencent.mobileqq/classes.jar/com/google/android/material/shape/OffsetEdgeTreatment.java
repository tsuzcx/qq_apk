package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment
  extends EdgeTreatment
{
  private final EdgeTreatment a;
  private final float b;
  
  public OffsetEdgeTreatment(@NonNull EdgeTreatment paramEdgeTreatment, float paramFloat)
  {
    this.a = paramEdgeTreatment;
    this.b = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    this.a.a(paramFloat1, paramFloat2 - this.b, paramFloat3, paramShapePath);
  }
  
  boolean f()
  {
    return this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.OffsetEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */