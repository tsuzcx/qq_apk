package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement
{
  private static final int[] a = { R.attr.r };
  private static final int[] b = { R.attr.s };
  
  @NonNull
  public static TypedArray a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static void a(@NonNull Context paramContext)
  {
    a(paramContext, a, "Theme.AppCompat");
  }
  
  private static void a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jl, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.jn, false);
    paramAttributeSet.recycle();
    if (bool)
    {
      paramAttributeSet = new TypedValue();
      if ((!paramContext.getTheme().resolveAttribute(R.attr.z, paramAttributeSet, true)) || ((paramAttributeSet.type == 18) && (paramAttributeSet.data == 0))) {
        b(paramContext);
      }
    }
    a(paramContext);
  }
  
  private static void a(@NonNull Context paramContext, @NonNull int[] paramArrayOfInt, String paramString)
  {
    if (a(paramContext, paramArrayOfInt)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("The style on this component requires your app theme to be ");
    paramContext.append(paramString);
    paramContext.append(" (or a descendant).");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  private static boolean a(@NonNull Context paramContext, @NonNull int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (!paramContext.hasValue(i))
      {
        paramContext.recycle();
        return false;
      }
      i += 1;
    }
    paramContext.recycle();
    return true;
  }
  
  public static TintTypedArray b(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static void b(@NonNull Context paramContext)
  {
    a(paramContext, b, "Theme.MaterialComponents");
  }
  
  private static void c(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @Nullable @StyleableRes int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jl, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(R.styleable.jo, false))
    {
      localTypedArray.recycle();
      return;
    }
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      bool = d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    } else if (localTypedArray.getResourceId(R.styleable.jm, -1) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    localTypedArray.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static boolean d(@NonNull Context paramContext, AttributeSet paramAttributeSet, @NonNull @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @NonNull @StyleableRes int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ThemeEnforcement
 * JD-Core Version:    0.7.0.1
 */