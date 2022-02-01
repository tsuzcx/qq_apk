package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils
{
  public static final boolean a;
  @VisibleForTesting
  static final String b = RippleUtils.class.getSimpleName();
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  private static final int[] h;
  private static final int[] i;
  private static final int[] j;
  private static final int[] k;
  private static final int[] l;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
    c = new int[] { 16842919 };
    d = new int[] { 16843623, 16842908 };
    e = new int[] { 16842908 };
    f = new int[] { 16843623 };
    g = new int[] { 16842913, 16842919 };
    h = new int[] { 16842913, 16843623, 16842908 };
    i = new int[] { 16842913, 16842908 };
    j = new int[] { 16842913, 16843623 };
    k = new int[] { 16842913 };
    l = new int[] { 16842910, 16842919 };
  }
  
  @TargetApi(21)
  @ColorInt
  private static int a(@ColorInt int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  @ColorInt
  private static int a(@Nullable ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    int m;
    if (paramColorStateList != null) {
      m = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      m = 0;
    }
    int n = m;
    if (a) {
      n = a(m);
    }
    return n;
  }
  
  @NonNull
  public static ColorStateList a(@Nullable ColorStateList paramColorStateList)
  {
    if (a)
    {
      arrayOfInt1 = k;
      m = a(paramColorStateList, g);
      arrayOfInt2 = StateSet.NOTHING;
      n = a(paramColorStateList, c);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { m, n });
    }
    int[] arrayOfInt1 = g;
    int m = a(paramColorStateList, arrayOfInt1);
    int[] arrayOfInt2 = h;
    int n = a(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = i;
    int i1 = a(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = j;
    int i2 = a(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = k;
    int[] arrayOfInt6 = c;
    int i3 = a(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = d;
    int i4 = a(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = e;
    int i5 = a(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = f;
    int i6 = a(paramColorStateList, arrayOfInt9);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { m, n, i1, i2, 0, i3, i4, i5, i6, 0 });
  }
  
  public static boolean a(@NonNull int[] paramArrayOfInt)
  {
    int i3 = paramArrayOfInt.length;
    boolean bool2 = false;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (m < i3)
    {
      int i4 = paramArrayOfInt[m];
      int i2;
      if (i4 == 16842910)
      {
        i2 = 1;
      }
      else
      {
        if (i4 == 16842908) {}
        do
        {
          do
          {
            i1 = 1;
            i2 = n;
            break;
          } while (i4 == 16842919);
          i2 = n;
        } while (i4 == 16843623);
      }
      m += 1;
      n = i2;
    }
    boolean bool1 = bool2;
    if (n != 0)
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NonNull
  public static ColorStateList b(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 27) && (Color.alpha(paramColorStateList.getDefaultColor()) == 0) && (Color.alpha(paramColorStateList.getColorForState(l, 0)) != 0)) {
        Log.w(b, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
      }
      return paramColorStateList;
    }
    return ColorStateList.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.ripple.RippleUtils
 * JD-Core Version:    0.7.0.1
 */