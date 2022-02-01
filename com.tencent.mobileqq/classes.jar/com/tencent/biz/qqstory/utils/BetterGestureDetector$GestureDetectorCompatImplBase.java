package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class BetterGestureDetector$GestureDetectorCompatImplBase
  implements BetterGestureDetector.GestureDetectorCompatImpl
{
  private static int jdField_e_of_type_Int = ;
  private static final int jdField_f_of_type_Int = ViewConfiguration.getTapTimeout();
  private static final int jdField_g_of_type_Int = ViewConfiguration.getDoubleTapTimeout();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  GestureDetector.OnDoubleTapListener jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
  final GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  
  public BetterGestureDetector$GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = new BetterGestureDetector.GestureDetectorCompatImplBase.GestureHandler(this, paramHandler);
    } else {
      this.jdField_a_of_type_AndroidOsHandler = new BetterGestureDetector.GestureDetectorCompatImplBase.GestureHandler(this);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      a((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener != null)
      {
        this.jdField_g_of_type_Boolean = true;
        paramContext = ViewConfiguration.get(paramContext);
        int i = paramContext.getScaledTouchSlop();
        int j = paramContext.getScaledDoubleTapSlop();
        this.jdField_c_of_type_Int = paramContext.getScaledMinimumFlingVelocity();
        this.jdField_d_of_type_Int = paramContext.getScaledMaximumFlingVelocity();
        this.jdField_a_of_type_Int = (i * i);
        this.jdField_b_of_type_Int = (j * j);
        return;
      }
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    throw new IllegalArgumentException("Context must not be null");
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    boolean bool2 = this.jdField_e_of_type_Boolean;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > jdField_g_of_type_Int) {
      return false;
    }
    int i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
    int j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    if (i * i + j * j < this.jdField_b_of_type_Int) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onLongPress(this.jdField_a_of_type_AndroidViewMotionEvent);
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener = paramOnDoubleTapListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int n = i & 0xFF;
    boolean bool3 = false;
    if (n == 6) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramMotionEvent.getActionIndex();
    } else {
      j = -1;
    }
    int m = paramMotionEvent.getPointerCount();
    int k = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (k < m)
    {
      if (j != k)
      {
        f2 += paramMotionEvent.getX(k);
        f1 += paramMotionEvent.getY(k);
      }
      k += 1;
    }
    if (i != 0) {
      i = m - 1;
    } else {
      i = m;
    }
    float f3 = i;
    f2 /= f3;
    f1 /= f3;
    boolean bool2;
    MotionEvent localMotionEvent;
    Object localObject;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 5)
            {
              if (n != 6) {
                return false;
              }
              this.jdField_a_of_type_Float = f2;
              this.jdField_c_of_type_Float = f2;
              this.jdField_b_of_type_Float = f1;
              this.jdField_d_of_type_Float = f1;
              this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
              j = paramMotionEvent.getActionIndex();
              i = paramMotionEvent.getPointerId(j);
              f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i);
              f2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
              i = 0;
              for (;;)
              {
                bool2 = bool3;
                if (i >= m) {
                  break;
                }
                if (i != j)
                {
                  k = paramMotionEvent.getPointerId(i);
                  if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(k) * f1 + this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(k) * f2 < 0.0F)
                  {
                    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
                    return false;
                  }
                }
                i += 1;
              }
            }
            this.jdField_a_of_type_Float = f2;
            this.jdField_c_of_type_Float = f2;
            this.jdField_b_of_type_Float = f1;
            this.jdField_d_of_type_Float = f1;
            c();
            return false;
          }
          b();
          return false;
        }
        if ((this.jdField_c_of_type_Boolean) && (!this.h)) {
          return false;
        }
        f3 = this.jdField_a_of_type_Float - f2;
        float f4 = this.jdField_b_of_type_Float - f1;
        if (this.jdField_f_of_type_Boolean) {
          return false | this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
        }
        if (this.jdField_d_of_type_Boolean)
        {
          i = (int)(f2 - this.jdField_c_of_type_Float);
          j = (int)(f1 - this.jdField_d_of_type_Float);
          i = i * i + j * j;
          if (i > this.jdField_a_of_type_Int)
          {
            bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onScroll(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f3, f4);
            this.jdField_a_of_type_Float = f2;
            this.jdField_b_of_type_Float = f1;
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          }
          else
          {
            bool2 = false;
          }
          bool3 = bool2;
          if (i > this.jdField_a_of_type_Int)
          {
            this.jdField_e_of_type_Boolean = false;
            bool3 = bool2;
          }
        }
        else
        {
          if (Math.abs(f3) < 1.0F)
          {
            bool2 = bool3;
            if (Math.abs(f4) < 1.0F) {
              break label1164;
            }
          }
          bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onScroll(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f3, f4);
          this.jdField_a_of_type_Float = f2;
          this.jdField_b_of_type_Float = f1;
          return bool2;
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.jdField_f_of_type_Boolean)
        {
          bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
        }
        else
        {
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
            this.jdField_c_of_type_Boolean = false;
          }
          else
          {
            if (this.jdField_d_of_type_Boolean)
            {
              bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onSingleTapUp(paramMotionEvent);
              if (this.jdField_b_of_type_Boolean)
              {
                localObject = this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener;
                if (localObject != null) {
                  ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMotionEvent);
                }
              }
              break label827;
            }
            localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
            i = paramMotionEvent.getPointerId(0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_d_of_type_Int);
            f1 = ((VelocityTracker)localObject).getYVelocity(i);
            f2 = ((VelocityTracker)localObject).getXVelocity(i);
            if ((Math.abs(f1) > this.jdField_c_of_type_Int) || (Math.abs(f2) > this.jdField_c_of_type_Int)) {
              break label809;
            }
          }
          bool2 = false;
          break label827;
          label809:
          bool2 = this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onFling(this.jdField_a_of_type_AndroidViewMotionEvent, paramMotionEvent, f2, f1);
        }
        label827:
        paramMotionEvent = this.jdField_b_of_type_AndroidViewMotionEvent;
        if (paramMotionEvent != null) {
          paramMotionEvent.recycle();
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = localMotionEvent;
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        bool3 = bool2;
      }
      return bool3;
    }
    else
    {
      boolean bool1;
      if (this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener != null)
      {
        bool2 = this.jdField_a_of_type_AndroidOsHandler.hasMessages(3);
        if (bool2) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        }
        localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
        if (localMotionEvent != null)
        {
          localObject = this.jdField_b_of_type_AndroidViewMotionEvent;
          if ((localObject != null) && (bool2) && (a(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.jdField_f_of_type_Boolean = true;
            bool1 = this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTap(this.jdField_a_of_type_AndroidViewMotionEvent) | false | this.jdField_a_of_type_AndroidViewGestureDetector$OnDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
            break label1018;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, jdField_g_of_type_Int);
      }
      else
      {
        bool1 = false;
      }
      label1018:
      this.jdField_a_of_type_Float = f2;
      this.jdField_c_of_type_Float = f2;
      this.jdField_b_of_type_Float = f1;
      this.jdField_d_of_type_Float = f1;
      localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
      if (localMotionEvent != null) {
        localMotionEvent.recycle();
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      this.jdField_d_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(2, this.jdField_a_of_type_AndroidViewMotionEvent.getDownTime() + jdField_f_of_type_Int + jdField_e_of_type_Int);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageAtTime(1, this.jdField_a_of_type_AndroidViewMotionEvent.getDownTime() + jdField_f_of_type_Int);
      bool2 = bool1 | this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener.onDown(paramMotionEvent);
    }
    label1164:
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.BetterGestureDetector.GestureDetectorCompatImplBase
 * JD-Core Version:    0.7.0.1
 */