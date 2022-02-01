package com.tencent.mobileqq.activity.aio.item.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.troop.widget.FlowLayout;
import com.tencent.mobileqq.utils.ViewUtils;

public class AioMiniProfileLabelFlowLayout
  extends FlowLayout
{
  public AioMiniProfileLabelFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AioMiniProfileLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AioMiniProfileLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.a.getCount()) && (i < j))
    {
      View localView = getChildAt(i);
      this.a.getView(i, localView, this);
      i += 1;
    }
    if (j > this.a.getCount()) {
      removeViews(i, j - this.a.getCount());
    }
    if (j < this.a.getCount()) {
      while (i < this.a.getCount())
      {
        addView(this.a.getView(i, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
        i += 1;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getWidth();
    paramInt2 = 0;
    paramInt1 = 0;
    int m = getChildCount();
    paramInt4 = 0;
    paramInt3 = 1;
    int i = 0;
    View localView;
    int j;
    int i1;
    int n;
    label117:
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    for (;;)
    {
      if (i < m)
      {
        localView = getChildAt(i);
        if (localView.getVisibility() == 8)
        {
          j = paramInt4;
          paramInt4 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = j;
          j = i + 1;
          i = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = paramInt4;
          paramInt4 = i;
          i = j;
        }
        else
        {
          i1 = localView.getMeasuredWidth();
          n = localView.getMeasuredHeight();
          if (paramInt3 == 1)
          {
            j = k - ViewUtils.dip2px(90.0F);
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
            if (localMarginLayoutParams.leftMargin + paramInt2 + i1 + localMarginLayoutParams.rightMargin <= j) {
              break label275;
            }
            j = paramInt3 + 1;
            paramInt2 = paramInt1 + paramInt4;
            paramInt3 = 0;
            paramInt1 = j;
          }
        }
      }
    }
    for (;;)
    {
      int i2 = localMarginLayoutParams.topMargin;
      int i3 = localMarginLayoutParams.bottomMargin;
      paramInt4 = localMarginLayoutParams.leftMargin + paramInt3;
      j = localMarginLayoutParams.topMargin + paramInt2;
      localView.layout(paramInt4, j, paramInt4 + i1, n + j);
      j = localMarginLayoutParams.leftMargin;
      int i4 = localMarginLayoutParams.rightMargin;
      paramInt4 = paramInt1;
      j = i4 + (j + i1) + paramInt3;
      paramInt1 = i2 + n + i3;
      paramInt3 = paramInt4;
      paramInt4 = j;
      break;
      j = k;
      break label117;
      return;
      label275:
      paramInt4 = paramInt1;
      j = paramInt2;
      paramInt1 = paramInt3;
      paramInt2 = paramInt4;
      paramInt3 = j;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    int j = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i11 = getChildCount();
    int k = 1;
    int i7 = 0;
    int i1;
    int i2;
    int i3;
    for (;;)
    {
      if (i7 < i11)
      {
        Object localObject = getChildAt(i7);
        if (((View)localObject).getVisibility() == 8)
        {
          i1 = n;
          n = m;
          m = i1;
          i7 += 1;
          i1 = n;
          n = m;
          m = i1;
        }
        else
        {
          measureChild((View)localObject, paramInt1, paramInt2);
          i2 = ((View)localObject).getMeasuredWidth();
          i1 = ((View)localObject).getMeasuredHeight();
          localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          i3 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + (i2 + i3);
          i2 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + i1 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          if (k == 1)
          {
            i1 = i6 - ViewUtils.dip2px(90.0F);
            label195:
            if (m + i3 <= i1) {
              break label337;
            }
            i1 = k + 1;
            if (i1 <= 2) {
              break label264;
            }
            paramInt2 = Math.max(m, i3);
            paramInt1 = i + n;
          }
        }
      }
    }
    for (;;)
    {
      if (i10 == 1073741824) {
        paramInt2 = i6;
      }
      if (i9 == 1073741824) {
        paramInt1 = i8;
      }
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i1 = i6;
      break label195;
      label264:
      int i5 = Math.max(m, i3);
      int i4 = i + i2;
      for (;;)
      {
        k = i1;
        m = i2;
        n = i3;
        i = i4;
        j = i5;
        if (i7 != i11 - 1) {
          break;
        }
        j = Math.max(i3, i5);
        i = i4 + i2;
        k = i1;
        m = i2;
        n = i3;
        break;
        label337:
        i2 = Math.max(n, i2);
        i3 = m + i3;
        i1 = k;
        i4 = i;
        i5 = j;
      }
      paramInt1 = i;
      paramInt2 = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout
 * JD-Core Version:    0.7.0.1
 */