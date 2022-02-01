package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.utils.ViewUtils;

public class FlingExitLayout
  extends ViewGroup
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private final Scroller jdField_a_of_type_AndroidWidgetScroller;
  private FlingExitLayout.OnGestureExitListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentFlingExitLayout$OnGestureExitListener;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private final int d;
  private int e;
  
  public FlingExitLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_b_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
    this.jdField_c_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
    this.d = paramContext.getScaledTouchSlop();
    this.jdField_a_of_type_Int = ViewUtils.a(50.0F);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = getScrollY();
    int j = this.e;
    int k = Math.abs(i);
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, i, 0, -(j - k), 200);
    invalidate();
    postDelayed(new FlingExitLayout.1(this, paramBoolean), 200L);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop() == 0)) {
      return true;
    }
    return false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) || (paramMotionEvent == null)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      a();
      return false;
    }
    int j;
    switch (i)
    {
    case 1: 
    default: 
      i = 0;
      j = 0;
    }
    label81:
    float f2;
    float f3;
    float f1;
    for (;;)
    {
      if ((j != 0) && (a()))
      {
        j = 1;
        if ((i == 0) && (j == 0)) {
          break;
        }
        return true;
        if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
        i = 0;
        j = 0;
        continue;
        f2 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
        f3 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
        if (f2 == 0.0F)
        {
          f1 = 1.0F;
          label172:
          f1 = Math.abs(f3 / f1);
          if ((f2 <= this.jdField_a_of_type_Int) || (f1 >= 0.5F)) {
            break label240;
          }
        }
      }
    }
    label240:
    for (i = 1;; i = 0)
    {
      if ((f3 > this.d) && (f1 > 2.0F))
      {
        j = 1;
        break;
        f1 = f2;
        break label172;
        j = 0;
        break label81;
      }
      j = 0;
      break;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    scrollTo(0, 0);
    int j = getChildCount();
    while (i < j)
    {
      getChildAt(i).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824)
    {
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (i != 1073741824) {
        break label86;
      }
    }
    for (;;)
    {
      int j = getChildCount();
      i = 0;
      while (i < j)
      {
        getChildAt(i).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        i += 1;
      }
      paramInt1 = getPaddingLeft() + getPaddingRight();
      break;
      label86:
      paramInt2 = getPaddingTop() + getPaddingBottom();
    }
    this.e = paramInt2;
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f1 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
      for (;;)
      {
        return true;
        f2 = getScrollY();
        f3 = this.jdField_c_of_type_Float;
        scrollTo(getScrollX(), (int)(f2 + f3 - f1));
        this.jdField_c_of_type_Float = f1;
      }
    }
    float f2 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getRawY();
    float f4 = this.jdField_b_of_type_Float;
    label131:
    int i;
    if (f2 == 0.0F)
    {
      f1 = 1.0F;
      f1 = Math.abs((f3 - f4) / f1);
      i = paramMotionEvent.getPointerId(0);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_c_of_type_Int);
      f3 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i);
      if ((f2 > this.jdField_a_of_type_Int) && (f1 < 0.5F) && (Math.abs(f3) > this.jdField_b_of_type_Int)) {
        a(false);
      }
      i = getScrollY();
      if (i <= 0) {
        break label254;
      }
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, i, 0, -i, 120);
      invalidate();
    }
    for (;;)
    {
      a();
      break;
      f1 = f2;
      break label131;
      label254:
      if (Math.abs(i) > 200)
      {
        a(true);
      }
      else
      {
        int j = -i;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, i, 0, j, 120);
        invalidate();
      }
    }
  }
  
  public void setListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
  }
  
  public void setOnGestureExitListener(FlingExitLayout.OnGestureExitListener paramOnGestureExitListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentFlingExitLayout$OnGestureExitListener = paramOnGestureExitListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.FlingExitLayout
 * JD-Core Version:    0.7.0.1
 */