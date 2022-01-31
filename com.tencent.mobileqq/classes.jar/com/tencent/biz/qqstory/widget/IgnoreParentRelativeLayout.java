package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

public class IgnoreParentRelativeLayout
  extends RelativeLayout
{
  public IgnoreParentRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public IgnoreParentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    super.measureChild(paramView, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0));
  }
  
  protected void measureChildren(int paramInt1, int paramInt2)
  {
    super.measureChildren(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.IgnoreParentRelativeLayout
 * JD-Core Version:    0.7.0.1
 */