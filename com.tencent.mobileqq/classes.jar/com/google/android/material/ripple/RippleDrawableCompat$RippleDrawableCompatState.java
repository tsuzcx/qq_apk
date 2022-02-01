package com.google.android.material.ripple;

import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

final class RippleDrawableCompat$RippleDrawableCompatState
  extends Drawable.ConstantState
{
  @NonNull
  MaterialShapeDrawable a;
  boolean b;
  
  public RippleDrawableCompat$RippleDrawableCompatState(@NonNull RippleDrawableCompatState paramRippleDrawableCompatState)
  {
    this.a = ((MaterialShapeDrawable)paramRippleDrawableCompatState.a.getConstantState().newDrawable());
    this.b = paramRippleDrawableCompatState.b;
  }
  
  public RippleDrawableCompat$RippleDrawableCompatState(MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    this.a = paramMaterialShapeDrawable;
    this.b = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState
 * JD-Core Version:    0.7.0.1
 */