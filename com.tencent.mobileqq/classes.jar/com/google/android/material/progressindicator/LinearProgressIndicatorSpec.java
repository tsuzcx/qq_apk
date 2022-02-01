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
  boolean a;
  public int f;
  public int g;
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.t);
  }
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, LinearProgressIndicator.b);
  }
  
  public LinearProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    int[] arrayOfInt = R.styleable.L;
    paramInt1 = R.attr.t;
    paramInt2 = LinearProgressIndicator.b;
    boolean bool = false;
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, arrayOfInt, paramInt1, paramInt2, new int[0]);
    this.f = paramContext.getInt(R.styleable.ce, 1);
    this.g = paramContext.getInt(R.styleable.cf, 0);
    paramContext.recycle();
    a();
    if (this.g == 1) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  void a()
  {
    if (this.f == 0)
    {
      if (this.b <= 0)
      {
        if (this.jdField_a_of_type_ArrayOfInt.length >= 3) {
          return;
        }
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
      }
      throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */