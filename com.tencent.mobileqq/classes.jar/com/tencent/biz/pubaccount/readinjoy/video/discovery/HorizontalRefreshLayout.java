package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import ssj;
import ssk;
import ssl;

public class HorizontalRefreshLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ssk jdField_a_of_type_Ssk;
  private ssl jdField_a_of_type_Ssl;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  private int e;
  private int f = DisplayUtil.dip2px(getContext(), 25.0F);
  
  public HorizontalRefreshLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      i = 0;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(this.jdField_b_of_type_AndroidViewView)) {
          this.jdField_a_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      ((FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).gravity = 8388613;
      addView(this.jdField_b_of_type_AndroidViewView, 0);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.animate().translationX(0.0F).setDuration(500L).setListener(new ssj(this)).start();
      this.jdField_b_of_type_AndroidViewView.animate().translationX(this.jdField_a_of_type_Int).setDuration(500L).start();
    }
  }
  
  public boolean a()
  {
    return ViewCompat.canScrollHorizontally(this.jdField_a_of_type_AndroidViewView, 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.c = i;
      this.e = i;
      this.d = j;
      if (i > this.f)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        int k = i - this.c;
        int m = this.d;
        this.c = i;
        this.e = i;
        if (Math.abs(k) >= Math.abs(j - m))
        {
          if ((this.jdField_b_of_type_AndroidViewView != null) && (k < 0) && (!a()))
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      a();
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Int);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.e = i;
      continue;
      int j = this.e;
      this.e = i;
      this.jdField_a_of_type_Float = ((i - j) * (1.0F - Math.abs(this.jdField_a_of_type_Float / this.jdField_b_of_type_Int)) + this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Float >= 0.0F)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
        return false;
      }
      if (this.jdField_a_of_type_Float <= -this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_Float = (-this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Float);
        this.jdField_b_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float);
        return false;
      }
      this.jdField_a_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Float);
      this.jdField_b_of_type_AndroidViewView.setTranslationX(this.jdField_a_of_type_Int + this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = Math.abs(this.jdField_a_of_type_Float / this.jdField_a_of_type_Int);
      return false;
      this.c = 0;
      this.e = 0;
      if (this.jdField_a_of_type_Ssk != null) {
        this.jdField_a_of_type_Ssk.a(this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidViewView, this);
      }
      b();
    }
  }
  
  public void setOnDraggingListener(ssk paramssk)
  {
    this.jdField_a_of_type_Ssk = paramssk;
  }
  
  public void setRefreshHeader(ssl paramssl)
  {
    this.jdField_a_of_type_Ssl = paramssl;
    a(this.jdField_a_of_type_Ssl.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout
 * JD-Core Version:    0.7.0.1
 */