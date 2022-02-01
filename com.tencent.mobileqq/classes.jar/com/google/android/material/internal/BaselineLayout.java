package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
  extends ViewGroup
{
  private int a = -1;
  
  public BaselineLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int i = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        int i2 = (paramInt3 - paramInt1 - m - k - n) / 2 + k;
        if ((this.a != -1) && (localView.getBaseline() != -1)) {
          paramInt4 = this.a + i - localView.getBaseline();
        } else {
          paramInt4 = i;
        }
        localView.layout(i2, paramInt4, n + i2, i1 + paramInt4);
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getChildCount();
    int i3 = 0;
    int k = -1;
    int j = -1;
    int i = 0;
    int i2 = 0;
    int i1 = 0;
    while (i3 < i4)
    {
      View localView = getChildAt(i3);
      if (localView.getVisibility() != 8)
      {
        measureChild(localView, paramInt1, paramInt2);
        int i5 = localView.getBaseline();
        m = k;
        int n = j;
        if (i5 != -1)
        {
          m = Math.max(k, i5);
          n = Math.max(j, localView.getMeasuredHeight() - i5);
        }
        i2 = Math.max(i2, localView.getMeasuredWidth());
        i = Math.max(i, localView.getMeasuredHeight());
        i1 = View.combineMeasuredStates(i1, localView.getMeasuredState());
        j = n;
        k = m;
      }
      i3 += 1;
    }
    int m = i;
    if (k != -1)
    {
      m = Math.max(i, Math.max(j, getPaddingBottom()) + k);
      this.a = k;
    }
    i = Math.max(m, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i2, getSuggestedMinimumWidth()), paramInt1, i1), View.resolveSizeAndState(i, paramInt2, i1 << 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.BaselineLayout
 * JD-Core Version:    0.7.0.1
 */