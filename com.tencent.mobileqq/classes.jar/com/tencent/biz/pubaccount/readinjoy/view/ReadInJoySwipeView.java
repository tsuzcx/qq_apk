package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoySwipeView
  extends RelativeLayout
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ReadInJoySwipeView.OnSlidingFinishListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoySwipeView.class.getSimpleName();
  }
  
  public ReadInJoySwipeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public ReadInJoySwipeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setFocusable(true);
    setClickable(true);
  }
  
  public ReadInJoySwipeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setFocusable(true);
    setClickable(true);
  }
  
  private void a()
  {
    int i = ScreenUtil.jdField_a_of_type_Int + getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, -i + 1, 0, Math.abs(i));
    postInvalidate();
  }
  
  private void b()
  {
    int i = getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, -i, 0, Math.abs(i) / 2);
    postInvalidate();
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener != null) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      float f = paramMotionEvent.getRawX();
      this.c = f;
      this.jdField_a_of_type_Float = f;
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent.getAction() == 2)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = this.jdField_a_of_type_Float;
      paramMotionEvent.getRawY();
      float f3 = this.jdField_b_of_type_Float;
      bool1 = bool2;
      if (Math.abs(f1 - f2) > this.jdField_a_of_type_Int) {
        bool1 = true;
      }
    }
    try
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "IllegalArgumentException.", paramMotionEvent);
    }
    return bool1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    int i = paramMotionEvent.getAction();
    if (i == 2)
    {
      float f3 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
      float f4 = paramMotionEvent.getRawY();
      float f5 = this.jdField_b_of_type_Float;
      float f2 = this.c - paramMotionEvent.getRawX();
      this.c = paramMotionEvent.getRawX();
      if ((this.jdField_a_of_type_Boolean) || ((Math.abs(f3) > Math.abs((f4 - f5) * 1.2D)) && (f3 > 0.0F)))
      {
        this.jdField_a_of_type_Boolean = true;
        i = getScrollX();
        if (i + f2 < 0.0F) {
          f1 = i + f2;
        }
        scrollTo((int)f1, 0);
        return true;
      }
    }
    else if ((i == 1) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      if (getScrollX() > -ScreenUtil.jdField_a_of_type_Int / 4) {
        break label178;
      }
      this.jdField_b_of_type_Boolean = true;
      a();
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        label178:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "IllegalArgumentException.", paramMotionEvent);
      }
      b();
      this.jdField_b_of_type_Boolean = false;
    }
    return false;
  }
  
  public void setOnSlidingFinishListener(ReadInJoySwipeView.OnSlidingFinishListener paramOnSlidingFinishListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener = paramOnSlidingFinishListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySwipeView
 * JD-Core Version:    0.7.0.1
 */