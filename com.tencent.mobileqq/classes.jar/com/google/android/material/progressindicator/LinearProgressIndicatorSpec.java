package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;

public final class LinearProgressIndicatorSpec
  extends BaseProgressIndicatorSpec
{
  public int g;
  public int h;
  boolean i;
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.A);
  }
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, LinearProgressIndicator.d);
  }
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int[] arrayOfInt = R.styleable.dv;
    paramInt1 = R.attr.A;
    paramInt2 = LinearProgressIndicator.d;
    boolean bool = false;
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, arrayOfInt, paramInt1, paramInt2, new int[0]);
    this.g = paramContext.getInt(R.styleable.dw, 1);
    this.h = paramContext.getInt(R.styleable.dx, 0);
    paramContext.recycle();
    c();
    if (this.h == 1) {
      bool = true;
    }
    this.i = bool;
  }
  
  void c()
  {
    if (this.g == 0)
    {
      if (this.b <= 0)
      {
        if (this.c.length >= 3) {
          return;
        }
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
      }
      throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */