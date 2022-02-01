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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.TraceUtils;

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
  
  protected void a()
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) && (i < j))
    {
      int k = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemViewType(i);
      View localView = getChildAt(i);
      if ((k == ((Integer)localView.getTag(2131374617)).intValue()) && (k == 0))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, localView, this);
      }
      else
      {
        addView(this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, null, this), i, new ViewGroup.MarginLayoutParams(-2, -2));
        removeView(localView);
      }
      i += 1;
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
    SLog.b("attach", "attach");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SLog.b("detach", "detach");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceUtils.traceBegin("TagFlowLayout.onLayout");
    int j = getWidth();
    int k = getChildCount();
    paramInt4 = 0;
    paramInt2 = 0;
    for (paramInt3 = 0; paramInt4 < k; paramInt3 = paramInt1)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8)
      {
        paramInt1 = paramInt3;
      }
      else
      {
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt3;
        int i = paramInt2;
        if (localMarginLayoutParams.leftMargin + paramInt2 + m + localMarginLayoutParams.rightMargin > j)
        {
          paramInt1 = paramInt3 + (localMarginLayoutParams.topMargin + n + localMarginLayoutParams.bottomMargin);
          i = 0;
        }
        paramInt2 = localMarginLayoutParams.leftMargin + i;
        paramInt3 = localMarginLayoutParams.topMargin + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + m, n + paramInt3);
        paramInt2 = i + (localMarginLayoutParams.leftMargin + m + localMarginLayoutParams.rightMargin);
      }
      paramInt4 += 1;
    }
    TraceUtils.traceEnd();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    TraceUtils.traceBegin("TagFlowLayout.onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i8 = getChildCount();
    int i3 = 0;
    int j = 0;
    int n = 0;
    int m = 0;
    int i2;
    for (int i = 0; i3 < i8; i = i2)
    {
      Object localObject = getChildAt(i3);
      if (((View)localObject).getVisibility() == 8)
      {
        i2 = i;
      }
      else
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        i2 = ((View)localObject).getMeasuredWidth();
        int i1 = ((View)localObject).getMeasuredHeight();
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i2 = i2 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        int i5 = i1 + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        i1 = n + i2;
        if (i1 > i4)
        {
          j = Math.max(n, i2);
          i1 = i + i5;
          n = i2;
          m = i5;
        }
        else
        {
          m = Math.max(m, i5);
          n = i1;
          i1 = i;
        }
        i = j;
        i2 = i1;
        if (i3 == i8 - 1)
        {
          i = Math.max(n, j);
          i2 = i1 + m;
        }
        j = i;
      }
      i3 += 1;
    }
    if (i7 == 1073741824) {
      paramInt1 = i4;
    } else {
      paramInt1 = j;
    }
    if (i6 == 1073741824) {
      i = k;
    }
    setMeasuredDimension(paramInt1, i);
    TraceUtils.traceEnd();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    BaseAdapter localBaseAdapter = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    if (localBaseAdapter != null)
    {
      DataSetObserver localDataSetObserver = this.jdField_a_of_type_AndroidDatabaseDataSetObserver;
      if (localDataSetObserver != null) {
        localBaseAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    removeAllViews();
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)
    {
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new TagFlowLayout.AdapterDataSetObserver(this);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout
 * JD-Core Version:    0.7.0.1
 */