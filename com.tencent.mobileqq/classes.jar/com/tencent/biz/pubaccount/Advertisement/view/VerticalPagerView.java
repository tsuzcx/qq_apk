package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.util.DisplayUtil;

public class VerticalPagerView
  extends ViewGroup
{
  protected float a;
  protected int a;
  protected Scroller a;
  protected VerticalPagerView.OnInterceptTouchListener a;
  protected VerticalPagerView.OnPagerChangedListener a;
  protected boolean a;
  protected float b;
  protected int b;
  protected boolean b;
  protected float c;
  public int c;
  protected float d = 0.0F;
  protected float e = 0.0F;
  protected float f = 0.0F;
  
  public VerticalPagerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(super.getContext());
  }
  
  public VerticalPagerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(super.getContext());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 250);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1 - this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), paramInt2 - this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt3);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    localScroller.startScroll(localScroller.getFinalX(), this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt1, paramInt2, paramInt3);
    super.invalidate();
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      super.postInvalidate();
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_b_of_type_Int;
      int j = this.jdField_c_of_type_Int;
      if (i != j)
      {
        a(j);
        VerticalPagerView.OnPagerChangedListener localOnPagerChangedListener = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
        if (localOnPagerChangedListener != null) {
          localOnPagerChangedListener.a(this, super.getChildAt(this.jdField_c_of_type_Int), this.jdField_c_of_type_Int);
        }
        this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      }
    }
    super.computeScroll();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.getChildCount() >= 2)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      this.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      float f1;
      if (i == 0)
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
        f1 = this.d;
        this.jdField_b_of_type_Float = f1;
        this.e = f1;
        return false;
      }
      if (i == 2)
      {
        f1 = Math.abs(this.jdField_c_of_type_Float - this.jdField_a_of_type_Float);
        float f2 = Math.abs(this.d - this.jdField_b_of_type_Float);
        if ((f2 >= DisplayUtil.a(super.getContext(), 10.0F)) && (f2 >= f1))
        {
          i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Int);
          if (i > 0)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener;
            if (paramMotionEvent != null) {
              return paramMotionEvent.b(this.jdField_c_of_type_Int);
            }
            return b(this.jdField_c_of_type_Int);
          }
          if (i < 0)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener;
            if (paramMotionEvent != null) {
              return paramMotionEvent.a(this.jdField_c_of_type_Int);
            }
            return a(this.jdField_c_of_type_Int);
          }
        }
        else
        {
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = super.getChildCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = super.getChildAt(i);
      k = paramInt4 - paramInt2 + j;
      localView.layout(0, j, paramInt3 - paramInt1, k);
      i += 1;
    }
    setCurrentPage(this.jdField_c_of_type_Int);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      super.measureChild(super.getChildAt(i), paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.d = paramMotionEvent.getY();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      f1 = this.d;
      this.jdField_b_of_type_Float = f1;
      this.jdField_a_of_type_Boolean = true;
      this.e = f1;
      return true;
    }
    Object localObject;
    if (i == 2)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getY() - this.jdField_a_of_type_Int));
      i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (Math.abs(this.d - this.jdField_b_of_type_Float) < DisplayUtil.a(super.getContext(), 10.0F))
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        f1 = this.d;
        this.f = (f1 - this.e);
        this.e = f1;
        return false;
      }
      if (i < 0)
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false, this.jdField_c_of_type_Int);
        }
        f1 = this.d;
        this.f = (f1 - this.e);
        this.e = f1;
        return false;
      }
      if (i > (super.getChildCount() - 1) * super.getHeight())
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        paramMotionEvent = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false, this.jdField_c_of_type_Int);
        }
        f1 = this.d;
        this.f = (f1 - this.e);
        this.e = f1;
        return false;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetScroller;
      ((Scroller)localObject).startScroll(0, ((Scroller)localObject).getFinalY(), 0, -this.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      super.invalidate();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
      if (localObject != null) {
        ((VerticalPagerView.OnPagerChangedListener)localObject).a(true, this.jdField_c_of_type_Int);
      }
    }
    else if ((i == 1) || (i == 3))
    {
      f1 = Math.abs(this.f);
      this.e = this.d;
      i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() - this.jdField_c_of_type_Int * super.getHeight();
      if ((i <= super.getHeight() / 4) && ((i <= 0) || (f1 <= DisplayUtil.a(super.getContext(), 7.0F))))
      {
        if ((i < -super.getHeight() / 4) || ((i < 0) && (f1 > DisplayUtil.a(super.getContext(), 5.0F))))
        {
          this.jdField_c_of_type_Int -= 1;
          if (this.jdField_c_of_type_Int < 0) {
            this.jdField_c_of_type_Int = 0;
          }
        }
      }
      else
      {
        this.jdField_c_of_type_Int += 1;
        if (this.jdField_c_of_type_Int >= super.getChildCount()) {
          this.jdField_c_of_type_Int = (super.getChildCount() - 1);
        }
      }
      a(0, this.jdField_c_of_type_Int * super.getHeight());
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener;
      if (localObject != null) {
        ((VerticalPagerView.OnPagerChangedListener)localObject).a(false, this.jdField_c_of_type_Int);
      }
    }
    float f1 = this.d;
    this.f = (f1 - this.e);
    this.e = f1;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentPage(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    a(0, this.jdField_c_of_type_Int * super.getHeight());
  }
  
  public void setCurrentPage(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    a(0, this.jdField_c_of_type_Int * super.getHeight(), paramInt2);
  }
  
  public void setEnableChangePage(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnInterceptTouchListener(VerticalPagerView.OnInterceptTouchListener paramOnInterceptTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnInterceptTouchListener = paramOnInterceptTouchListener;
  }
  
  public void setOnPagerChangedListener(VerticalPagerView.OnPagerChangedListener paramOnPagerChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVerticalPagerView$OnPagerChangedListener = paramOnPagerChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView
 * JD-Core Version:    0.7.0.1
 */