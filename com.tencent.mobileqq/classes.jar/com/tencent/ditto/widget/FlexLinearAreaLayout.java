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
    if ((this.shrinkColumns < 0) || (this.shrinkColumns >= getChildCount())) {
      super.measureHorizontal(paramInt1, paramInt2);
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    if (m <= 0) {
      super.measureHorizontal(paramInt1, paramInt2);
    }
    measureChildrenHorizontal(paramInt1, paramInt2);
    int i2 = getChildCount();
    int i = 0;
    int j = m;
    paramInt1 = 0;
    Object localObject;
    int k;
    if (i < i2)
    {
      localObject = getChildAt(i);
      if (((DittoArea)localObject).getVisibility() == 8) {
        break label297;
      }
      int i3 = ((DittoArea)localObject).getMeasuredWidth();
      int n = Math.max(paramInt1, ((DittoArea)localObject).getMeasuredHeight());
      k = j;
      paramInt1 = n;
      if (this.shrinkColumns != i)
      {
        localObject = ((DittoArea)localObject).getLayoutAttr();
        paramInt1 = ((LayoutAttrSet)localObject).leftMargin;
        k = j - (((LayoutAttrSet)localObject).rightMargin + (paramInt1 + i3));
        paramInt1 = n;
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      localObject = getChildAt(this.shrinkColumns);
      if (localObject == null) {
        return;
      }
      if ((localObject != null) && (((DittoArea)localObject).getVisibility() != 8))
      {
        LayoutAttrSet localLayoutAttrSet = ((DittoArea)localObject).getLayoutAttr();
        if (((DittoArea)localObject).getMeasuredWidth() + localLayoutAttrSet.leftMargin + localLayoutAttrSet.rightMargin > j)
        {
          i = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(j - localLayoutAttrSet.leftMargin - localLayoutAttrSet.rightMargin, i1), getPaddingLeft() + getPaddingRight(), localLayoutAttrSet.width);
          ((DittoArea)localObject).setMeasureDirty(true);
          measureChildWithMargins((DittoArea)localObject, i, 0, paramInt2, 0);
          ((DittoArea)localObject).setMeasureDirty(false);
        }
      }
      setMeasuredDimension(m, resolveSize(paramInt1, paramInt2));
      return;
      label297:
      k = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ditto.widget.FlexLinearAreaLayout
 * JD-Core Version:    0.7.0.1
 */