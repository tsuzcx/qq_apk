package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSDragLayout
  extends LinearLayout
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private WSDragLayout.TouchListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = 0.0F;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = false;
  private boolean f = false;
  
  public WSDragLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WSDragLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WSDragLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    this.jdField_b_of_type_Int = j;
    return j / 4;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    a();
  }
  
  private void a(float paramFloat)
  {
    boolean bool = true;
    float f1 = -(paramFloat - this.jdField_d_of_type_Float);
    float f2 = a(f1);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null) && (this.jdField_b_of_type_Int > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a(Math.abs(getScrollY() + f2) / this.jdField_b_of_type_Int);
    }
    WSDragLayout.TouchListener localTouchListener;
    if ((this.jdField_c_of_type_Boolean) && (f2 != 0.0F))
    {
      scrollBy(0, (int)f2);
      if (Math.abs(f1) > 5.0F) {
        this.e = true;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null)
      {
        localTouchListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
        if (getScrollY() <= 0) {
          break label142;
        }
      }
    }
    for (;;)
    {
      localTouchListener.a(bool);
      this.jdField_d_of_type_Float = paramFloat;
      return;
      if (f2 <= 0.0F) {
        break;
      }
      scrollBy(0, (int)f2);
      break;
      label142:
      bool = false;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (!this.e) {
      return true;
    }
    paramMotionEvent.setAction(3);
    super.dispatchTouchEvent(paramMotionEvent);
    int i;
    if ((Math.sqrt(Math.pow(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float, 2.0D) + Math.pow(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float, 2.0D)) < a()) || (getScrollY() >= 0) || (Math.abs(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float) < ScreenUtil.dip2px(5.0F)))
    {
      i = 1;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      if (i == 0) {
        break label132;
      }
      a(0);
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label132:
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null)
      {
        this.f = true;
        a(-this.jdField_b_of_type_Int);
      }
    }
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      return false;
      i = (int)paramMotionEvent.getRawY();
      j = (int)paramMotionEvent.getRawX();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      k = paramMotionEvent[0];
      m = paramMotionEvent[1];
      n = paramView.getMeasuredWidth();
      i1 = paramView.getMeasuredHeight();
    } while ((i < m) || (i > i1 + m) || (j < k) || (j > n + k));
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_b_of_type_Boolean = false;
    }
    if (((this.jdField_a_of_type_AndroidWidgetListView != null) && (this.jdField_a_of_type_AndroidWidgetListView.canScrollVertically(-1))) || (paramMotionEvent.getRawY() < this.jdField_c_of_type_Float))
    {
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      if (getScrollY() == 0) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    while (this.jdField_b_of_type_Boolean) {
      return true;
    }
    this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
    return false;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean) {
      return true;
    }
    if ((!this.jdField_d_of_type_Boolean) || (a(paramView, paramMotionEvent)))
    {
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public float a(float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    for (float f1 = 0.0F;; f1 = 20.0F)
    {
      i = AIOUtils.a(f1, getContext().getResources());
      if ((int)(getScrollY() + paramFloat) >= i) {
        break;
      }
      return paramFloat;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a();
    }
    return i - getScrollY();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller != null)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller != null) && (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      WSLog.a("WSDragLayout", "scrollY = " + this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() + "; dis = " + this.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null) && (this.jdField_b_of_type_Int > 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a(Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getCurrY()) / this.jdField_b_of_type_Int);
      }
      invalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.f);
      this.f = false;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener == null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a(1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a(this.jdField_a_of_type_Int);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!b(getChildAt(0), paramMotionEvent)) && (this.jdField_a_of_type_Int != 1)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (b(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return false;
      this.jdField_b_of_type_Boolean = false;
      this.e = false;
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      a(f1);
      return true;
    } while (!a(paramMotionEvent));
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setListView(ListView paramListView)
  {
    this.jdField_a_of_type_AndroidWidgetListView = paramListView;
  }
  
  public void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTouchListener(WSDragLayout.TouchListener paramTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener = paramTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout
 * JD-Core Version:    0.7.0.1
 */