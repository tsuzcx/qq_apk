package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import mgt;
import mgu;

public class ReadInJoyAtlasViewPager
  extends ViewPager
{
  public static final String a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 15;
  protected ValueAnimator a;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  private ReadInJoyAtlasViewPager.PageItemScrollListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoyAtlasViewPager.class.getSimpleName();
  }
  
  public ReadInJoyAtlasViewPager(Context paramContext)
  {
    super(paramContext);
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
  }
  
  public ReadInJoyAtlasViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setClickable(true);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    int j = getChildAt(getCurrentItem()).getScrollY();
    if (j > 0) {}
    for (int i = ScreenUtil.b - j + 1;; i = -(ScreenUtil.b + j + 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "scrollTopOrBottom()  scrollY=" + j + " delta=" + i);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { j, i + j });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new mgt(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    int i = getChildAt(getCurrentItem()).getScrollY();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "scrollOrigin()  scrollY=" + i + " delta=" + i);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setFloatValues(new float[] { i, i - i });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new mgu(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public boolean a(boolean paramBoolean, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      paramBoolean = bool1;
      if (paramFloat < 0.0F)
      {
        paramBoolean = bool1;
        if ((this.jdField_a_of_type_Int & 0x1) != 0) {
          paramBoolean = true;
        }
      }
      bool1 = paramBoolean;
      if (paramFloat > 0.0F)
      {
        bool1 = paramBoolean;
        if ((this.jdField_a_of_type_Int & 0x2) == 0) {}
      }
    }
    else
    {
      do
      {
        return true;
        paramBoolean = bool2;
        if (paramFloat < 0.0F)
        {
          paramBoolean = bool2;
          if ((this.jdField_a_of_type_Int & 0x4) != 0) {
            paramBoolean = true;
          }
        }
        bool1 = paramBoolean;
        if (paramFloat <= 0.0F) {
          break;
        }
      } while ((this.jdField_a_of_type_Int & 0x8) != 0);
      bool1 = paramBoolean;
    }
    return bool1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dispatchTouchEvent()  action=" + i);
    }
    float f1;
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
      this.jdField_c_of_type_Float = f1;
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i == 2)
      {
        f1 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
        float f2 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
        if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.jdField_a_of_type_AndroidViewViewConfiguration.getScaledTouchSlop()) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && ((f1 != 0.0F) || (f2 != 0.0F)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "dispatchTouchEvent()  action=" + i + " distanceX=" + f1 + " distanceY=" + f2);
          }
          if (Math.abs(f1) >= Math.abs(f2)) {
            this.jdField_c_of_type_Boolean = true;
          } else {
            this.jdField_b_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    float f1;
    int i;
    int j;
    if (paramMotionEvent.getAction() == 2)
    {
      f1 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
      float f2 = paramMotionEvent.getRawY();
      float f3 = this.jdField_b_of_type_Float;
      i = getCurrentItem();
      j = getChildCount();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInterceptTouchEvent()  currentItemPosition=" + i + " count=" + j + " distanceX=" + f1 + " distanceY=" + (f2 - f3) + " isXScrolling=" + this.jdField_c_of_type_Boolean + " isYScrolling=" + this.jdField_b_of_type_Boolean);
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean)
      {
        if ((i != 0) || (f1 <= 0.0F)) {
          break label199;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = true;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        bool1 = true;
      }
      try
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return bool1;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        label199:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "IllegalArgumentException.", paramMotionEvent);
      }
      if ((i == j - 1) && (f1 < 0.0F))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = true;
      }
      else if ((i != 0) || (f1 >= 0.0F))
      {
        bool1 = bool2;
        if (i == j - 1)
        {
          bool1 = bool2;
          if (f1 <= 0.0F) {}
        }
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  action=" + i);
    }
    boolean bool1;
    if (i == 2)
    {
      float f1 = paramMotionEvent.getRawX() - this.jdField_a_of_type_Float;
      float f2 = paramMotionEvent.getRawY() - this.jdField_b_of_type_Float;
      float f3 = this.jdField_c_of_type_Float - paramMotionEvent.getRawY();
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      i = getCurrentItem();
      int j = getChildCount();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  currentItemPosition=" + i + " count=" + j + " distanceX=" + f1 + " distanceY=" + f2 + " isXScrolling=" + this.jdField_c_of_type_Boolean + " isYScrolling=" + this.jdField_b_of_type_Boolean);
      }
      if ((this.jdField_c_of_type_Boolean) && (a(true, f1)))
      {
        if (((i == 0) && (f1 > 0.0F)) || ((i == j - 1) && (f1 < 0.0F))) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
      else
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (a(false, f2))
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            getChildAt(getCurrentItem()).scrollBy(0, (int)f3);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener.a(f1, f2, getChildAt(getCurrentItem()));
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  deltaY=" + f3);
            }
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (this.jdField_b_of_type_Boolean) {}
      }
      try
      {
        bool2 = super.onTouchEvent(paramMotionEvent);
        bool2 = bool1 | bool2;
        return bool2;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "IllegalArgumentException.", paramMotionEvent);
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = bool2;
      if (i == 1)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Boolean)
        {
          i = getChildAt(getCurrentItem()).getScrollY();
          if ((i < 0) && (Math.abs(i) >= ScreenUtil.b / 5))
          {
            a();
            bool1 = bool2;
          }
          else
          {
            b();
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public void setOnPageItemScrollListener(ReadInJoyAtlasViewPager.PageItemScrollListener paramPageItemScrollListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener = paramPageItemScrollListener;
  }
  
  public void setmDirectionMask(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager
 * JD-Core Version:    0.7.0.1
 */