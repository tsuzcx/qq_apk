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
    int m = 0;
    int i = paramInt6;
    paramInt6 = paramInt4;
    LayoutAttrSet localLayoutAttrSet;
    int i3;
    if (m < paramInt1)
    {
      DittoArea localDittoArea = getChildAt(m);
      if (localDittoArea.getVisibility() == 8) {
        break label306;
      }
      localLayoutAttrSet = localDittoArea.getLayoutAttr();
      int i2 = localDittoArea.getMeasuredWidth();
      i3 = localDittoArea.getMeasuredHeight();
      switch (localLayoutAttrSet.layout_gravity)
      {
      default: 
        paramInt4 = localLayoutAttrSet.topMargin;
        label103:
        int i4 = localDittoArea.getWeight();
        int i1 = 0;
        int n = i1;
        int j = paramInt5;
        int k = paramInt6;
        if (i4 > 0)
        {
          n = i1;
          j = paramInt5;
          k = paramInt6;
          if (paramInt6 > 0)
          {
            n = i1;
            j = paramInt5;
            k = paramInt6;
            if (paramInt5 > 0)
            {
              n = i4 * paramInt5 / paramInt6;
              k = paramInt6 - i4;
              j = paramInt5 - n;
            }
          }
        }
        paramInt5 = i + localLayoutAttrSet.leftMargin;
        localDittoArea.layout(paramInt5, paramInt4, paramInt5 + i2 + n, i3 + paramInt4);
        paramInt4 = i2 + n + localLayoutAttrSet.rightMargin + paramInt5;
        paramInt6 = k;
        paramInt5 = j;
      }
    }
    for (;;)
    {
      m += 1;
      i = paramInt4;
      break;
      paramInt4 = localLayoutAttrSet.topMargin;
      break label103;
      paramInt4 = (paramInt2 - i3) / 2 + localLayoutAttrSet.topMargin - localLayoutAttrSet.bottomMargin;
      break label103;
      paramInt4 = paramInt3 - i3 - localLayoutAttrSet.bottomMargin;
      break label103;
      return;
      label306:
      paramInt4 = i;
    }
  }
  
  private void layoutChildVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int m = 0;
    int i = paramInt5;
    paramInt5 = paramInt4;
    paramInt4 = i;
    LayoutAttrSet localLayoutAttrSet;
    int i2;
    if (m < paramInt1)
    {
      DittoArea localDittoArea = getChildAt(m);
      if (localDittoArea.getVisibility() == 8) {
        break label288;
      }
      localLayoutAttrSet = localDittoArea.getLayoutAttr();
      i2 = localDittoArea.getMeasuredWidth();
      int i3 = localDittoArea.getMeasuredHeight();
      switch (localLayoutAttrSet.layout_gravity)
      {
      default: 
        i = localLayoutAttrSet.leftMargin;
        label99:
        int i4 = localDittoArea.getWeight();
        int i1 = 0;
        int n = i1;
        int j = paramInt4;
        int k = paramInt5;
        if (i4 > 0)
        {
          n = i1;
          j = paramInt4;
          k = paramInt5;
          if (paramInt5 > 0)
          {
            n = i1;
            j = paramInt4;
            k = paramInt5;
            if (paramInt4 > 0)
            {
              n = i4 * paramInt4 / paramInt5;
              k = paramInt5 - i4;
              j = paramInt4 - n;
            }
          }
        }
        paramInt4 = paramInt6 + localLayoutAttrSet.topMargin;
        localDittoArea.layout(i, paramInt4, i2 + i, paramInt4 + i3 + n);
        paramInt6 = i3 + n + localLayoutAttrSet.bottomMargin + paramInt4;
        paramInt5 = k;
        paramInt4 = j;
      }
    }
    label288:
    for (;;)
    {
      m += 1;
      break;
      i = (paramInt2 - i2) / 2 + localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin;
      break label99;
      i = paramInt3 - i2 - localLayoutAttrSet.rightMargin;
      break label99;
      return;
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
    int n = 0;
    int i1 = getPaddingTop();
    getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getHeight();
    int j = this.mTotalLength;
    int i4 = getWidth() - j;
    int i5 = getChildCount();
    int i;
    if (i4 > 0)
    {
      int k = 0;
      int m;
      for (i = 0; k < i5; i = m)
      {
        int i6 = getChildAt(k).getWeight();
        m = i;
        if (i6 > 0) {
          m = i + i6;
        }
        k += 1;
      }
      if (i > 0) {
        j = getWidth();
      }
    }
    for (;;)
    {
      switch (this.mGravity)
      {
      default: 
        j = n;
      }
      for (;;)
      {
        layoutChildHorizontal(i5, i3 - i1 - i2, i3 - i2, i, i4, j);
        return;
        j = getWidth() - j;
        continue;
        j = (getWidth() - j) / 2;
      }
      continue;
      i = 0;
    }
  }
  
  public void layoutVertical()
  {
    int n = 0;
    getPaddingTop();
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getWidth();
    int j = this.mTotalLength;
    int i4 = getHeight() - j;
    int i5 = getChildCount();
    int i;
    if (i4 > 0)
    {
      int k = 0;
      int m;
      for (i = 0; k < i5; i = m)
      {
        int i6 = getChildAt(k).getWeight();
        m = i;
        if (i6 > 0) {
          m = i + i6;
        }
        k += 1;
      }
      if (i > 0) {
        j = getHeight();
      }
    }
    for (;;)
    {
      switch (this.mGravity)
      {
      default: 
        j = n;
      }
      for (;;)
      {
        layoutChildVertical(i5, i3 - i1 - i2, i3 - i2, i, i4, j);
        return;
        j = getHeight() - j;
        continue;
        j = (getHeight() - j) / 2;
      }
      continue;
      i = 0;
    }
  }
  
  public void measureChildrenHorizontal(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = ViewGroup.getChildMeasureSpec(paramInt2, 0, getLayoutAttr().height);
    int m = getChildCount();
    paramInt2 = 0;
    if (paramInt2 < m)
    {
      DittoArea localDittoArea = getChildAt(paramInt2);
      if (localDittoArea.getVisibility() == 8) {
        break label137;
      }
      LayoutAttrSet localLayoutAttrSet = localDittoArea.getLayoutAttr();
      measureChildWithMargins(localDittoArea, getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramInt1, j), 0, localLayoutAttrSet.width, localDittoArea), 0, k, 0);
      int i = localDittoArea.getMeasuredWidth();
      if ((paramInt1 <= 0) || (i <= 0)) {
        break label137;
      }
      i = paramInt1 - i;
      paramInt1 = i;
      if (localLayoutAttrSet != null) {
        paramInt1 = i - localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin;
      }
    }
    label137:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.LinearAreaLayout
 * JD-Core Version:    0.7.0.1
 */