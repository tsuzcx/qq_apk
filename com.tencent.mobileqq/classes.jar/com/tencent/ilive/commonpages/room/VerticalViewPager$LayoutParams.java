package com.tencent.ilive.commonpages.room;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class VerticalViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  int childIndex;
  public int gravity;
  float heightFactor = 0.0F;
  public boolean isDecor;
  boolean needsMeasure;
  int position;
  
  public VerticalViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public VerticalViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, VerticalViewPager.access$400());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */