package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize
  implements CornerSize
{
  private final float jdField_a_of_type_Float;
  private final CornerSize jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize;
  
  public AdjustedCornerSize(float paramFloat, @NonNull CornerSize paramCornerSize)
  {
    while ((paramCornerSize instanceof AdjustedCornerSize))
    {
      paramCornerSize = ((AdjustedCornerSize)paramCornerSize).jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize;
      paramFloat += ((AdjustedCornerSize)paramCornerSize).jdField_a_of_type_Float;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramCornerSize;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public float a(@NonNull RectF paramRectF)
  {
    return Math.max(0.0F, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize.a(paramRectF) + this.jdField_a_of_type_Float);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AdjustedCornerSize)) {
      return false;
    }
    paramObject = (AdjustedCornerSize)paramObject;
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize.equals(paramObject.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize)) && (this.jdField_a_of_type_Float == paramObject.jdField_a_of_type_Float);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize, Float.valueOf(this.jdField_a_of_type_Float) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.AdjustedCornerSize
 * JD-Core Version:    0.7.0.1
 */