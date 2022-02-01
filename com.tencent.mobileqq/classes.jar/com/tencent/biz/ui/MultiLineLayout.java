package com.tencent.biz.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class MultiLineLayout
  extends ViewGroup
{
  public static boolean a = true;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d = 0;
  private int e = -1;
  
  public MultiLineLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MultiLineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 5.0F));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    if (j > 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    this.d = paramInt1;
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt3 < j)
    {
      View localView = getChildAt(paramInt3);
      int i = this.e;
      if (((i == -1) || (this.d <= i)) && (localView.getVisibility() != 8))
      {
        localView.setVisibility(0);
        int m = localView.getMeasuredWidth();
        int k = localView.getMeasuredHeight();
        int n = paramInt4 + m;
        i = this.jdField_a_of_type_Int + n;
        float f;
        if (i <= this.b)
        {
          localView.layout(paramInt4, paramInt1, n, paramInt1 + k);
          f = Math.max(paramInt2, k + this.jdField_a_of_type_Float * 5.0F);
          paramInt2 = i;
        }
        for (;;)
        {
          i = (int)f;
          break;
          this.d += 1;
          paramInt4 = this.e;
          if ((paramInt4 != -1) && (this.d > paramInt4))
          {
            localView.setVisibility(8);
          }
          else
          {
            paramInt1 += paramInt2;
            localView.layout(0, paramInt1, m, paramInt1 + k);
          }
          paramInt2 = this.jdField_a_of_type_Int + m;
          f = k + this.jdField_a_of_type_Float * 5.0F;
        }
        paramInt4 = paramInt2;
        paramInt2 = i;
      }
      else
      {
        localView.setVisibility(8);
      }
      paramInt3 += 1;
    }
    this.c = (paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.b = View.MeasureSpec.getSize(paramInt1);
    measureChildren(paramInt1, paramInt2);
    int i1 = getChildCount();
    int k = 0;
    if (i1 > 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    this.d = paramInt1;
    paramInt1 = 0;
    int j = 0;
    paramInt2 = 0;
    int i = 0;
    while (k < i1)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() != 8)
      {
        int m = localView.getMeasuredHeight();
        int n = this.e;
        if ((n != -1) && (this.d > n)) {
          break;
        }
        j = localView.getMeasuredWidth();
        n = paramInt2 + j + this.jdField_a_of_type_Int;
        if (n <= this.b)
        {
          i = (int)Math.max(i, m + this.jdField_a_of_type_Float * 5.0F);
          j = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = n;
        }
        else
        {
          this.d += 1;
          n = this.e;
          if (n != -1)
          {
            paramInt2 = paramInt1;
            if (this.d > n) {}
          }
          else
          {
            paramInt2 = paramInt1 + i;
          }
          paramInt1 = this.jdField_a_of_type_Int + j;
          j = paramInt2;
          i = m;
        }
        n = paramInt2 + m;
        m = j;
        paramInt2 = paramInt1;
        j = n;
        paramInt1 = m;
      }
      k += 1;
    }
    setMeasuredDimension(this.b, j);
  }
  
  public void setShowLine(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.MultiLineLayout
 * JD-Core Version:    0.7.0.1
 */