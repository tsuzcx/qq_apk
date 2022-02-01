package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R.attr;

public class MaterialThemeOverlay
{
  private static final int[] a = { 16842752, R.attr.theme };
  private static final int[] b = { R.attr.C };
  
  @StyleRes
  private static int a(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    int j = paramContext.getResourceId(0, 0);
    int i = paramContext.getResourceId(1, 0);
    paramContext.recycle();
    if (j != 0) {
      i = j;
    }
    return i;
  }
  
  @StyleRes
  private static int a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b, paramInt1, paramInt2);
    paramInt1 = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    return paramInt1;
  }
  
  @NonNull
  public static Context a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramInt2 = a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (((paramContext instanceof ContextThemeWrapper)) && (((ContextThemeWrapper)paramContext).getThemeResId() == paramInt2)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0)
    {
      if (paramInt1 != 0) {
        return paramContext;
      }
      ContextThemeWrapper localContextThemeWrapper = new ContextThemeWrapper(paramContext, paramInt2);
      paramInt1 = a(paramContext, paramAttributeSet);
      if (paramInt1 != 0) {
        localContextThemeWrapper.getTheme().applyStyle(paramInt1, true);
      }
      return localContextThemeWrapper;
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.theme.overlay.MaterialThemeOverlay
 * JD-Core Version:    0.7.0.1
 */