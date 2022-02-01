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
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.b) {
      this.a.a.draw(paramCanvas);
    }
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return this.a.a.getOpacity();
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.a.a.getShapeAppearanceModel();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.a.setBounds(paramRect);
  }
  
  protected boolean onStateChange(@NonNull int[] paramArrayOfInt)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    if (this.a.a.setState(paramArrayOfInt)) {
      bool1 = true;
    }
    boolean bool2 = RippleUtils.a(paramArrayOfInt);
    if (this.a.b != bool2)
    {
      this.a.b = bool2;
      bool1 = true;
    }
    return bool1;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.a.a.setColorFilter(paramColorFilter);
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.a.a.setShapeAppearanceModel(paramShapeAppearanceModel);
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    this.a.a.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.a.a.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.a.a.setTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.ripple.RippleDrawableCompat
 * JD-Core Version:    0.7.0.1
 */