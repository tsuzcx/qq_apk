package com.tencent.biz.qqstory.storyHome.tag;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import biby;
import wwz;
import wxe;

public class TagFlowLayout
  extends RelativeLayout
{
  private DataSetObserver a;
  protected BaseAdapter a;
  
  public TagFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TagFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TagFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    int j = getChildCount();
    int i = 0;
    if ((i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) && (i < j))
    {
      int k = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemViewType(i);
      View localView = getChildAt(i);
      if ((k == ((Integer)localView.getTag(2131373881)).intValue()) && (k == 0)) {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, localView, this);
      }
      for (;;)
      {
        i += 1;
        break;
        addView(this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, null, this), i, new ViewGroup.MarginLayoutParams(-2, -2));
        removeView(localView);
      }
    }
    if (j > this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) {
      removeViews(i, j - this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
    }
    if (j < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) {
      while (i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount())
      {
        addView(this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
        i += 1;
      }
    }
  }
  
  public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return (RelativeLayout.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    wxe.b("attach", "attach");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    wxe.b("detach", "detach");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    biby.a("TagFlowLayout.onLayout");
    int j = getWidth();
    paramInt3 = 0;
    paramInt2 = 0;
    int k = getChildCount();
    paramInt4 = 0;
    if (paramInt4 < k)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt4 += 1;
        paramInt2 = paramInt1;
        break;
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt2;
        int i = paramInt3;
        if (localMarginLayoutParams.leftMargin + paramInt3 + m + localMarginLayoutParams.rightMargin > j)
        {
          paramInt1 = paramInt2 + (localMarginLayoutParams.topMargin + n + localMarginLayoutParams.bottomMargin);
          i = 0;
        }
        paramInt2 = localMarginLayoutParams.leftMargin + i;
        paramInt3 = localMarginLayoutParams.topMargin + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + m, n + paramInt3);
        paramInt2 = localMarginLayoutParams.leftMargin;
        paramInt3 = i + (localMarginLayoutParams.rightMargin + (paramInt2 + m));
      }
    }
    biby.a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    biby.a("TagFlowLayout.onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int j = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    int i9 = getChildCount();
    int i4 = 0;
    while (i4 < i9)
    {
      Object localObject = getChildAt(i4);
      int n;
      if (((View)localObject).getVisibility() == 8)
      {
        n = m;
        m = k;
        k = n;
        i4 += 1;
        n = m;
        m = k;
        k = n;
      }
      else
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        int i1 = ((View)localObject).getMeasuredWidth();
        n = ((View)localObject).getMeasuredHeight();
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i1 = i1 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        int i2 = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        n = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + (n + i2);
        int i3;
        if (k + i1 > i6)
        {
          i3 = Math.max(k, i1);
          i2 = i + n;
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
      }
    }
    if (i8 == 1073741824) {
      j = i6;
    }
    if (i7 == 1073741824) {
      i = i5;
    }
    setMeasuredDimension(j, i);
    biby.a();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null)) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    removeAllViews();
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)
    {
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new wwz(this);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout
 * JD-Core Version:    0.7.0.1
 */