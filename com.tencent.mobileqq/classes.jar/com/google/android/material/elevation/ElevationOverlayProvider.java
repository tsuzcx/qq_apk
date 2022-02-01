package com.google.android.material.elevation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R.attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;

public class ElevationOverlayProvider
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final int b;
  
  public ElevationOverlayProvider(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_Boolean = MaterialAttributes.a(paramContext, R.attr.p, false);
    this.jdField_a_of_type_Int = MaterialColors.a(paramContext, R.attr.o, 0);
    this.b = MaterialColors.a(paramContext, R.attr.n, 0);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private boolean a(@ColorInt int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, 255) == this.b;
  }
  
  public float a(float paramFloat)
  {
    float f = this.jdField_a_of_type_Float;
    if (f > 0.0F)
    {
      if (paramFloat <= 0.0F) {
        return 0.0F;
      }
      return Math.min(((float)Math.log1p(paramFloat / f) * 4.5F + 2.0F) / 100.0F, 1.0F);
    }
    return 0.0F;
  }
  
  @ColorInt
  public int a(@ColorInt int paramInt, float paramFloat)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramInt;
      if (a(paramInt)) {
        i = b(paramInt, paramFloat);
      }
    }
    return i;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @ColorInt
  public int b(@ColorInt int paramInt, float paramFloat)
  {
    paramFloat = a(paramFloat);
    int i = Color.alpha(paramInt);
    return ColorUtils.setAlphaComponent(MaterialColors.a(ColorUtils.setAlphaComponent(paramInt, 255), this.jdField_a_of_type_Int, paramFloat), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.elevation.ElevationOverlayProvider
 * JD-Core Version:    0.7.0.1
 */