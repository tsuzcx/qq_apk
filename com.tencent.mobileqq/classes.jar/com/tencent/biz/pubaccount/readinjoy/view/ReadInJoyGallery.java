package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String a;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  boolean jdField_a_of_type_Boolean = false;
  private long b;
  private boolean f;
  private float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float;
  private boolean jdField_h_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoyGallery.class.getSimpleName();
  }
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.b < 350L;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    label121:
    label124:
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_AndroidViewView.getTag(2131296392) == null) || (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null)) {
        break;
      }
      float f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      int i;
      if (Math.abs(a(this.jdField_a_of_type_AndroidViewView) - f1) >= 1.0E-005F)
      {
        i = 1;
        Rect localRect = new Rect();
        this.jdField_a_of_type_AndroidViewView.getLocalVisibleRect(localRect);
        if (Math.abs(localRect.top) > 1.0E-005F) {
          break label121;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && (j != 0)) {
          break label124;
        }
        return true;
        i = 0;
        break;
      }
    }
    return super.b();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dispatchTouchEvent()  action=" + i);
    }
    if (i == 0)
    {
      this.jdField_g_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_h_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_g_of_type_Boolean = false;
      this.f = false;
      this.jdField_h_of_type_Boolean = false;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (i == 2)
      {
        float f1 = paramMotionEvent.getRawX() - this.jdField_g_of_type_Float;
        float f2 = paramMotionEvent.getRawY() - this.jdField_h_of_type_Float;
        if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.jdField_a_of_type_AndroidViewViewConfiguration.getScaledTouchSlop()) && (!this.jdField_g_of_type_Boolean) && (!this.f) && ((f1 != 0.0F) || (f2 != 0.0F)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "dispatchTouchEvent()  action=" + i + " distanceX=" + f1 + " distanceY=" + f2);
          }
          if (Math.abs(f1) >= Math.abs(f2))
          {
            this.jdField_g_of_type_Boolean = true;
            if (f1 < 0.0F) {
              this.jdField_h_of_type_Boolean = true;
            }
          }
          else
          {
            this.f = true;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int i = paramMotionEvent.getAction();
    float f1;
    float f2;
    ViewParent localViewParent;
    boolean bool1;
    if (i == 2)
    {
      f1 = paramMotionEvent.getRawX() - this.jdField_g_of_type_Float;
      f2 = paramMotionEvent.getRawY() - this.jdField_h_of_type_Float;
      i = getSelectedItemPosition();
      int j = getCount();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  currentItemPosition=" + i + " count=" + j + " distanceX=" + f1 + " distanceY=" + f2);
      }
      if (paramMotionEvent.getPointerCount() == 1) {
        if ((Math.abs(f1) >= Math.abs(f2)) || (this.jdField_g_of_type_Boolean)) {
          if ((i == 0) && (f1 > 0.0F) && (!b()))
          {
            if ((a()) || (this.jdField_h_of_type_Boolean)) {
              break label416;
            }
            localViewParent = getParent();
            localViewParent.requestDisallowInterceptTouchEvent(false);
            localViewParent = localViewParent.getParent();
            bool1 = bool2;
            if (localViewParent != null)
            {
              localViewParent.requestDisallowInterceptTouchEvent(true);
              bool1 = bool2;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        bool2 = bool1 | super.onTouchEvent(paramMotionEvent);
      }
      return bool2;
      if ((i == getCount() - 1) && (f1 < 0.0F))
      {
        localViewParent = getParent();
        localViewParent.requestDisallowInterceptTouchEvent(false);
        localViewParent = localViewParent.getParent();
        bool1 = bool2;
        if (localViewParent != null)
        {
          localViewParent.requestDisallowInterceptTouchEvent(true);
          bool1 = bool2;
        }
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        bool1 = false;
        continue;
        if ((!b()) && (f2 > 0.0F))
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          localViewParent = getParent().getParent();
          bool1 = bool2;
          if (localViewParent != null)
          {
            localViewParent.requestDisallowInterceptTouchEvent(true);
            bool1 = bool2;
          }
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          bool1 = false;
          continue;
          getParent().requestDisallowInterceptTouchEvent(true);
          bool1 = false;
          continue;
          if (i == 1) {
            this.b = System.currentTimeMillis();
          }
          label416:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */