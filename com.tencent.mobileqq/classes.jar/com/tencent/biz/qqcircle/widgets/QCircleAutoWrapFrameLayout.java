package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class QCircleAutoWrapFrameLayout
  extends FrameLayout
{
  protected int a = 0;
  protected int b = 0;
  protected SparseArray<ArrayList<View>> c = new SparseArray();
  
  public QCircleAutoWrapFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleAutoWrapFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.c.size();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < j)
    {
      ArrayList localArrayList = (ArrayList)this.c.get(paramInt1);
      if (localArrayList != null)
      {
        int k = localArrayList.size();
        paramInt3 = 0;
        int i = 0;
        paramInt4 = 0;
        while (paramInt3 < k)
        {
          View localView = (View)localArrayList.get(paramInt3);
          if (localView.getVisibility() == 0)
          {
            i = localView.getMeasuredHeight();
            int m = localView.getMeasuredWidth();
            localView.layout(paramInt4, paramInt2, paramInt4 + m, paramInt2 + i);
            paramInt4 += m + this.a;
          }
          paramInt3 += 1;
        }
        paramInt2 += i + this.b;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.c.clear();
    int m = getMeasuredWidth();
    int n = getChildCount();
    int k = 0;
    paramInt1 = 0;
    int i = 0;
    paramInt2 = 0;
    while (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 0)
      {
        int j = localView.getMeasuredWidth() + this.a;
        i += j;
        if (i > m)
        {
          paramInt2 += 1;
          i = j;
        }
        ArrayList localArrayList2 = (ArrayList)this.c.get(paramInt2);
        j = paramInt1;
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          this.c.append(paramInt2, localArrayList1);
          j = paramInt1 + (localView.getMeasuredHeight() + this.b);
        }
        localArrayList1.add(localView);
        paramInt1 = j;
      }
      k += 1;
    }
    i = this.b;
    paramInt2 = paramInt1;
    if (paramInt1 > i) {
      paramInt2 = paramInt1 - i;
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public void setSpace(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAutoWrapFrameLayout
 * JD-Core Version:    0.7.0.1
 */