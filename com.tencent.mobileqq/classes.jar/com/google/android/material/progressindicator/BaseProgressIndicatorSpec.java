package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public abstract class BaseProgressIndicatorSpec
{
  @Px
  public int a;
  @Px
  public int b;
  @NonNull
  public int[] c = new int[0];
  @ColorInt
  public int d;
  public int e;
  public int f;
  
  protected BaseProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.ai);
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.K, paramInt1, paramInt2, new int[0]);
    this.a = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.S, i);
    this.b = Math.min(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.R, 0), this.a / 2);
    this.e = paramAttributeSet.getInt(R.styleable.O, 0);
    this.f = paramAttributeSet.getInt(R.styleable.L, 0);
    a(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  private void a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    if (!paramTypedArray.hasValue(R.styleable.M))
    {
      this.c = new int[] { MaterialColors.a(paramContext, R.attr.r, -1) };
      return;
    }
    if (paramTypedArray.peekValue(R.styleable.M).type != 1)
    {
      this.c = new int[] { paramTypedArray.getColor(R.styleable.M, -1) };
      return;
    }
    this.c = paramContext.getResources().getIntArray(paramTypedArray.getResourceId(R.styleable.M, -1));
    if (this.c.length != 0) {
      return;
    }
    throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
  }
  
  private void b(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    if (paramTypedArray.hasValue(R.styleable.Q))
    {
      this.d = paramTypedArray.getColor(R.styleable.Q, -1);
      return;
    }
    this.d = this.c[0];
    paramContext = paramContext.getTheme().obtainStyledAttributes(new int[] { 16842803 });
    float f1 = paramContext.getFloat(0, 0.2F);
    paramContext.recycle();
    int i = (int)(f1 * 255.0F);
    this.d = MaterialColors.b(this.d, i);
  }
  
  public boolean a()
  {
    return this.e != 0;
  }
  
  public boolean b()
  {
    return this.f != 0;
  }
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */