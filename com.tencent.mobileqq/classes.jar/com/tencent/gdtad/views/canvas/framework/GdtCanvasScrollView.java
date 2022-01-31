package com.tencent.gdtad.views.canvas.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import bajq;
import yny;
import yql;
import yqm;

public class GdtCanvasScrollView
  extends ScrollView
{
  public static String a;
  public int a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public yqm a;
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
    this.jdField_a_of_type_Int = bajq.b(25.0F);
    a();
  }
  
  private void a()
  {
    setVerticalScrollBarEnabled(false);
    setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_JavaLangRunnable = new GdtCanvasScrollView.1(this);
    setOnTouchListener(new yql(this));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    paramMotionEvent = getChildAt(0);
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Yqm != null) {
        this.jdField_a_of_type_Yqm.a(this);
      }
      if ((this.c - i > this.jdField_a_of_type_Int) && (paramMotionEvent != null) && (paramMotionEvent.getMeasuredHeight() <= this.d + getHeight() + (this.e - i)) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        post(new GdtCanvasScrollView.3(this));
        if (this.jdField_a_of_type_Yqm != null) {
          this.jdField_a_of_type_Yqm.a();
        }
      }
      do
      {
        return true;
        if ((this.c - i >= -this.jdField_a_of_type_Int) || (paramMotionEvent == null) || (this.d != 0) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        post(new GdtCanvasScrollView.4(this));
      } while (this.jdField_a_of_type_Yqm == null);
      this.jdField_a_of_type_Yqm.b();
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
    try
    {
      super.onInterceptTouchEvent(paramMotionEvent);
      j = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      int j;
      int i;
      do
      {
        for (;;)
        {
          yny.d(jdField_a_of_type_JavaLangString, "onInterceptTouchEvent", localThrowable);
          continue;
          this.e = i;
          this.jdField_b_of_type_Int = j;
          this.c = i;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Boolean = true;
        }
        j = Math.abs(j - this.jdField_b_of_type_Int);
      } while (Math.atan2(Math.abs(i - this.c), j) <= 0.7853981633974483D);
    }
    return true;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Yqm.a(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.d = getScrollY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Throwable paramMotionEvent)
      {
        boolean bool;
        yny.d(jdField_a_of_type_JavaLangString, "onTouchEvent error", paramMotionEvent);
      }
      bool = a(paramMotionEvent);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView
 * JD-Core Version:    0.7.0.1
 */