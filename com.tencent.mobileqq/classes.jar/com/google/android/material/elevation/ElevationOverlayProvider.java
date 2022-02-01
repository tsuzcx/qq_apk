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
  private final boolean a;
  private final int b;
  private final int c;
  private final float d;
  
  public ElevationOverlayProvider(@NonNull Context paramContext)
  {
    this.a = MaterialAttributes.a(paramContext, R.attr.w, false);
    this.b = MaterialColors.a(paramContext, R.attr.v, 0);
    this.c = MaterialColors.a(paramContext, R.attr.t, 0);
    this.d = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private boolean a(@ColorInt int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, 255) == this.c;
  }
  
  public float a(float paramFloat)
  {
    float f = this.d;
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
    if (this.a)
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
    return this.a;
  }
  
  @ColorInt
  public int b(@ColorInt int paramInt, float paramFloat)
  {
    paramFloat = a(paramFloat);
    int i = Color.alpha(paramInt);
    return ColorUtils.setAlphaComponent(MaterialColors.a(ColorUtils.setAlphaComponent(paramInt, 255), this.b, paramFloat), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.elevation.ElevationOverlayProvider
 * JD-Core Version:    0.7.0.1
 */