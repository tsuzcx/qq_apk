package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c;
  
  public FlowLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public FlowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != -2147483648)
    {
      if (paramInt2 != 1073741824) {
        return paramInt3;
      }
      return paramInt1;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  private void a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.B, 0, 0);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.bX, 0);
    this.b = paramContext.getDimensionPixelSize(R.styleable.bW, 0);
    paramContext.recycle();
  }
  
  protected int a()
  {
    return this.c;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b(@NonNull View paramView)
  {
    paramView = paramView.getTag(R.id.Z);
    if (!(paramView instanceof Integer)) {
      return -1;
    }
    return ((Integer)paramView).intValue();
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0)
    {
      this.c = 0;
      return;
    }
    this.c = 1;
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    }
    if (i != 0) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int k = getPaddingTop();
    int i2 = paramInt3 - paramInt1 - paramInt4;
    paramInt3 = paramInt2;
    paramInt1 = k;
    int j = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        localView.setTag(R.id.Z, Integer.valueOf(-1));
      }
      else
      {
        Object localObject = localView.getLayoutParams();
        int n;
        int m;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          n = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)localObject);
          m = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)localObject);
        }
        else
        {
          m = 0;
          n = 0;
        }
        int i3 = localView.getMeasuredWidth();
        int i1 = paramInt3;
        paramInt4 = paramInt1;
        if (!this.jdField_a_of_type_Boolean)
        {
          i1 = paramInt3;
          paramInt4 = paramInt1;
          if (paramInt3 + n + i3 > i2)
          {
            paramInt4 = k + this.jdField_a_of_type_Int;
            this.c += 1;
            i1 = paramInt2;
          }
        }
        localView.setTag(R.id.Z, Integer.valueOf(this.c - 1));
        paramInt1 = i1 + n;
        paramInt3 = localView.getMeasuredWidth() + paramInt1;
        k = localView.getMeasuredHeight() + paramInt4;
        if (i != 0) {
          localView.layout(i2 - paramInt3, paramInt4, i2 - i1 - n, k);
        } else {
          localView.layout(paramInt1, paramInt4, paramInt3, k);
        }
        paramInt3 = i1 + (n + m + localView.getMeasuredWidth() + this.b);
        paramInt1 = paramInt4;
      }
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getSize(paramInt2);
    int i10 = View.MeasureSpec.getMode(paramInt2);
    int n;
    if ((i8 != -2147483648) && (i8 != 1073741824)) {
      n = 2147483647;
    } else {
      n = i7;
    }
    int k = getPaddingLeft();
    int i = getPaddingTop();
    int i11 = getPaddingRight();
    int j = i;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    i = m;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        Object localObject = localView.getLayoutParams();
        int i2;
        int i3;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          i2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + 0;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + 0;
        }
        else
        {
          i2 = 0;
          i3 = 0;
        }
        int i12 = localView.getMeasuredWidth();
        int i6 = k;
        m = j;
        int i5 = i6;
        if (k + i2 + i12 > n - i11)
        {
          m = j;
          i5 = i6;
          if (!a())
          {
            i5 = getPaddingLeft();
            m = this.jdField_a_of_type_Int + i4;
          }
        }
        k = i5 + i2 + localView.getMeasuredWidth();
        i4 = localView.getMeasuredHeight();
        j = i;
        if (k > i) {
          j = k;
        }
        k = localView.getMeasuredWidth();
        i6 = this.b;
        i = j;
        if (i1 == getChildCount() - 1) {
          i = j + i3;
        }
        i4 += m;
        k = i5 + (i2 + i3 + k + i6);
        j = m;
      }
      i1 += 1;
    }
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingBottom();
    setMeasuredDimension(a(i7, i8, i + paramInt1), a(i9, i10, i4 + paramInt2));
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.FlowLayout
 * JD-Core Version:    0.7.0.1
 */