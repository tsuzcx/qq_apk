package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.Gallery;
import qqk;
import qql;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  protected qqk a;
  private qql jdField_a_of_type_Qql;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  boolean jdField_b_of_type_Boolean = false;
  private boolean j;
  private boolean k;
  private int l = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoyGallery.class.getSimpleName();
  }
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
    K_();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    K_();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    K_();
  }
  
  protected void K_()
  {
    setMaxScale(2.147484E+009F);
    this.jdField_a_of_type_Int = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.a(paramInt1, paramInt2, paramBoolean);
    if (this.jdField_a_of_type_Qql != null) {
      this.jdField_a_of_type_Qql.a(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 3: 
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      return bool;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.j = false;
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      f1 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
      f2 = paramMotionEvent.getY() - this.jdField_b_of_type_Float;
    } while ((Math.abs(f1) <= this.jdField_a_of_type_Int) && (Math.abs(f2) <= this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Boolean = true;
    if (Math.abs(f1) > Math.abs(f2))
    {
      this.jdField_b_of_type_Boolean = true;
      this.j = true;
      if (f1 < 0.0F) {}
      for (int i = 1;; i = 2)
      {
        this.l = i;
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
    }
    if (this.d)
    {
      this.jdField_b_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.jdField_b_of_type_Boolean = false;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Qqk != null) {
      this.jdField_a_of_type_Qqk.a();
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.k)
    {
      if (paramMotionEvent.getPointerCount() >= 2) {}
      do
      {
        do
        {
          return false;
          switch (paramMotionEvent.getAction())
          {
          case 3: 
          default: 
            return super.onInterceptTouchEvent(paramMotionEvent);
          case 0: 
            onTouchEvent(paramMotionEvent);
            return false;
          case 1: 
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.j) {
                return super.onInterceptTouchEvent(paramMotionEvent);
              }
              onTouchEvent(paramMotionEvent);
              return false;
            }
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(3);
            onTouchEvent(paramMotionEvent);
            return false;
          }
        } while (!this.jdField_a_of_type_Boolean);
        if (!this.k) {
          break;
        }
      } while ((!this.j) || (this.l != 2));
      return super.onInterceptTouchEvent(paramMotionEvent);
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setIsListPage(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setOnDoubleTapListener(qqk paramqqk)
  {
    this.jdField_a_of_type_Qqk = paramqqk;
  }
  
  public void setOnScrollChangeListener(qql paramqql)
  {
    this.jdField_a_of_type_Qql = paramqql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */