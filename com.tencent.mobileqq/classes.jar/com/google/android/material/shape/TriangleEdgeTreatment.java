package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment
  extends EdgeTreatment
{
  private final float jdField_a_of_type_Float;
  private final boolean jdField_a_of_type_Boolean;
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    paramShapePath.b(paramFloat2 - this.jdField_a_of_type_Float * paramFloat3, 0.0F);
    float f;
    if (this.jdField_a_of_type_Boolean) {
      f = this.jdField_a_of_type_Float;
    } else {
      f = -this.jdField_a_of_type_Float;
    }
    paramShapePath.b(paramFloat2, f * paramFloat3);
    paramShapePath.b(paramFloat2 + this.jdField_a_of_type_Float * paramFloat3, 0.0F);
    paramShapePath.b(paramFloat1, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.TriangleEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */