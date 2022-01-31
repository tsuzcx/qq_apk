package com.tencent.biz.pubaccount.readinjoy.view;

import actj;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Adapter;
import bfps;
import com.tencent.widget.AdapterView;
import rcs;

public class ReadInJoyFlowLayout
  extends AdapterView
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = actj.a(8.0F, getResources());
  private Adapter jdField_a_of_type_AndroidWidgetAdapter;
  private bfps jdField_a_of_type_Bfps = new rcs(this);
  private float b;
  
  public ReadInJoyFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private View a(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  private void a()
  {
    removeAllViewsInLayout();
    if (this.jdField_a_of_type_AndroidWidgetAdapter != null)
    {
      int j = this.jdField_a_of_type_AndroidWidgetAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetAdapter.getView(i, null, this);
        addViewInLayout(localView, i, localView.getLayoutParams());
        i += 1;
      }
    }
    invalidate();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(super.generateDefaultLayoutParams());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  public Adapter getAdapter()
  {
    return this.jdField_a_of_type_AndroidWidgetAdapter;
  }
  
  public View getSelectedView()
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      View localView = a(i);
      if (localView.isSelected()) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int i7 = getPaddingRight();
    paramInt4 = getPaddingTop();
    int j = i + i7;
    paramInt2 = i;
    int k = 0;
    int i3 = 0;
    View localView;
    int m;
    int n;
    int i9;
    int i10;
    int i5;
    int i4;
    int i1;
    int i2;
    label220:
    int i8;
    int i6;
    for (;;)
    {
      if (i3 < getCount())
      {
        localView = a(i3);
        if (localView.getVisibility() == 8)
        {
          m = k;
          n = j;
          k = paramInt2;
          j = paramInt4;
          paramInt4 = n;
          paramInt2 = m;
          i3 += 1;
          m = k;
          n = j;
          k = paramInt2;
          j = paramInt4;
          paramInt4 = n;
          paramInt2 = m;
        }
        else
        {
          i9 = localView.getMeasuredWidth();
          i10 = localView.getMeasuredHeight();
          Object localObject = localView.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
            i5 = localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
            i4 = localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
            n = paramInt2 + localMarginLayoutParams.leftMargin;
            i1 = paramInt4 + localMarginLayoutParams.topMargin;
            i2 = localMarginLayoutParams.leftMargin + paramInt2 + i9;
            m = localMarginLayoutParams.topMargin + paramInt4 + i10;
            i8 = i5 + i9;
            i6 = i4 + i10;
            if (j + i8 <= paramInt3 - paramInt1) {
              break label472;
            }
            paramInt2 = paramInt4 + k;
            paramInt4 = i + i7;
            if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
              break label437;
            }
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            n = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            k = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            j = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            m = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramInt2 + i10;
            j = j + i + i9;
            k = paramInt2 + k;
            i1 = i + n;
            n = i;
            i4 = 0;
            i2 = paramInt4;
            paramInt4 = i4;
          }
        }
      }
    }
    for (;;)
    {
      localView.layout(i1, k, j, m);
      j = paramInt4;
      if (i6 > paramInt4) {
        j = i6;
      }
      k = i2 + i8;
      paramInt4 = j;
      j = paramInt2;
      m = n + i8;
      paramInt2 = paramInt4;
      paramInt4 = k;
      k = m;
      break;
      i2 = paramInt2 + i9;
      m = paramInt4 + i10;
      i4 = 0;
      i5 = 0;
      i1 = paramInt4;
      n = paramInt2;
      break label220;
      label437:
      j = i + i9;
      m = paramInt2 + i10;
      k = paramInt2;
      i1 = i;
      i2 = paramInt4;
      n = i;
      paramInt4 = 0;
      continue;
      return;
      label472:
      i4 = paramInt4;
      paramInt4 = k;
      k = i1;
      i5 = paramInt2;
      paramInt2 = j;
      j = i2;
      i1 = n;
      i2 = paramInt2;
      paramInt2 = i4;
      n = i5;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    int k = getPaddingTop();
    int i6 = getPaddingBottom();
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int m = 0;
    int j = 0;
    int i = i4 + i5;
    View localView;
    int i1;
    int n;
    label159:
    int i8;
    for (;;)
    {
      if (m < getCount())
      {
        localView = a(m);
        if (localView.getVisibility() == 8)
        {
          m += 1;
        }
        else
        {
          i1 = 0;
          n = 0;
          Object localObject = localView.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            measureChildWithMargins(localView, paramInt1, 0, paramInt2, k);
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            i1 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
            n = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            n = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + n;
            i8 = localView.getMeasuredWidth();
            int i9 = localView.getMeasuredHeight();
            i8 = i1 + i8;
            i1 = n + i9;
            if (i + i8 <= i3) {
              break label286;
            }
            k += j;
            n = i4 + i5;
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i1 > j) {}
      for (i = i1;; i = j)
      {
        n = i8 + n;
        j = i;
        i = n;
        break;
        measureChild(localView, paramInt1, paramInt2);
        break label159;
        if (i7 == 1073741824) {}
        for (paramInt1 = i2;; paramInt1 = k + j + i6)
        {
          setMeasuredDimension(i3, paramInt1);
          return;
        }
      }
      label286:
      n = i;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    switch (paramMotionEvent.getAction())
    {
    }
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.b = paramMotionEvent.getX();
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      f3 = f2 - this.jdField_a_of_type_Float;
      f4 = f1 - this.b;
    } while (f3 * f3 + f4 * f4 > this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
    int i2 = getChildCount();
    int i = 0;
    label108:
    int j = i1;
    int n;
    int m;
    int k;
    if (i < i2)
    {
      paramMotionEvent = getChildAt(i);
      if (!(paramMotionEvent.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label260;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams();
      n = localMarginLayoutParams.leftMargin;
      m = localMarginLayoutParams.rightMargin;
      k = localMarginLayoutParams.topMargin;
      j = localMarginLayoutParams.bottomMargin;
    }
    for (;;)
    {
      if ((paramMotionEvent.getLeft() - n < f1) && (m + paramMotionEvent.getRight() > f1) && (paramMotionEvent.getTop() - k < f2) && (j + paramMotionEvent.getBottom() > f2))
      {
        performItemClick(paramMotionEvent, i, i);
        j = 1;
        if (j != 0) {
          break;
        }
        performClick();
        return true;
      }
      i += 1;
      break label108;
      label260:
      j = 0;
      k = 0;
      m = 0;
      n = 0;
    }
  }
  
  public void setAdapter(Adapter paramAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetAdapter != null) && (this.jdField_a_of_type_Bfps != null)) {
      this.jdField_a_of_type_AndroidWidgetAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Bfps);
    }
    this.jdField_a_of_type_AndroidWidgetAdapter = paramAdapter;
    if (this.jdField_a_of_type_AndroidWidgetAdapter != null)
    {
      this.mItemCount = this.jdField_a_of_type_AndroidWidgetAdapter.getCount();
      this.jdField_a_of_type_AndroidWidgetAdapter.registerDataSetObserver(this.jdField_a_of_type_Bfps);
      a();
    }
  }
  
  public void setRangeSelection(int paramInt1, int paramInt2)
  {
    int i = getCount();
    if ((paramInt1 < 0) || (paramInt2 > i)) {
      throw new IllegalArgumentException("invalid begin or end index");
    }
    while (paramInt1 < paramInt2)
    {
      a(paramInt1).setSelected(true);
      paramInt1 += 1;
    }
  }
  
  public void setSelection(int paramInt)
  {
    int i = getCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      a(paramInt).setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout
 * JD-Core Version:    0.7.0.1
 */