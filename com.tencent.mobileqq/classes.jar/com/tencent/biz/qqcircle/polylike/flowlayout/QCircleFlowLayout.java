package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QCircleFlowLayout
  extends ViewGroup
{
  protected List<List<View>> a = new ArrayList();
  protected List<Integer> b = new ArrayList();
  protected List<Integer> c = new ArrayList();
  private int d;
  private List<View> e = new ArrayList();
  
  public QCircleFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.da);
    this.d = paramContext.getInt(R.styleable.dc, -1);
    this.d = -1;
    paramContext.recycle();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.e.clear();
    int j = getWidth();
    int k = getChildCount();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    while (paramInt3 < k)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        i = paramInt2;
        paramInt4 = paramInt1;
        if (n + paramInt2 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin > j - getPaddingLeft() - getPaddingRight())
        {
          this.b.add(Integer.valueOf(paramInt1));
          this.a.add(this.e);
          this.c.add(Integer.valueOf(paramInt2));
          paramInt4 = localMarginLayoutParams.topMargin + m + localMarginLayoutParams.bottomMargin;
          this.e = new ArrayList();
          i = 0;
        }
        paramInt2 = i + (n + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
        paramInt1 = Math.max(paramInt4, m + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin);
        this.e.add(localView);
      }
      paramInt3 += 1;
    }
    this.b.add(Integer.valueOf(paramInt1));
    this.c.add(Integer.valueOf(paramInt2));
    this.a.add(this.e);
    paramInt1 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    int i = this.a.size();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.e = ((List)this.a.get(paramInt2));
      k = ((Integer)this.b.get(paramInt2)).intValue();
      paramInt4 = ((Integer)this.c.get(paramInt2)).intValue();
      m = this.d;
      if (m != -1)
      {
        if (m != 0)
        {
          if (m == 1)
          {
            paramInt1 = j - (paramInt4 + getPaddingLeft()) - getPaddingRight();
            Collections.reverse(this.e);
          }
        }
        else {
          paramInt1 = (j - paramInt4) / 2 + getPaddingLeft();
        }
      }
      else {
        paramInt1 = getPaddingLeft();
      }
      paramInt4 = 0;
      while (paramInt4 < this.e.size())
      {
        localView = (View)this.e.get(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          m = localMarginLayoutParams.leftMargin + paramInt1;
          n = localMarginLayoutParams.topMargin + paramInt3;
          localView.layout(m, n, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + n);
          paramInt1 += localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        }
        paramInt4 += 1;
      }
      paramInt3 += k;
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i8 = getChildCount();
    int i3 = 0;
    int j = 0;
    int i2 = 0;
    int i1 = 0;
    int i = 0;
    while (i3 < i8)
    {
      View localView = getChildAt(i3);
      int n;
      int m;
      if (localView.getVisibility() == 8)
      {
        n = j;
        m = i;
        if (i3 == i8 - 1)
        {
          n = Math.max(i2, j);
          m = i + i1;
        }
        j = n;
        i = m;
      }
      else
      {
        measureChild(localView, paramInt1, paramInt2);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        m = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
        n = localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
        int i5 = i2 + m;
        if (i5 > i4 - getPaddingLeft() - getPaddingRight())
        {
          j = Math.max(j, i2);
          i2 = i + i1;
          i = n;
          i1 = j;
          n = i2;
        }
        else
        {
          i2 = Math.max(i1, n);
          m = i5;
          n = i;
          i1 = j;
          i = i2;
        }
        j = i1;
        i2 = n;
        if (i3 == i8 - 1)
        {
          j = Math.max(m, i1);
          i2 = n + i;
        }
        i1 = i;
        i = i2;
        i2 = m;
      }
      i3 += 1;
    }
    if (i7 == 1073741824)
    {
      paramInt1 = i4;
    }
    else
    {
      paramInt1 = getPaddingLeft();
      paramInt1 = getPaddingRight() + (j + paramInt1);
    }
    if (i6 != 1073741824) {
      k = i + getPaddingTop() + getPaddingBottom();
    }
    setMeasuredDimension(paramInt1, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout
 * JD-Core Version:    0.7.0.1
 */