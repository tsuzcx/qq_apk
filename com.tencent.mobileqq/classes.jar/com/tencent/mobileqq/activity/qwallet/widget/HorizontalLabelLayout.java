package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class HorizontalLabelLayout
  extends ViewGroup
{
  private int mHorizontalSpacing;
  private int mVerticalSpacing;
  
  public HorizontalLabelLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalLabelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int i2 = getPaddingRight();
    int i3 = getChildCount();
    int m = 0;
    paramInt4 = 0;
    int i = 1;
    int j = 0;
    View localView;
    int n;
    int i4;
    for (;;)
    {
      if (m < i3)
      {
        localView = getChildAt(m);
        if (localView.getVisibility() == 8)
        {
          n = j;
          j = i;
          i = paramInt4;
          m += 1;
          paramInt4 = i;
          i = j;
          j = n;
        }
        else
        {
          i4 = localView.getMeasuredWidth();
          n = localView.getMeasuredHeight();
          j = Math.max(n, j);
          if (i != 0)
          {
            if (m <= 0) {
              break label220;
            }
            paramInt2 = this.mVerticalSpacing + paramInt2 + j;
            paramInt4 = n;
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      label144:
      int i1 = i + i4;
      if (i1 + i4 + i2 > paramInt3 - paramInt1) {}
      for (j = 1;; j = 0)
      {
        localView.layout(i, paramInt2, i4 + i, n + paramInt2);
        i = i1;
        n = paramInt4;
        break;
        i = paramInt4 + this.mHorizontalSpacing;
        paramInt4 = j;
        break label144;
      }
      return;
      label220:
      i = k;
      paramInt4 = j;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = resolveSize(0, paramInt1);
    int i4 = getPaddingLeft();
    int i1 = getPaddingTop();
    int i5 = getPaddingRight();
    int i6 = getPaddingBottom();
    int i7 = getChildCount();
    int j = 0;
    int n = 0;
    int m = 0;
    int k = 1;
    int i = i1;
    if (m < i7)
    {
      View localView = getChildAt(m);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localView.measure(getChildMeasureSpec(paramInt1, i4 + i5, localLayoutParams.width), getChildMeasureSpec(paramInt2, i1 + i6, localLayoutParams.height));
      int i2 = localView.getMeasuredWidth();
      n = Math.max(localView.getMeasuredHeight(), n);
      if (k != 0)
      {
        j = i4 + i2 + i5;
        if (m == 0)
        {
          k = i + n;
          i = j;
          j = k;
          label159:
          if (i + i2 <= i3) {
            break label240;
          }
        }
      }
      label240:
      for (k = 1;; k = 0)
      {
        i2 = m + 1;
        m = i;
        i = j;
        j = m;
        m = i2;
        break;
        k = i + n + this.mVerticalSpacing;
        i = j;
        j = k;
        break label159;
        int i8 = this.mHorizontalSpacing;
        k = i;
        i = j + i2 + i8;
        j = k;
        break label159;
      }
    }
    setMeasuredDimension(i3, resolveSize(i + i6, paramInt2));
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    this.mHorizontalSpacing = paramInt;
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    this.mVerticalSpacing = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.HorizontalLabelLayout
 * JD-Core Version:    0.7.0.1
 */