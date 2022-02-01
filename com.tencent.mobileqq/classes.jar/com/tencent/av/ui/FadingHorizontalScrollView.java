package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class FadingHorizontalScrollView
  extends HorizontalScrollView
{
  private int a = 1;
  
  public FadingHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FadingHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FadingHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected float getRightFadingEdgeStrength()
  {
    if (this.a != 1) {
      return super.getRightFadingEdgeStrength();
    }
    return 0.0F;
  }
  
  public void setFadingMode(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.FadingHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */