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
  @NonNull
  public int[] a;
  @Px
  public int b;
  @ColorInt
  public int c;
  public int d;
  public int e;
  
  protected BaseProgressIndicatorSpec(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    int i = paramContext.getResources().getDimensionPixelSize(R.dimen.ai);
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.e, paramInt1, paramInt2, new int[0]);
    this.jdField_a_of_type_Int = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.r, i);
    this.b = Math.min(MaterialResources.a(paramContext, paramAttributeSet, R.styleable.q, 0), this.jdField_a_of_type_Int / 2);
    this.d = paramAttributeSet.getInt(R.styleable.n, 0);
    this.e = paramAttributeSet.getInt(R.styleable.k, 0);
    a(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  private void a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    if (!paramTypedArray.hasValue(R.styleable.l))
    {
      this.jdField_a_of_type_ArrayOfInt = new int[] { MaterialColors.a(paramContext, R.attr.colorPrimary, -1) };
      return;
    }
    if (paramTypedArray.peekValue(R.styleable.l).type != 1)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[] { paramTypedArray.getColor(R.styleable.l, -1) };
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(paramTypedArray.getResourceId(R.styleable.l, -1));
    if (this.jdField_a_of_type_ArrayOfInt.length != 0) {
      return;
    }
    throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
  }
  
  private void b(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    if (paramTypedArray.hasValue(R.styleable.p))
    {
      this.c = paramTypedArray.getColor(R.styleable.p, -1);
      return;
    }
    this.c = this.jdField_a_of_type_ArrayOfInt[0];
    paramContext = paramContext.getTheme().obtainStyledAttributes(new int[] { 16842803 });
    float f = paramContext.getFloat(0, 0.2F);
    paramContext.recycle();
    int i = (int)(f * 255.0F);
    this.c = MaterialColors.b(this.c, i);
  }
  
  abstract void a();
  
  public boolean a()
  {
    return this.d != 0;
  }
  
  public boolean b()
  {
    return this.e != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicatorSpec
 * JD-Core Version:    0.7.0.1
 */