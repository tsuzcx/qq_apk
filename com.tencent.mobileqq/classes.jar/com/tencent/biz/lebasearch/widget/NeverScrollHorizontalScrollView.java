package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class NeverScrollHorizontalScrollView
  extends HorizontalScrollView
{
  public NeverScrollHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NeverScrollHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NeverScrollHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.NeverScrollHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */