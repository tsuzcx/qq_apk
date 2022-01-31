package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class QCircleMultiPicViewPager
  extends ViewPager
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float b;
  
  public QCircleMultiPicViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleMultiPicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
  }
  
  public boolean a()
  {
    return getAdapter().getCount() > 1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (getCurrentItem() == 0) {}
    }
    while (getCurrentItem() != getAdapter().getCount() - 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.b = paramMotionEvent.getRawY();
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      }
    }
    float f2 = paramMotionEvent.getRawY();
    float f1 = Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float);
    f2 = Math.abs(f2 - this.b);
    return (f1 > this.jdField_a_of_type_Int) || (f2 > this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMultiPicViewPager
 * JD-Core Version:    0.7.0.1
 */