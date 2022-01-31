package com.tencent.biz.pubaccount.readinjoy.viola;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import rjq;
import rjr;

public class ViolaGestureLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  public static int g = 500;
  public static int h = 300;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  private rjq jdField_a_of_type_Rjq;
  private rjr jdField_a_of_type_Rjr;
  float b;
  private float c;
  private int i;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
  }
  
  public ViolaGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViolaGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViolaGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getScrollY();
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(0);
    if (QLog.isColorLevel()) {
      QLog.d("ViolaGestureLayout", 2, "closeOrSpringBack judge deltaY:" + j + ",velocityY:" + f1 + ",mCanCloseFromBottom:" + this.jdField_a_of_type_JavaLangBoolean + " , mStateBottomTime " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", mInterceptDeltaY " + this.jdField_c_of_type_Float);
    }
    if (((j < -g) && (f1 > -100.0F)) || ((j < -50) && (f1 >= 2800.0F)))
    {
      this.jdField_a_of_type_Rjq.a(true, j);
      return;
    }
    if (((j > h) || (f1 < -6500.0F)) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (f1 < 100.0F) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L) && (this.jdField_c_of_type_Float < 0.0F) && (this.jdField_a_of_type_Rjr.a()))
    {
      this.jdField_a_of_type_Rjq.a(false, j);
      return;
    }
    a(0, 0, 200);
    this.i = jdField_a_of_type_Int;
    this.jdField_a_of_type_Rjq.a(this.i);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    while (this.i == f) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getScrollX();
    int k = this.jdField_a_of_type_AndroidViewView.getScrollY();
    if ((!this.jdField_a_of_type_Rjr.a()) && (((k > 0) && (k < h)) || (k >= h)))
    {
      this.i = f;
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      postInvalidate();
      return;
    }
    if ((k < 0) && (k > -g))
    {
      this.i = jdField_b_of_type_Int;
      if (((!b()) || (this.jdField_c_of_type_Float <= 0.0F)) && ((!a()) || (this.jdField_c_of_type_Float >= 0.0F) || (!this.jdField_a_of_type_Rjr.a()))) {
        break label271;
      }
      this.i = f;
      this.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      postInvalidate();
    }
    for (;;)
    {
      this.jdField_a_of_type_Rjq.a(this.i);
      return;
      if (k <= -g)
      {
        this.i = jdField_c_of_type_Int;
        break;
      }
      if ((k > 0) && (k < h))
      {
        this.i = d;
        break;
      }
      if (k < h) {
        break;
      }
      this.i = e;
      break;
      label271:
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, k, paramInt1 - j, paramInt2 - k, paramInt3);
      invalidate();
    }
  }
  
  private boolean a()
  {
    return (this.i == jdField_c_of_type_Int) || (this.i == jdField_b_of_type_Int);
  }
  
  private boolean b()
  {
    return (this.i == e) || (this.i == d);
  }
  
  public boolean a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Rjr != null) && (paramMotionEvent.getAction() != 0))
    {
      int j = this.jdField_a_of_type_Rjr.a();
      this.jdField_a_of_type_Rjq.b(j);
      if ((j == 1) && (paramFloat > 0.0F)) {
        this.jdField_a_of_type_Long = 0L;
      }
      do
      {
        return true;
        if ((j != 2) || (paramFloat >= 0.0F) || (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
          break;
        }
      } while (this.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return true;
      if ((!this.jdField_a_of_type_Rjr.a()) && (paramFloat < -10.0F))
      {
        this.jdField_a_of_type_Long = 0L;
        return true;
      }
      this.jdField_a_of_type_Long = 0L;
      return false;
    }
    return false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller == null) {
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
        postInvalidate();
        return;
      }
    } while ((this.jdField_a_of_type_AndroidViewView.getScrollY() != 0) || (this.i == jdField_a_of_type_Int));
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaGestureLayout.1(this), 32L);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    if (this.jdField_b_of_type_Float != 0.0F) {
      f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
    }
    this.jdField_c_of_type_Float = f1;
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    return a(this.jdField_c_of_type_Float, paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (this.jdField_b_of_type_Float != 0.0F) {}
    for (float f1 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;; f1 = 0.0F)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        a();
        return true;
      }
    }
    int j = (int)(this.jdField_a_of_type_AndroidViewView.getScrollY() - f1);
    if (f1 != 0.0F) {
      a(0, j, 0);
    }
    return true;
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public void setViolaContainer(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setViolaGestureListener(rjq paramrjq)
  {
    this.jdField_a_of_type_Rjq = paramrjq;
  }
  
  public void setViolaMaterListListener(rjr paramrjr)
  {
    this.jdField_a_of_type_Rjr = paramrjr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaGestureLayout
 * JD-Core Version:    0.7.0.1
 */