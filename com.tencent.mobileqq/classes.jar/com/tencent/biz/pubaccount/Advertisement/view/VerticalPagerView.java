package com.tencent.biz.pubaccount.Advertisement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.util.DisplayUtil;
import ofp;
import ofq;

public class VerticalPagerView
  extends ViewGroup
{
  protected float a;
  protected int a;
  protected Scroller a;
  protected ofp a;
  protected ofq a;
  protected boolean a;
  protected float b;
  protected int b;
  protected boolean b;
  protected float c;
  public int c;
  protected float d;
  protected float e;
  protected float f;
  
  public VerticalPagerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(super.getContext());
  }
  
  public VerticalPagerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(super.getContext());
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ofq = null;
    this.jdField_a_of_type_Ofp = null;
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
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidWidgetScroller.getFinalX(), this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), paramInt1, paramInt2, paramInt3);
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
    for (;;)
    {
      super.computeScroll();
      return;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != this.jdField_c_of_type_Int))
      {
        a(this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_Ofq != null) {
          this.jdField_a_of_type_Ofq.a(this, super.getChildAt(this.jdField_c_of_type_Int), this.jdField_c_of_type_Int);
        }
        this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((super.getChildCount() < 2) || (!this.jdField_b_of_type_Boolean)) {}
    int i;
    do
    {
      do
      {
        return false;
        i = paramMotionEvent.getAction();
        this.jdField_c_of_type_Float = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
        if (i == 0)
        {
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
          this.jdField_a_of_type_Float = this.jdField_c_of_type_Float;
          this.jdField_b_of_type_Float = this.d;
          this.e = this.d;
          return false;
        }
      } while (i != 2);
      float f1 = Math.abs(this.jdField_c_of_type_Float - this.jdField_a_of_type_Float);
      float f2 = Math.abs(this.d - this.jdField_b_of_type_Float);
      if ((f2 < DisplayUtil.dip2px(super.getContext(), 10.0F)) || (f2 < f1))
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        return false;
      }
      i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Int);
      if (i > 0)
      {
        if (this.jdField_a_of_type_Ofp != null) {
          return this.jdField_a_of_type_Ofp.b(this.jdField_c_of_type_Int);
        }
        return b(this.jdField_c_of_type_Int);
      }
    } while (i >= 0);
    if (this.jdField_a_of_type_Ofp != null) {
      return this.jdField_a_of_type_Ofp.a(this.jdField_c_of_type_Int);
    }
    return a(this.jdField_c_of_type_Int);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = super.getChildCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = super.getChildAt(i);
      int m = paramInt4 - paramInt2;
      localView.layout(0, j, paramInt3 - paramInt1, j + m);
      j += m;
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
      this.jdField_b_of_type_Float = this.d;
      this.jdField_a_of_type_Boolean = true;
      this.e = this.d;
      return true;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getY() - this.jdField_a_of_type_Int));
      i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (Math.abs(this.d - this.jdField_b_of_type_Float) < DisplayUtil.dip2px(super.getContext(), 10.0F))
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        this.f = (this.d - this.e);
        this.e = this.d;
        return false;
      }
      if (i < 0)
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        if (this.jdField_a_of_type_Ofq != null) {
          this.jdField_a_of_type_Ofq.a(false, this.jdField_c_of_type_Int);
        }
        this.f = (this.d - this.e);
        this.e = this.d;
        return false;
      }
      if (i > (super.getChildCount() - 1) * super.getHeight())
      {
        this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
        if (this.jdField_a_of_type_Ofq != null) {
          this.jdField_a_of_type_Ofq.a(false, this.jdField_c_of_type_Int);
        }
        this.f = (this.d - this.e);
        this.e = this.d;
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, this.jdField_a_of_type_AndroidWidgetScroller.getFinalY(), 0, -this.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      super.invalidate();
      if (this.jdField_a_of_type_Ofq != null) {
        this.jdField_a_of_type_Ofq.a(true, this.jdField_c_of_type_Int);
      }
    }
    while ((i != 1) && (i != 3))
    {
      this.f = (this.d - this.e);
      this.e = this.d;
      return super.onTouchEvent(paramMotionEvent);
    }
    float f1 = Math.abs(this.f);
    this.e = this.d;
    i = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY() - this.jdField_c_of_type_Int * super.getHeight();
    if ((i > super.getHeight() / 4) || ((i > 0) && (f1 > DisplayUtil.dip2px(super.getContext(), 7.0F))))
    {
      this.jdField_c_of_type_Int += 1;
      if (this.jdField_c_of_type_Int >= super.getChildCount()) {
        this.jdField_c_of_type_Int = (super.getChildCount() - 1);
      }
    }
    for (;;)
    {
      a(0, this.jdField_c_of_type_Int * super.getHeight());
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ofq == null) {
        break;
      }
      this.jdField_a_of_type_Ofq.a(false, this.jdField_c_of_type_Int);
      break;
      if ((i < -super.getHeight() / 4) || ((i < 0) && (f1 > DisplayUtil.dip2px(super.getContext(), 5.0F))))
      {
        this.jdField_c_of_type_Int -= 1;
        if (this.jdField_c_of_type_Int < 0) {
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
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
  
  public void setOnInterceptTouchListener(ofp paramofp)
  {
    this.jdField_a_of_type_Ofp = paramofp;
  }
  
  public void setOnPagerChangedListener(ofq paramofq)
  {
    this.jdField_a_of_type_Ofq = paramofq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView
 * JD-Core Version:    0.7.0.1
 */