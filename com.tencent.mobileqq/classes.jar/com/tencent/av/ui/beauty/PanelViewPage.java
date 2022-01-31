package com.tencent.av.ui.beauty;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;

public class PanelViewPage
  extends ViewPager
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  
  public PanelViewPage(Context paramContext)
  {
    super(paramContext);
  }
  
  public PanelViewPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Boolean) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int i;
    if ((j == 0) && (this.jdField_a_of_type_Int > 0)) {
      i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824);
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = paramInt1;
      if (j == 1073741824)
      {
        i = paramInt1;
        if (k > 0)
        {
          this.jdField_a_of_type_Int = k;
          i = paramInt1;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.jdField_a_of_type_Boolean) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setIsPagingEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.beauty.PanelViewPage
 * JD-Core Version:    0.7.0.1
 */