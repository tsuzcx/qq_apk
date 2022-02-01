package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors
{
  @ColorInt
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    return ColorUtils.compositeColors(paramInt2, paramInt1);
  }
  
  @ColorInt
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return a(paramInt1, ColorUtils.setAlphaComponent(paramInt2, Math.round(Color.alpha(paramInt2) * paramFloat)));
  }
  
  @ColorInt
  public static int a(@NonNull Context paramContext, @AttrRes int paramInt1, @ColorInt int paramInt2)
  {
    paramContext = MaterialAttributes.a(paramContext, paramInt1);
    if (paramContext != null) {
      return paramContext.data;
    }
    return paramInt2;
  }
  
  @ColorInt
  public static int a(Context paramContext, @AttrRes int paramInt, String paramString)
  {
    return MaterialAttributes.a(paramContext, paramInt, paramString);
  }
  
  @ColorInt
  public static int a(@NonNull View paramView, @AttrRes int paramInt)
  {
    return MaterialAttributes.a(paramView, paramInt);
  }
  
  @ColorInt
  public static int a(@NonNull View paramView, @AttrRes int paramInt1, @ColorInt int paramInt2)
  {
    return a(paramView.getContext(), paramInt1, paramInt2);
  }
  
  @ColorInt
  public static int a(@NonNull View paramView, @AttrRes int paramInt1, @AttrRes int paramInt2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return a(a(paramView, paramInt1), a(paramView, paramInt2), paramFloat);
  }
  
  @ColorInt
  public static int b(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    return ColorUtils.setAlphaComponent(paramInt1, Color.alpha(paramInt1) * paramInt2 / 255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.color.MaterialColors
 * JD-Core Version:    0.7.0.1
 */