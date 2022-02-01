package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;

public class SlideAndOverScrollRecyclerView
  extends OverScrollRecyclerView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  
  public SlideAndOverScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideAndOverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int j = ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition();
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return j + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getScrollX() != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(0, 0);
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    a(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      float f1 = i;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = j;
      this.jdField_b_of_type_Int = a(i, j);
      if (this.jdField_b_of_type_Int != -1)
      {
        ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(this.jdField_b_of_type_Int - ((LinearLayoutManager)getLayoutManager()).findFirstVisibleItemPosition()));
        if ((localViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup != localViewGroup) && (localViewGroup.getScrollX() != 0)) {
          localViewGroup.scrollTo(0, 0);
        }
        if (this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() == 2)
        {
          this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(1).getWidth();
        }
        else
        {
          this.jdField_c_of_type_Int = -1;
          continue;
          this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
          float f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
          if (((Math.abs(f1) > 600.0F) && (Math.abs(f1) > Math.abs(f2))) || ((Math.abs(i - this.jdField_b_of_type_Float) >= this.jdField_a_of_type_Int) && (Math.abs(i - this.jdField_b_of_type_Float) > Math.abs(j - this.jdField_c_of_type_Float))))
          {
            this.jdField_a_of_type_Boolean = true;
            return true;
            d();
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int != -1))
    {
      float f1 = paramMotionEvent.getX();
      a(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      case 0: 
      default: 
      case 2: 
        for (;;)
        {
          return true;
          if (this.jdField_c_of_type_Int != -1)
          {
            float f2 = this.jdField_a_of_type_Float - f1;
            if ((this.jdField_a_of_type_AndroidViewViewGroup.getScrollX() + f2 <= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_AndroidViewViewGroup.getScrollX() + f2 > 0.0F)) {
              this.jdField_a_of_type_AndroidViewViewGroup.scrollBy((int)f2, 0);
            }
            this.jdField_a_of_type_Float = f1;
          }
        }
      }
      int i;
      if (this.jdField_c_of_type_Int != -1)
      {
        i = this.jdField_a_of_type_AndroidViewViewGroup.getScrollX();
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() >= -600.0F) {
          break label219;
        }
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, this.jdField_c_of_type_Int - i, 0, Math.abs(this.jdField_c_of_type_Int - i));
      }
      for (;;)
      {
        invalidate();
        this.jdField_c_of_type_Int = -1;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Int = -1;
        d();
        break;
        label219:
        if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() >= 600.0F) {
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i));
        } else if (i >= this.jdField_c_of_type_Int / 2) {
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, this.jdField_c_of_type_Int - i, 0, Math.abs(this.jdField_c_of_type_Int - i));
        } else {
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, -i, 0, Math.abs(i));
        }
      }
    }
    c();
    d();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.SlideAndOverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */