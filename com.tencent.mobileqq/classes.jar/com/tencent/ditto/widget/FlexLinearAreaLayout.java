package com.tencent.ditto.widget;

import android.view.View.MeasureSpec;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

public class FlexLinearAreaLayout
  extends LinearAreaLayout
{
  private int shrinkColumns = -1;
  private int stretchColumns = -1;
  
  public FlexLinearAreaLayout(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    if (paramLayoutAttrSet.hasAttr("shrinkColumns")) {
      this.shrinkColumns = paramLayoutAttrSet.getAttr("shrinkColumns", -1);
    }
    if (paramLayoutAttrSet.hasAttr("stretchColumns")) {
      this.stretchColumns = paramLayoutAttrSet.getAttr("stretchColumns", -1);
    }
  }
  
  public void measureHorizontal(int paramInt1, int paramInt2)
  {
    int i = this.shrinkColumns;
    if ((i < 0) || (i >= getChildCount())) {
      super.measureHorizontal(paramInt1, paramInt2);
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    if (n <= 0) {
      super.measureHorizontal(paramInt1, paramInt2);
    }
    measureChildrenHorizontal(paramInt1, paramInt2);
    int i2 = getChildCount();
    paramInt1 = n;
    i = 0;
    int j = 0;
    while (i < i2)
    {
      localObject = getChildAt(i);
      int k = j;
      int m = paramInt1;
      if (((DittoArea)localObject).getVisibility() != 8)
      {
        int i3 = ((DittoArea)localObject).getMeasuredWidth();
        j = Math.max(j, ((DittoArea)localObject).getMeasuredHeight());
        k = j;
        m = paramInt1;
        if (this.shrinkColumns != i)
        {
          localObject = ((DittoArea)localObject).getLayoutAttr();
          m = paramInt1 - (i3 + ((LayoutAttrSet)localObject).leftMargin + ((LayoutAttrSet)localObject).rightMargin);
          k = j;
        }
      }
      i += 1;
      j = k;
      paramInt1 = m;
    }
    Object localObject = getChildAt(this.shrinkColumns);
    if (localObject == null) {
      return;
    }
    if ((localObject != null) && (((DittoArea)localObject).getVisibility() != 8))
    {
      LayoutAttrSet localLayoutAttrSet = ((DittoArea)localObject).getLayoutAttr();
      if (((DittoArea)localObject).getMeasuredWidth() + localLayoutAttrSet.leftMargin + localLayoutAttrSet.rightMargin > paramInt1)
      {
        paramInt1 = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramInt1 - localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin, i1), getPaddingLeft() + getPaddingRight(), localLayoutAttrSet.width);
        ((DittoArea)localObject).setMeasureDirty(true);
        measureChildWithMargins((DittoArea)localObject, paramInt1, 0, paramInt2, 0);
        ((DittoArea)localObject).setMeasureDirty(false);
      }
    }
    setMeasuredDimension(n, resolveSize(j, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.widget.FlexLinearAreaLayout
 * JD-Core Version:    0.7.0.1
 */