package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment
  extends EdgeTreatment
{
  private final float jdField_a_of_type_Float;
  private final EdgeTreatment jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  
  public OffsetEdgeTreatment(@NonNull EdgeTreatment paramEdgeTreatment, float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramEdgeTreatment;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.a(paramFloat1, paramFloat2 - this.jdField_a_of_type_Float, paramFloat3, paramShapePath);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.OffsetEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */