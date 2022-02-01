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
  @VisibleForTesting
  static final String jdField_a_of_type_JavaLangString = RippleUtils.class.getSimpleName();
  public static final boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] b;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  private static final int[] h;
  private static final int[] i;
  private static final int[] j;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    jdField_a_of_type_ArrayOfInt = new int[] { 16842919 };
    b = new int[] { 16843623, 16842908 };
    c = new int[] { 16842908 };
    d = new int[] { 16843623 };
    e = new int[] { 16842913, 16842919 };
    f = new int[] { 16842913, 16843623, 16842908 };
    g = new int[] { 16842913, 16842908 };
    h = new int[] { 16842913, 16843623 };
    i = new int[] { 16842913 };
    j = new int[] { 16842910, 16842919 };
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
    int k;
    if (paramColorStateList != null) {
      k = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      k = 0;
    }
    int m = k;
    if (jdField_a_of_type_Boolean) {
      m = a(k);
    }
    return m;
  }
  
  @NonNull
  public static ColorStateList a(@Nullable ColorStateList paramColorStateList)
  {
    if (jdField_a_of_type_Boolean)
    {
      arrayOfInt1 = i;
      k = a(paramColorStateList, e);
      arrayOfInt2 = StateSet.NOTHING;
      m = a(paramColorStateList, jdField_a_of_type_ArrayOfInt);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { k, m });
    }
    int[] arrayOfInt1 = e;
    int k = a(paramColorStateList, arrayOfInt1);
    int[] arrayOfInt2 = f;
    int m = a(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = g;
    int n = a(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = h;
    int i1 = a(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = i;
    int[] arrayOfInt6 = jdField_a_of_type_ArrayOfInt;
    int i2 = a(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = b;
    int i3 = a(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = c;
    int i4 = a(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = d;
    int i5 = a(paramColorStateList, arrayOfInt9);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { k, m, n, i1, 0, i2, i3, i4, i5, 0 });
  }
  
  public static boolean a(@NonNull int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfInt.length;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    int n = 0;
    while (k < i2)
    {
      int i3 = paramArrayOfInt[k];
      int i1;
      if (i3 == 16842910)
      {
        i1 = 1;
      }
      else
      {
        if (i3 == 16842908) {}
        do
        {
          do
          {
            n = 1;
            i1 = m;
            break;
          } while (i3 == 16842919);
          i1 = m;
        } while (i3 == 16843623);
      }
      k += 1;
      m = i1;
    }
    boolean bool1 = bool2;
    if (m != 0)
    {
      bool1 = bool2;
      if (n != 0) {
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
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 27) && (Color.alpha(paramColorStateList.getDefaultColor()) == 0) && (Color.alpha(paramColorStateList.getColorForState(j, 0)) != 0)) {
        Log.w(jdField_a_of_type_JavaLangString, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
      }
      return paramColorStateList;
    }
    return ColorStateList.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.ripple.RippleUtils
 * JD-Core Version:    0.7.0.1
 */