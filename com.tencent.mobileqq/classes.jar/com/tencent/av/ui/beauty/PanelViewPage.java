package com.tencent.av.ui.beauty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.ViewPager;

public class PanelViewPage
  extends ViewPager
{
  private int jdField_a_of_type_Int = 0;
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    if (j == 0)
    {
      i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        break label60;
      }
    }
    int i = paramInt1;
    if (j == 1073741824)
    {
      i = paramInt1;
      if (k > 0)
      {
        this.jdField_a_of_type_Int = k;
        i = paramInt1;
      }
    }
    label60:
    super.onMeasure(i, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.PanelViewPage
 * JD-Core Version:    0.7.0.1
 */