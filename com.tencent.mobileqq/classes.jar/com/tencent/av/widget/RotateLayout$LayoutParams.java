package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.R.styleable;

public class RotateLayout$LayoutParams
  extends ViewGroup.LayoutParams
{
  public int a;
  
  public RotateLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RotateLayout);
    this.a = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public RotateLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.widget.RotateLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */