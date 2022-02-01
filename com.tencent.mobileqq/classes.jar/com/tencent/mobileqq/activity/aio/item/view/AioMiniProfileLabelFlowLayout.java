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
  
  protected void a()
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getWidth();
    int i2 = getChildCount();
    int j = 0;
    paramInt4 = 1;
    int i = 0;
    paramInt3 = 0;
    int k = 0;
    while (j < i2)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        paramInt1 = paramInt4;
        paramInt2 = paramInt3;
      }
      else
      {
        int i4 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        int n;
        if (paramInt4 == 1) {
          n = i1 - ViewUtils.dip2px(90.0F);
        } else {
          n = i1;
        }
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt4;
        int m = i;
        paramInt2 = paramInt3;
        if (localMarginLayoutParams.leftMargin + i + i4 + localMarginLayoutParams.rightMargin > n)
        {
          paramInt2 = paramInt3 + k;
          paramInt1 = paramInt4 + 1;
          m = 0;
        }
        paramInt3 = localMarginLayoutParams.topMargin;
        paramInt4 = localMarginLayoutParams.bottomMargin;
        i = localMarginLayoutParams.leftMargin + m;
        k = localMarginLayoutParams.topMargin + paramInt2;
        localView.layout(i, k, i + i4, i3 + k);
        i = m + (localMarginLayoutParams.leftMargin + i4 + localMarginLayoutParams.rightMargin);
        k = paramInt3 + i3 + paramInt4;
      }
      j += 1;
      paramInt4 = paramInt1;
      paramInt3 = paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i9 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i10 = getChildCount();
    int i3 = 0;
    int n = 1;
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    int k = 0;
    while (i3 < i10)
    {
      Object localObject = getChildAt(i3);
      if (((View)localObject).getVisibility() != 8)
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        int i5 = ((View)localObject).getMeasuredWidth();
        int i4 = ((View)localObject).getMeasuredHeight();
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        int i6 = i5 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        i5 = i4 + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        if (n == 1) {
          i4 = i - ViewUtils.dip2px(90.0F);
        } else {
          i4 = i;
        }
        int i7 = i1 + i6;
        if (i7 > i4)
        {
          n += 1;
          if (n > 2)
          {
            paramInt2 = Math.max(i1, i6);
            paramInt1 = j + i2;
            break label344;
          }
          i2 = Math.max(i1, i6);
          i1 = j + i5;
          k = i6;
          j = i5;
        }
        else
        {
          i4 = Math.max(i2, i5);
          i2 = k;
          i1 = j;
          j = i4;
          k = i7;
        }
        if (i3 == i10 - 1)
        {
          i2 = Math.max(k, i2);
          i4 = i1 + j;
          i1 = k;
          k = i2;
          i2 = j;
          j = i4;
        }
        else
        {
          i4 = k;
          i5 = j;
          k = i2;
          j = i1;
          i2 = i5;
          i1 = i4;
        }
      }
      i3 += 1;
    }
    paramInt1 = j;
    paramInt2 = k;
    label344:
    if (i9 == 1073741824) {
      paramInt2 = i;
    }
    if (i8 == 1073741824) {
      paramInt1 = m;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout
 * JD-Core Version:    0.7.0.1
 */