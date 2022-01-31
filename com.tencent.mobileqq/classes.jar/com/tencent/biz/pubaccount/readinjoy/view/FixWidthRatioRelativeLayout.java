package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R.styleable;

public class FixWidthRatioRelativeLayout
  extends RelativeLayout
{
  private float a = 1.0F;
  
  public FixWidthRatioRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  public FixWidthRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.FixWidthRatioRelativeLayout);
    this.a = (paramAttributeSet.getInteger(1, 1) / paramAttributeSet.getInteger(0, 1));
    paramAttributeSet.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) / this.a), 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.FixWidthRatioRelativeLayout
 * JD-Core Version:    0.7.0.1
 */