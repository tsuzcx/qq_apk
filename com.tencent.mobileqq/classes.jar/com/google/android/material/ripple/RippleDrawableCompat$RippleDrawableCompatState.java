package com.google.android.material.ripple;

import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

final class RippleDrawableCompat$RippleDrawableCompatState
  extends Drawable.ConstantState
{
  @NonNull
  MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  boolean jdField_a_of_type_Boolean;
  
  public RippleDrawableCompat$RippleDrawableCompatState(@NonNull RippleDrawableCompatState paramRippleDrawableCompatState)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = ((MaterialShapeDrawable)paramRippleDrawableCompatState.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.getConstantState().newDrawable());
    this.jdField_a_of_type_Boolean = paramRippleDrawableCompatState.jdField_a_of_type_Boolean;
  }
  
  public RippleDrawableCompat$RippleDrawableCompatState(MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = paramMaterialShapeDrawable;
    this.jdField_a_of_type_Boolean = false;
  }
  
  @NonNull
  public RippleDrawableCompat a()
  {
    return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState
 * JD-Core Version:    0.7.0.1
 */