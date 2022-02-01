package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat
  extends Drawable
  implements TintAwareDrawable, Shapeable
{
  private RippleDrawableCompat.RippleDrawableCompatState a;
  
  private RippleDrawableCompat(RippleDrawableCompat.RippleDrawableCompatState paramRippleDrawableCompatState)
  {
    this.a = paramRippleDrawableCompatState;
  }
  
  public RippleDrawableCompat(ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this(new RippleDrawableCompat.RippleDrawableCompatState(new MaterialShapeDrawable(paramShapeAppearanceModel)));
  }
  
  @NonNull
  public RippleDrawableCompat a()
  {
    this.a = new RippleDrawableCompat.RippleDrawableCompatState(this.a);
    return this;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.draw(paramCanvas);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.getOpacity();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setBounds(paramRect);
  }
  
  protected boolean onStateChange(@NonNull int[] paramArrayOfInt)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    if (this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setState(paramArrayOfInt)) {
      bool1 = true;
    }
    boolean bool2 = RippleUtils.a(paramArrayOfInt);
    if (this.a.jdField_a_of_type_Boolean != bool2)
    {
      this.a.jdField_a_of_type_Boolean = bool2;
      bool1 = true;
    }
    return bool1;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.ripple.RippleDrawableCompat
 * JD-Core Version:    0.7.0.1
 */