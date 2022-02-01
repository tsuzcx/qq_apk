package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources
{
  public static int a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    if ((paramTypedArray.getValue(paramInt1, localTypedValue)) && (localTypedValue.type == 2))
    {
      paramContext = paramContext.getTheme().obtainStyledAttributes(new int[] { localTypedValue.data });
      paramInt1 = paramContext.getDimensionPixelSize(0, paramInt2);
      paramContext.recycle();
      return paramInt1;
    }
    return paramTypedArray.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  @StyleableRes
  static int a(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    if (paramTypedArray.hasValue(paramInt1)) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  @Nullable
  public static ColorStateList a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    int i;
    if (paramTypedArray.hasValue(paramInt))
    {
      i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getColorStateList(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    if (Build.VERSION.SDK_INT <= 15)
    {
      i = paramTypedArray.getColor(paramInt, -1);
      if (i != -1) {
        return ColorStateList.valueOf(i);
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  @Nullable
  public static ColorStateList a(@NonNull Context paramContext, @NonNull TintTypedArray paramTintTypedArray, @StyleableRes int paramInt)
  {
    int i;
    if (paramTintTypedArray.hasValue(paramInt))
    {
      i = paramTintTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getColorStateList(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    if (Build.VERSION.SDK_INT <= 15)
    {
      i = paramTintTypedArray.getColor(paramInt, -1);
      if (i != -1) {
        return ColorStateList.valueOf(i);
      }
    }
    return paramTintTypedArray.getColorStateList(paramInt);
  }
  
  @Nullable
  public static Drawable a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getDrawable(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getDrawable(paramInt);
  }
  
  @Nullable
  public static TextAppearance a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return new TextAppearance(paramContext, paramInt);
      }
    }
    return null;
  }
  
  public static boolean a(@NonNull Context paramContext)
  {
    return paramContext.getResources().getConfiguration().fontScale >= 1.3F;
  }
  
  public static boolean b(@NonNull Context paramContext)
  {
    return paramContext.getResources().getConfiguration().fontScale >= 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.resources.MaterialResources
 * JD-Core Version:    0.7.0.1
 */