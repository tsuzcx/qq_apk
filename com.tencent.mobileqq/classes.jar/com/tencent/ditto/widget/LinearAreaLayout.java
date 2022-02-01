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
  private int mGravity = 3;
  private int mOrientation = 1;
  private int mTotalLength;
  
  public LinearAreaLayout(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    setOrientation(paramLayoutAttrSet.orientation);
    setGravity(paramLayoutAttrSet.gravity);
  }
  
  private void layoutChildHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt4;
    int j = 0;
    paramInt4 = paramInt5;
    paramInt5 = i;
    i = j;
    j = paramInt6;
    while (i < paramInt1)
    {
      DittoArea localDittoArea = getChildAt(i);
      int m = j;
      int k = paramInt5;
      paramInt6 = paramInt4;
      if (localDittoArea.getVisibility() != 8)
      {
        LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
        m = localDittoArea.getMeasuredWidth();
        int n = localDittoArea.getMeasuredHeight();
        paramInt6 = localLayoutAttrSet.layout_gravity;
        if (paramInt6 != 16)
        {
          if (paramInt6 != 48)
          {
            if (paramInt6 != 80)
            {
              paramInt6 = localLayoutAttrSet.topMargin;
              break label172;
            }
            paramInt6 = paramInt3 - n;
            k = localLayoutAttrSet.bottomMargin;
          }
          else
          {
            paramInt6 = localLayoutAttrSet.topMargin;
            break label172;
          }
        }
        else
        {
          paramInt6 = (paramInt2 - n) / 2 + localLayoutAttrSet.topMargin;
          k = localLayoutAttrSet.bottomMargin;
        }
        paramInt6 -= k;
        label172:
        int i1 = localDittoArea.getWeight();
        if ((i1 > 0) && (paramInt5 > 0) && (paramInt4 > 0))
        {
          k = i1 * paramInt4 / paramInt5;
          paramInt5 -= i1;
          paramInt4 -= k;
        }
        else
        {
          k = 0;
        }
        j += localLayoutAttrSet.leftMargin;
        localDittoArea.layout(j, paramInt6, j + m + k, n + paramInt6);
        m = j + (m + k + localLayoutAttrSet.rightMargin);
        paramInt6 = paramInt4;
        k = paramInt5;
      }
      i += 1;
      j = m;
      paramInt5 = k;
      paramInt4 = paramInt6;
    }
  }
  
  private void layoutChildVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt6;
    paramInt6 = paramInt4;
    int j = 0;
    paramInt4 = paramInt5;
    paramInt5 = paramInt6;
    paramInt6 = j;
    while (paramInt6 < paramInt1)
    {
      DittoArea localDittoArea = getChildAt(paramInt6);
      int m = i;
      int k = paramInt5;
      j = paramInt4;
      if (localDittoArea.getVisibility() != 8)
      {
        LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
        m = localDittoArea.getMeasuredWidth();
        int n = localDittoArea.getMeasuredHeight();
        j = localLayoutAttrSet.layout_gravity;
        if (j != 1)
        {
          if (j != 5)
          {
            j = localLayoutAttrSet.leftMargin;
            break label153;
          }
          j = paramInt3 - m;
          k = localLayoutAttrSet.rightMargin;
        }
        else
        {
          j = (paramInt2 - m) / 2 + localLayoutAttrSet.leftMargin;
          k = localLayoutAttrSet.rightMargin;
        }
        j -= k;
        label153:
        int i1 = localDittoArea.getWeight();
        if ((i1 > 0) && (paramInt5 > 0) && (paramInt4 > 0))
        {
          k = i1 * paramInt4 / paramInt5;
          paramInt5 -= i1;
          paramInt4 -= k;
        }
        else
        {
          k = 0;
        }
        i += localLayoutAttrSet.topMargin;
        localDittoArea.layout(j, i, m + j, i + n + k);
        m = i + (n + k + localLayoutAttrSet.bottomMargin);
        j = paramInt4;
        k = paramInt5;
      }
      paramInt6 += 1;
      i = m;
      paramInt5 = k;
      paramInt4 = j;
    }
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public void layoutHorizontal()
  {
    int n = getPaddingTop();
    getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = getHeight();
    int j = this.mTotalLength;
    int i3 = getWidth() - j;
    int i4 = getChildCount();
    int k;
    if (i3 > 0)
    {
      k = 0;
      int m;
      for (i = 0; k < i4; i = m)
      {
        int i5 = getChildAt(k).getWeight();
        m = i;
        if (i5 > 0) {
          m = i + i5;
        }
        k += 1;
      }
      if (i > 0) {
        j = getWidth();
      }
      k = i;
    }
    else
    {
      k = 0;
    }
    int i = this.mGravity;
    if (i != 1) {
      if (i != 5)
      {
        if (i != 17)
        {
          i = 0;
          break label152;
        }
      }
      else
      {
        i = getWidth() - j;
        break label152;
      }
    }
    i = (getWidth() - j) / 2;
    label152:
    layoutChildHorizontal(i4, i2 - n - i1, i2 - i1, k, i3, i);
  }
  
  public void layoutVertical()
  {
    getPaddingTop();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    int i2 = getWidth();
    int j = this.mTotalLength;
    int i3 = getHeight() - j;
    int i4 = getChildCount();
    int k;
    if (i3 > 0)
    {
      k = 0;
      int m;
      for (i = 0; k < i4; i = m)
      {
        int i5 = getChildAt(k).getWeight();
        m = i;
        if (i5 > 0) {
          m = i + i5;
        }
        k += 1;
      }
      if (i > 0) {
        j = getHeight();
      }
      k = i;
    }
    else
    {
      k = 0;
    }
    int i = this.mGravity;
    if ((i != 16) && (i != 17))
    {
      if (i != 80) {
        i = 0;
      } else {
        i = getHeight() - j;
      }
    }
    else {
      i = (getHeight() - j) / 2;
    }
    layoutChildVertical(i4, i2 - n - i1, i2 - i1, k, i3, i);
  }
  
  public void measureChildrenHorizontal(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = ViewGroup.getChildMeasureSpec(paramInt2, 0, getLayoutAttr().height);
    int m = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      DittoArea localDittoArea = getChildAt(paramInt2);
      paramInt1 = i;
      if (localDittoArea.getVisibility() != 8)
      {
        LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
        measureChildWithMargins(localDittoArea, getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(i, j), 0, localLayoutAttrSet.width, localDittoArea), 0, k, 0);
        int n = localDittoArea.getMeasuredWidth();
        paramInt1 = i;
        if (i > 0)
        {
          paramInt1 = i;
          if (n > 0)
          {
            i -= n;
            paramInt1 = i;
            if (localLayoutAttrSet != null) {
              paramInt1 = i - localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin;
            }
          }
        }
      }
      paramInt2 += 1;
      i = paramInt1;
    }
  }
  
  public void measureHorizontal(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.mTotalLength = 0;
    int m = getChildCount();
    measureChildrenHorizontal(paramInt1, paramInt2);
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = getChildAt(i);
      k = j;
      if (((DittoArea)localObject).getVisibility() != 8)
      {
        k = ((DittoArea)localObject).getMeasuredWidth();
        int n = ((DittoArea)localObject).getMeasuredHeight();
        localObject = ((DittoArea)localObject).getLayoutAttr();
        this.mTotalLength += k + ((LayoutAttrSet)localObject).leftMargin + ((LayoutAttrSet)localObject).rightMargin;
        k = Math.max(j, n);
      }
      i += 1;
    }
    setMeasuredDimension(resolveSize(this.mTotalLength, paramInt1), resolveSize(j, paramInt2));
  }
  
  public void measureVertical(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.mTotalLength = 0;
    int m = getChildCount();
    int n = ViewGroup.getChildMeasureSpec(paramInt1, 0, getLayoutAttr().width);
    int i1 = ViewGroup.getChildMeasureSpec(paramInt2, 0, getLayoutAttr().height);
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = getChildAt(i);
      k = j;
      if (((DittoArea)localObject).getVisibility() != 8)
      {
        measureChildWithMargins((DittoArea)localObject, n, 0, i1, 0);
        k = ((DittoArea)localObject).getMeasuredWidth();
        int i2 = ((DittoArea)localObject).getMeasuredHeight();
        localObject = ((DittoArea)localObject).getLayoutAttr();
        this.mTotalLength += i2 + ((LayoutAttrSet)localObject).topMargin + ((LayoutAttrSet)localObject).bottomMargin;
        k = Math.max(j, k);
      }
      i += 1;
    }
    setMeasuredDimension(resolveSize(j, paramInt1), resolveSize(this.mTotalLength, paramInt2));
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
  
  public void setGravity(int paramInt)
  {
    super.setGravity(paramInt);
    if (this.mGravity != paramInt)
    {
      this.mGravity = paramInt;
      requestLayout();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.widget.LinearAreaLayout
 * JD-Core Version:    0.7.0.1
 */