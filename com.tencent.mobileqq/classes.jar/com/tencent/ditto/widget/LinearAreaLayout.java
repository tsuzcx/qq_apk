package com.tencent.ditto.widget;

import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

public class LinearAreaLayout
  extends DittoAreaGroup
{
  private int mOrientation = 1;
  private int mTotalLength;
  
  public LinearAreaLayout(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    setOrientation(paramLayoutAttrSet.orientation);
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public void layoutHorizontal()
  {
    int m = getPaddingTop();
    int i = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getHeight();
    int k;
    int j;
    label64:
    LayoutAttrSet localLayoutAttrSet;
    int i3;
    int i4;
    switch (this.mGravity)
    {
    default: 
      i = 0;
      int i2 = getChildCount();
      k = 0;
      j = i;
      if (k < i2)
      {
        DittoArea localDittoArea = getChildAt(k);
        if (localDittoArea.getVisibility() == 8) {
          break label286;
        }
        localLayoutAttrSet = localDittoArea.getLayoutAttr();
        i3 = localDittoArea.getMeasuredWidth();
        i4 = localDittoArea.getMeasuredHeight();
        switch (localLayoutAttrSet.layout_gravity)
        {
        default: 
          i = localLayoutAttrSet.topMargin;
          label154:
          j += localLayoutAttrSet.leftMargin;
          localDittoArea.layout(j, i, j + i3, i4 + i);
        }
      }
      break;
    }
    label286:
    for (i = localLayoutAttrSet.rightMargin + i3 + j;; i = j)
    {
      k += 1;
      j = i;
      break label64;
      i = getWidth() + i - this.mTotalLength;
      break;
      i = (getWidth() - this.mTotalLength) / 2 + i;
      break;
      i = localLayoutAttrSet.topMargin;
      break label154;
      i = (i1 - m - n - i4) / 2 + localLayoutAttrSet.topMargin - localLayoutAttrSet.bottomMargin;
      break label154;
      i = i1 - n - i4 - localLayoutAttrSet.bottomMargin;
      break label154;
      return;
    }
  }
  
  public void layoutVertical()
  {
    getPaddingTop();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i1 = getWidth();
    int i;
    int k;
    label62:
    LayoutAttrSet localLayoutAttrSet;
    int i3;
    int j;
    switch (this.mGravity)
    {
    default: 
      i = 0;
      int i2 = getChildCount();
      k = 0;
      if (k < i2)
      {
        DittoArea localDittoArea = getChildAt(k);
        if (localDittoArea.getVisibility() == 8) {
          break label259;
        }
        localLayoutAttrSet = localDittoArea.getLayoutAttr();
        i3 = localDittoArea.getMeasuredWidth();
        int i4 = localDittoArea.getMeasuredHeight();
        switch (localLayoutAttrSet.layout_gravity)
        {
        default: 
          j = localLayoutAttrSet.leftMargin;
          label142:
          i += localLayoutAttrSet.topMargin;
          localDittoArea.layout(j, i, i3 + j, i + i4);
          i = localLayoutAttrSet.bottomMargin + i4 + i;
        }
      }
      break;
    }
    label259:
    for (;;)
    {
      k += 1;
      break label62;
      i = getHeight() - this.mTotalLength;
      break;
      i = (getHeight() - this.mTotalLength) / 2;
      break;
      j = (i1 - m - n - i3) / 2 + localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin;
      break label142;
      j = i1 - n - i3 - localLayoutAttrSet.rightMargin;
      break label142;
      return;
    }
  }
  
  public void measureChildrenHorizontal(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = ViewGroup.getChildMeasureSpec(paramInt2, 0, getLayoutAttr().height);
    int k = getChildCount();
    paramInt2 = 0;
    if (paramInt2 < k)
    {
      DittoArea localDittoArea = getChildAt(paramInt2);
      if (localDittoArea.getVisibility() == 8) {
        break label117;
      }
      LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
      measureChildWithMargins(localDittoArea, getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramInt1, i), 0, localLayoutAttrSet.width, localDittoArea), 0, j, 0);
      int m = localDittoArea.getMeasuredWidth();
      if ((paramInt1 <= 0) || (m <= 0)) {
        break label117;
      }
      paramInt1 -= m;
    }
    label117:
    for (;;)
    {
      paramInt2 += 1;
      break;
      return;
    }
  }
  
  public void measureHorizontal(int paramInt1, int paramInt2)
  {
    int j = 0;
    this.mTotalLength = 0;
    int m = getChildCount();
    measureChildrenHorizontal(paramInt1, paramInt2);
    int i = 0;
    while (i < m)
    {
      Object localObject = getChildAt(i);
      int k = j;
      if (((DittoArea)localObject).getVisibility() != 8)
      {
        k = ((DittoArea)localObject).getMeasuredWidth();
        int n = ((DittoArea)localObject).getMeasuredHeight();
        localObject = ((DittoArea)localObject).getLayoutAttr();
        int i1 = this.mTotalLength;
        int i2 = ((LayoutAttrSet)localObject).leftMargin;
        this.mTotalLength = (((LayoutAttrSet)localObject).rightMargin + (k + i2) + i1);
        k = Math.max(j, n);
      }
      i += 1;
      j = k;
    }
    setMeasuredDimension(resolveSize(this.mTotalLength, paramInt1), resolveSize(j, paramInt2));
  }
  
  public void measureVertical(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int k = getChildCount();
    int m = ViewGroup.getChildMeasureSpec(paramInt1, 0, getLayoutAttr().width);
    int n = ViewGroup.getChildMeasureSpec(paramInt2, 0, getLayoutAttr().height);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject = getChildAt(j);
      if (((DittoArea)localObject).getVisibility() == 8) {
        break label169;
      }
      measureChildWithMargins((DittoArea)localObject, m, 0, n, 0);
      int i1 = ((DittoArea)localObject).getMeasuredWidth();
      int i2 = ((DittoArea)localObject).getMeasuredHeight();
      localObject = ((DittoArea)localObject).getLayoutAttr();
      int i3 = this.mTotalLength;
      int i4 = ((LayoutAttrSet)localObject).topMargin;
      this.mTotalLength = (((LayoutAttrSet)localObject).bottomMargin + (i2 + i4) + i3);
      i = Math.max(i, i1);
    }
    label169:
    for (;;)
    {
      j += 1;
      break;
      setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(this.mTotalLength, paramInt2));
      return;
    }
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1)
    {
      layoutVertical();
      return;
    }
    layoutHorizontal();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.widget.LinearAreaLayout
 * JD-Core Version:    0.7.0.1
 */