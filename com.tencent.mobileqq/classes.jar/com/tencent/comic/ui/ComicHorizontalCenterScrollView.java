package com.tencent.comic.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

public class ComicHorizontalCenterScrollView
  extends HorizontalScrollView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private ComicHorizontalCenterScrollView.OnCustomScrollListener jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView$OnCustomScrollListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d;
  private int e = 0;
  private int f;
  private int g;
  private int h;
  
  public ComicHorizontalCenterScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComicHorizontalCenterScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComicHorizontalCenterScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ViewConfiguration.get(getContext());
    this.f = paramContext.getScaledTouchSlop();
    this.g = paramContext.getScaledMinimumFlingVelocity();
    this.h = (this.g * 2);
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    if (Math.abs(paramFloat) >= this.h) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    if (paramFloat <= 0.0F)
    {
      paramInt2 = paramInt3;
      if (j != 0) {
        paramInt2 = paramInt3 + this.e;
      }
      paramInt3 = this.c;
      j = paramInt2 / paramInt3;
      i = (j + 1) * paramInt3 + this.d;
      if (i > paramInt2)
      {
        paramInt3 = i;
        if (i < paramInt2 + paramInt1) {}
      }
      else
      {
        return j * this.c + this.d;
      }
    }
    else
    {
      i = paramInt3;
      if (j != 0) {
        i = paramInt3 - this.e;
      }
      paramInt3 = this.c;
      int k = (paramInt2 - i - paramInt1) / paramInt3;
      j = paramInt2 - paramInt3 * (k + 1) - this.d;
      if (j > i)
      {
        paramInt3 = j;
        if (j < i + paramInt1) {}
      }
      else
      {
        paramInt3 = paramInt2 - this.c * k - this.d;
      }
    }
    return paramInt3;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Math.max(paramInt2, paramInt1);
    return Math.min(paramInt3, paramInt1);
  }
  
  private void a()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void a(float paramFloat)
  {
    int k = getScrollX();
    float f1 = paramFloat;
    if (paramFloat == 0.0F) {
      if (this.jdField_b_of_type_Float - k > 0.0F) {
        f1 = 1.0F;
      } else {
        f1 = -1.0F;
      }
    }
    Object localObject = getChildAt(0);
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getMeasuredWidth();
    int j = getMeasuredWidth();
    if (i <= j) {
      return;
    }
    if (j >= this.jdField_a_of_type_Int * 2) {
      return;
    }
    k = a(f1, j, i, k);
    smoothScrollTo(a(k - j / 2, 0, i), 0);
    localObject = this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView$OnCustomScrollListener;
    if (localObject != null) {
      ((ComicHorizontalCenterScrollView.OnCustomScrollListener)localObject).a(k);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    b();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void c()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_b_of_type_Float = getScrollX();
      this.jdField_b_of_type_Boolean = false;
      a();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) >= this.f)
        {
          this.jdField_b_of_type_Boolean = true;
          a(paramMotionEvent);
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
        }
      }
      else {
        a(paramMotionEvent);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      a(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity());
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBaseInfo(int paramInt1, int paramInt2, ComicHorizontalCenterScrollView.OnCustomScrollListener paramOnCustomScrollListener)
  {
    this.jdField_a_of_type_ComTencentComicUiComicHorizontalCenterScrollView$OnCustomScrollListener = paramOnCustomScrollListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.jdField_b_of_type_Int;
    this.c = (paramInt1 + paramInt2);
    this.e = (paramInt1 / 3);
    this.jdField_a_of_type_Boolean = true;
    this.d = (paramInt1 / 2 + paramInt2);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.ComicHorizontalCenterScrollView
 * JD-Core Version:    0.7.0.1
 */