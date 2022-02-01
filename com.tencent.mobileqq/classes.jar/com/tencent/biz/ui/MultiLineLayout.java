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
  int b;
  private int c;
  private int d;
  private int e = 0;
  private int f = -1;
  private float g;
  
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
    this.g = paramContext.getResources().getDisplayMetrics().density;
    this.b = ((int)(this.g * 5.0F));
  }
  
  public int getLineCount()
  {
    return this.e;
  }
  
  public int getShowLine()
  {
    return this.f;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    if (j > 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    this.e = paramInt1;
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt3 < j)
    {
      View localView = getChildAt(paramInt3);
      int i = this.f;
      if (((i == -1) || (this.e <= i)) && (localView.getVisibility() != 8))
      {
        localView.setVisibility(0);
        int m = localView.getMeasuredWidth();
        int k = localView.getMeasuredHeight();
        int n = paramInt4 + m;
        i = this.b + n;
        float f1;
        if (i <= this.c)
        {
          localView.layout(paramInt4, paramInt1, n, paramInt1 + k);
          f1 = Math.max(paramInt2, k + this.g * 5.0F);
          paramInt2 = i;
        }
        for (;;)
        {
          i = (int)f1;
          break;
          this.e += 1;
          paramInt4 = this.f;
          if ((paramInt4 != -1) && (this.e > paramInt4))
          {
            localView.setVisibility(8);
          }
          else
          {
            paramInt1 += paramInt2;
            localView.layout(0, paramInt1, m, paramInt1 + k);
          }
          paramInt2 = this.b + m;
          f1 = k + this.g * 5.0F;
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
    this.d = (paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.c = View.MeasureSpec.getSize(paramInt1);
    measureChildren(paramInt1, paramInt2);
    int i1 = getChildCount();
    int k = 0;
    if (i1 > 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    this.e = paramInt1;
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
        int n = this.f;
        if ((n != -1) && (this.e > n)) {
          break;
        }
        j = localView.getMeasuredWidth();
        n = paramInt2 + j + this.b;
        if (n <= this.c)
        {
          i = (int)Math.max(i, m + this.g * 5.0F);
          j = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = n;
        }
        else
        {
          this.e += 1;
          n = this.f;
          if (n != -1)
          {
            paramInt2 = paramInt1;
            if (this.e > n) {}
          }
          else
          {
            paramInt2 = paramInt1 + i;
          }
          paramInt1 = this.b + j;
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
    setMeasuredDimension(this.c, j);
  }
  
  public void setShowLine(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.MultiLineLayout
 * JD-Core Version:    0.7.0.1
 */