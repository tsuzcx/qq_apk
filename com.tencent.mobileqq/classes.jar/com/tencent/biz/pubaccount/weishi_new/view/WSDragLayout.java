package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class WSDragLayout
  extends LinearLayout
{
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private WSDragLayout.TouchListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  private boolean i;
  
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
    int j = 0;
    int k = 0;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 0)
      {
        int m = k + localView.getHeight();
        k = m;
        if (j == 0)
        {
          this.jdField_c_of_type_Int = localView.getHeight();
          k = m;
        }
      }
      j += 1;
    }
    this.jdField_b_of_type_Int = k;
    return k / 4;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    a();
  }
  
  private void a(float paramFloat)
  {
    float f1 = -(paramFloat - this.jdField_d_of_type_Float);
    float f2 = a(f1);
    WSDragLayout.TouchListener localTouchListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
    if ((localTouchListener != null) && (this.jdField_b_of_type_Int > 0)) {
      localTouchListener.a(Math.abs(getScrollY() + f2) / this.jdField_b_of_type_Int);
    }
    boolean bool1 = this.jdField_c_of_type_Boolean;
    boolean bool2 = false;
    if ((bool1) && (f2 != 0.0F)) {
      scrollBy(0, (int)f2);
    } else if (f2 > 0.0F) {
      scrollBy(0, (int)f2);
    }
    if (Math.abs(f1) > 5.0F)
    {
      this.e = true;
      if (f2 >= 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.i = bool1;
    }
    localTouchListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
    if (localTouchListener != null)
    {
      bool1 = bool2;
      if (getScrollY() > 0) {
        bool1 = true;
      }
      localTouchListener.a(bool1);
    }
    this.jdField_d_of_type_Float = paramFloat;
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
    a();
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Float = 0.0F;
    if (this.i)
    {
      this.g = true;
      a(0);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener != null)
    {
      this.f = true;
      int j = this.jdField_c_of_type_Int;
      if (j > 0) {
        j = this.jdField_b_of_type_Int - j;
      } else {
        j = this.jdField_b_of_type_Int;
      }
      a(-j);
    }
    return false;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int j = (int)paramMotionEvent.getRawY();
    int k = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int m = paramMotionEvent[0];
    int n = paramMotionEvent[1];
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    return (j >= n) && (j <= i2 + n) && (k >= m) && (k <= i1 + m);
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if ((getChildAt(0).isShown()) && (b(getChildAt(0), paramMotionEvent))) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
    {
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_b_of_type_Boolean = false;
    }
    WSDragLayout.TouchListener localTouchListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
    int j;
    if ((localTouchListener != null) && (localTouchListener.a())) {
      j = 1;
    } else {
      j = 0;
    }
    if ((!this.jdField_a_of_type_AndroidViewViewGroup.canScrollVertically(-1)) && (j == 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((j != 0) || (paramMotionEvent.getRawY() < this.jdField_c_of_type_Float))
    {
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      if (getScrollY() == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
    }
    if (this.jdField_b_of_type_Boolean) {
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
    if ((this.jdField_d_of_type_Boolean) && (!a(paramView, paramMotionEvent))) {
      return false;
    }
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  public float a(float paramFloat)
  {
    float f1;
    if (this.jdField_a_of_type_Boolean) {
      f1 = 0.0F;
    } else {
      f1 = 20.0F;
    }
    int j = AIOUtils.b(f1, getContext().getResources());
    if ((int)(getScrollY() + paramFloat) < j) {
      return paramFloat;
    }
    return j - getScrollY();
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt1 - getScrollY(), paramInt2);
      invalidate();
      return;
    }
    scrollTo(0, paramInt1);
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public void b(int paramInt)
  {
    this.h = true;
    this.f = true;
    if (this.jdField_c_of_type_Int > 0)
    {
      a(-(getHeight() - this.jdField_c_of_type_Int), paramInt);
      return;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new WSDragLayout.1(this, paramInt));
  }
  
  public void c(int paramInt)
  {
    this.h = false;
    this.g = true;
    if (this.jdField_c_of_type_Int > 0)
    {
      a(0, paramInt);
      return;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new WSDragLayout.2(this, paramInt));
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollY = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      ((StringBuilder)localObject).append("; dis = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      WSLog.a("WSDragLayout", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
      if ((localObject != null) && (this.jdField_b_of_type_Int > 0)) {
        ((WSDragLayout.TouchListener)localObject).a(Math.abs(this.jdField_a_of_type_AndroidWidgetScroller.getCurrY()) / this.jdField_b_of_type_Int);
      }
      invalidate();
      return;
    }
    if (this.f)
    {
      this.f = false;
      this.h = true;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
      if (localObject != null)
      {
        ((WSDragLayout.TouchListener)localObject).a(1.0F);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a(this.jdField_a_of_type_Int);
      }
    }
    else if (this.g)
    {
      this.g = false;
      this.h = false;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener;
      if (localObject != null)
      {
        ((WSDragLayout.TouchListener)localObject).a(0.0F);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSDragLayout$TouchListener.a();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b(getChildAt(0), paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (b(paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int j = paramMotionEvent.getAction();
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            return false;
          }
        }
        else
        {
          a(f1);
          return true;
        }
      }
      if (a(paramMotionEvent)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.jdField_b_of_type_Boolean = false;
    this.e = false;
    this.jdField_d_of_type_Float = paramMotionEvent.getY();
    this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSDragLayout
 * JD-Core Version:    0.7.0.1
 */