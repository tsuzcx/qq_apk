package com.tencent.gdtad.views.canvas.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.mobileqq.utils.ViewUtils;
import qjr;
import qjs;
import qjt;
import qju;

public class GdtCanvasScrollView
  extends ScrollView
{
  public static String a;
  public int a;
  public GdtCanvasScrollView.OnScrollEventListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GdtCanvasScrollView";
  }
  
  public GdtCanvasScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtCanvasScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewUtils.b(25.0F);
    a();
  }
  
  private void a()
  {
    setVerticalScrollBarEnabled(false);
    setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_JavaLangRunnable = new qjr(this);
    setOnTouchListener(new qjs(this));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    paramMotionEvent = getChildAt(0);
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener != null) {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener.a(this);
      }
      if ((this.c - i > this.jdField_a_of_type_Int) && (paramMotionEvent != null) && (paramMotionEvent.getMeasuredHeight() <= this.d + getHeight() + (this.e - i)) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        post(new qjt(this));
        if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener != null) {
          this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener.a();
        }
      }
      do
      {
        return true;
        if ((this.c - i >= -this.jdField_a_of_type_Int) || (paramMotionEvent == null) || (this.d != 0) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        post(new qju(this));
      } while (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener == null);
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener.b();
      return true;
    }
    return false;
  }
  
  public void fling(int paramInt)
  {
    super.fling((int)(paramInt / 2.5D));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.e = i;
        this.jdField_b_of_type_Int = j;
        this.c = i;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = true;
      }
      j = Math.abs(j - this.jdField_b_of_type_Int);
    } while (Math.atan2(Math.abs(i - this.c), j) <= 0.7853981633974483D);
    return true;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView$OnScrollEventListener.a(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.d = getScrollY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      boolean bool = a(paramMotionEvent);
      this.e = ((int)paramMotionEvent.getY());
      if (bool)
      {
        return true;
        this.e = 0;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView
 * JD-Core Version:    0.7.0.1
 */