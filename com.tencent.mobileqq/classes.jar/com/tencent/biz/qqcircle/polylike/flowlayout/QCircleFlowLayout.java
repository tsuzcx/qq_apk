package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.text.TextUtilsCompat;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QCircleFlowLayout
  extends ViewGroup
{
  private int a;
  protected List<List<View>> a;
  protected List<Integer> b = new ArrayList();
  protected List<Integer> c = new ArrayList();
  private List<View> d = new ArrayList();
  
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
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleTagFlowLayout);
    this.jdField_a_of_type_Int = paramContext.getInt(1, -1);
    if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
      if (this.jdField_a_of_type_Int != -1) {
        break label98;
      }
    }
    label98:
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = -1)
    {
      paramContext.recycle();
      return;
    }
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
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    int j = getWidth();
    paramInt2 = 0;
    paramInt1 = 0;
    int k = getChildCount();
    paramInt3 = 0;
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    if (paramInt3 < k)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        paramInt3 += 1;
        break;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        paramInt4 = paramInt1;
        i = paramInt2;
        if (n + paramInt2 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin > j - getPaddingLeft() - getPaddingRight())
        {
          this.b.add(Integer.valueOf(paramInt1));
          this.jdField_a_of_type_JavaUtilList.add(this.d);
          this.c.add(Integer.valueOf(paramInt2));
          i = 0;
          paramInt4 = localMarginLayoutParams.topMargin + m + localMarginLayoutParams.bottomMargin;
          this.d = new ArrayList();
        }
        paramInt2 = i + (n + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
        paramInt1 = localMarginLayoutParams.topMargin;
        paramInt1 = Math.max(paramInt4, localMarginLayoutParams.bottomMargin + (paramInt1 + m));
        this.d.add(localView);
      }
    }
    this.b.add(Integer.valueOf(paramInt1));
    this.c.add(Integer.valueOf(paramInt2));
    this.jdField_a_of_type_JavaUtilList.add(this.d);
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int i = this.jdField_a_of_type_JavaUtilList.size();
    paramInt3 = 0;
    while (paramInt3 < i)
    {
      this.d = ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt3));
      k = ((Integer)this.b.get(paramInt3)).intValue();
      paramInt4 = ((Integer)this.c.get(paramInt3)).intValue();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        paramInt4 = 0;
        label439:
        if (paramInt4 >= this.d.size()) {
          break label614;
        }
        localView = (View)this.d.get(paramInt4);
        if (localView.getVisibility() != 8) {
          break;
        }
      }
      for (;;)
      {
        paramInt4 += 1;
        break label439;
        paramInt1 = getPaddingLeft();
        break;
        paramInt1 = (j - paramInt4) / 2 + getPaddingLeft();
        break;
        paramInt1 = j - (paramInt4 + getPaddingLeft()) - getPaddingRight();
        Collections.reverse(this.d);
        break;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        m = localMarginLayoutParams.leftMargin + paramInt1;
        n = localMarginLayoutParams.topMargin + paramInt2;
        localView.layout(m, n, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + n);
        paramInt1 += localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      }
      label614:
      paramInt3 += 1;
      paramInt2 += k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int j = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    int i9 = getChildCount();
    int i4 = 0;
    View localView;
    int n;
    if (i4 < i9)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8)
      {
        if (i4 != i9 - 1) {
          break label358;
        }
        j = Math.max(k, j);
        i += m;
        n = m;
        m = k;
        k = n;
      }
    }
    for (;;)
    {
      i4 += 1;
      n = m;
      m = k;
      k = n;
      break;
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      n = localView.getMeasuredHeight();
      int i2 = localMarginLayoutParams.topMargin;
      n = localMarginLayoutParams.bottomMargin + (n + i2);
      int i3;
      if (k + i1 > i6 - getPaddingLeft() - getPaddingRight())
      {
        i3 = Math.max(j, k);
        i2 = i + m;
      }
      for (;;)
      {
        k = n;
        m = i1;
        i = i2;
        j = i3;
        if (i4 != i9 - 1) {
          break;
        }
        j = Math.max(i1, i3);
        i = i2 + n;
        k = n;
        m = i1;
        break;
        n = Math.max(m, n);
        i1 = k + i1;
        i2 = i;
        i3 = j;
      }
      if (i8 == 1073741824)
      {
        paramInt1 = i6;
        if (i7 != 1073741824) {
          break label343;
        }
      }
      label343:
      for (paramInt2 = i5;; paramInt2 = getPaddingTop() + i + getPaddingBottom())
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        paramInt1 = getPaddingLeft() + j + getPaddingRight();
        break;
      }
      label358:
      n = k;
      k = m;
      m = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout
 * JD-Core Version:    0.7.0.1
 */