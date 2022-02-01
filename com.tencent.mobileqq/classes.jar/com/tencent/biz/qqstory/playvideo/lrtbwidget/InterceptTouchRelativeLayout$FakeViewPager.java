package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class InterceptTouchRelativeLayout$FakeViewPager
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  
  public InterceptTouchRelativeLayout$FakeViewPager(Context paramContext, String paramString)
  {
    this.jdField_c_of_type_Int = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction() & 0xFF;
    int i = 3;
    if ((k != 3) && (k != 1))
    {
      Object localObject;
      if (k != 0)
      {
        if (this.jdField_a_of_type_Int != 0)
        {
          paramMotionEvent = this.jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Intercept returning true! ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
          return this.jdField_a_of_type_Int;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          Log.v(this.jdField_a_of_type_JavaLangString, "Intercept returning false!");
          return 0;
        }
      }
      float f1;
      if (k != 0)
      {
        int j = 2;
        if (k == 2)
        {
          k = this.jdField_b_of_type_Int;
          if (k != -1)
          {
            k = MotionEventCompat.findPointerIndex(paramMotionEvent, k);
            f1 = MotionEventCompat.getX(paramMotionEvent, k);
            float f3 = f1 - this.jdField_a_of_type_Float;
            float f4 = Math.abs(f3);
            float f2 = MotionEventCompat.getY(paramMotionEvent, k);
            float f5 = f2 - this.jdField_b_of_type_Float;
            float f6 = Math.abs(f5);
            paramMotionEvent = this.jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Moved x to ");
            ((StringBuilder)localObject).append(f1);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(f2);
            ((StringBuilder)localObject).append(" diff=");
            ((StringBuilder)localObject).append(f4);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(f6);
            ((StringBuilder)localObject).append(", mTouchSlop=");
            ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
            Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
            if ((f4 > this.jdField_c_of_type_Int) && (f4 > f6))
            {
              Log.v(this.jdField_a_of_type_JavaLangString, "Starting drag horizontal !");
              if (f3 <= 0.0F) {
                i = 1;
              }
              this.jdField_a_of_type_Int = i;
              if (f3 > 0.0F) {
                f1 = this.jdField_c_of_type_Float + this.jdField_c_of_type_Int;
              } else {
                f1 = this.jdField_c_of_type_Float - this.jdField_c_of_type_Int;
              }
              this.jdField_a_of_type_Float = f1;
              this.jdField_b_of_type_Float = f2;
            }
            else if ((f6 > this.jdField_c_of_type_Int) && (f6 > f4))
            {
              Log.v(this.jdField_a_of_type_JavaLangString, "Starting drag vertical !");
              i = j;
              if (f5 > 0.0F) {
                i = 4;
              }
              this.jdField_a_of_type_Int = i;
              this.jdField_a_of_type_Float = f1;
              if (f5 > 0.0F) {
                f1 = this.d + this.jdField_c_of_type_Int;
              } else {
                f1 = this.d - this.jdField_c_of_type_Int;
              }
              this.jdField_b_of_type_Float = f1;
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.jdField_c_of_type_Float = f1;
        this.jdField_a_of_type_Float = f1;
        f1 = paramMotionEvent.getY();
        this.d = f1;
        this.jdField_b_of_type_Float = f1;
        this.jdField_b_of_type_Int = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Int = 0;
        localObject = this.jdField_a_of_type_AndroidViewMotionEvent;
        if (localObject != null) {
          ((MotionEvent)localObject).recycle();
        }
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Down at ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
        ((StringBuilder)localObject).append(" mIsBeingDragged=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("mIsUnableToDrag=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
      }
      return this.jdField_a_of_type_Int;
    }
    Log.v(this.jdField_a_of_type_JavaLangString, "Intercept done!");
    i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout.FakeViewPager
 * JD-Core Version:    0.7.0.1
 */