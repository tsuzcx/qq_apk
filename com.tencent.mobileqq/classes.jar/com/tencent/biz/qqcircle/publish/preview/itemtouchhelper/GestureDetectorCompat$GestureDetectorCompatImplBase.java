package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class GestureDetectorCompat$GestureDetectorCompatImplBase
  implements GestureDetectorCompat.GestureDetectorCompatImpl
{
  private static final int j = ;
  private static final int k = ViewConfiguration.getTapTimeout();
  private static final int l = ViewConfiguration.getDoubleTapTimeout();
  final GestureDetector.OnGestureListener a;
  GestureDetector.OnDoubleTapListener b;
  boolean c;
  boolean d;
  MotionEvent e;
  private int f;
  private int g;
  private int h;
  private int i;
  private final Handler m;
  private boolean n;
  private boolean o;
  private boolean p;
  private MotionEvent q;
  private boolean r;
  private float s;
  private float t;
  private float u;
  private float v;
  private boolean w;
  private VelocityTracker x;
  
  public GestureDetectorCompat$GestureDetectorCompatImplBase(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (paramHandler != null) {
      this.m = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this, paramHandler);
    } else {
      this.m = new GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(this);
    }
    this.a = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      a((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (this.a != null)
      {
        this.w = true;
        paramContext = ViewConfiguration.get(paramContext);
        int i1 = paramContext.getScaledTouchSlop();
        int i2 = paramContext.getScaledDoubleTapSlop();
        this.h = paramContext.getScaledMinimumFlingVelocity();
        this.i = paramContext.getScaledMaximumFlingVelocity();
        this.f = (i1 * i1);
        this.g = (i2 * i2);
        return;
      }
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    throw new IllegalArgumentException("Context must not be null");
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    boolean bool2 = this.p;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > l) {
      return false;
    }
    int i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
    int i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    if (i1 * i1 + i2 * i2 < this.g) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b()
  {
    this.m.removeMessages(1);
    this.m.removeMessages(2);
    this.m.removeMessages(3);
    this.x.recycle();
    this.x = null;
    this.r = false;
    this.c = false;
    this.o = false;
    this.p = false;
    this.d = false;
    if (this.n) {
      this.n = false;
    }
  }
  
  private void c()
  {
    this.m.removeMessages(1);
    this.m.removeMessages(2);
    this.m.removeMessages(3);
    this.r = false;
    this.o = false;
    this.p = false;
    this.d = false;
    if (this.n) {
      this.n = false;
    }
  }
  
  void a()
  {
    this.m.removeMessages(3);
    this.d = false;
    this.n = true;
    this.a.onLongPress(this.e);
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.b = paramOnDoubleTapListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (this.x == null) {
      this.x = VelocityTracker.obtain();
    }
    this.x.addMovement(paramMotionEvent);
    int i5 = i1 & 0xFF;
    boolean bool3 = false;
    if (i5 == 6) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = paramMotionEvent.getActionIndex();
    } else {
      i2 = -1;
    }
    int i4 = paramMotionEvent.getPointerCount();
    int i3 = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i3 < i4)
    {
      if (i2 != i3)
      {
        f2 += paramMotionEvent.getX(i3);
        f1 += paramMotionEvent.getY(i3);
      }
      i3 += 1;
    }
    if (i1 != 0) {
      i1 = i4 - 1;
    } else {
      i1 = i4;
    }
    float f3 = i1;
    f2 /= f3;
    f1 /= f3;
    boolean bool2;
    MotionEvent localMotionEvent;
    Object localObject;
    if (i5 != 0)
    {
      if (i5 != 1)
      {
        if (i5 != 2)
        {
          if (i5 != 3)
          {
            if (i5 != 5)
            {
              if (i5 != 6) {
                return false;
              }
              this.s = f2;
              this.u = f2;
              this.t = f1;
              this.v = f1;
              this.x.computeCurrentVelocity(1000, this.i);
              i2 = paramMotionEvent.getActionIndex();
              i1 = paramMotionEvent.getPointerId(i2);
              f1 = this.x.getXVelocity(i1);
              f2 = this.x.getYVelocity(i1);
              i1 = 0;
              for (;;)
              {
                bool2 = bool3;
                if (i1 >= i4) {
                  break;
                }
                if (i1 != i2)
                {
                  i3 = paramMotionEvent.getPointerId(i1);
                  if (this.x.getXVelocity(i3) * f1 + this.x.getYVelocity(i3) * f2 < 0.0F)
                  {
                    this.x.clear();
                    return false;
                  }
                }
                i1 += 1;
              }
            }
            this.s = f2;
            this.u = f2;
            this.t = f1;
            this.v = f1;
            c();
            return false;
          }
          b();
          return false;
        }
        if (this.n) {
          return false;
        }
        f3 = this.s - f2;
        float f4 = this.t - f1;
        if (this.r) {
          return false | this.b.onDoubleTapEvent(paramMotionEvent);
        }
        if (this.o)
        {
          i1 = (int)(f2 - this.u);
          i2 = (int)(f1 - this.v);
          i1 = i1 * i1 + i2 * i2;
          if (i1 > this.f)
          {
            bool2 = this.a.onScroll(this.e, paramMotionEvent, f3, f4);
            this.s = f2;
            this.t = f1;
            this.o = false;
            this.m.removeMessages(3);
            this.m.removeMessages(1);
            this.m.removeMessages(2);
          }
          else
          {
            bool2 = false;
          }
          bool3 = bool2;
          if (i1 > this.f)
          {
            this.p = false;
            bool3 = bool2;
          }
        }
        else
        {
          if (Math.abs(f3) < 1.0F)
          {
            bool2 = bool3;
            if (Math.abs(f4) < 1.0F) {
              break label1157;
            }
          }
          bool2 = this.a.onScroll(this.e, paramMotionEvent, f3, f4);
          this.s = f2;
          this.t = f1;
          return bool2;
        }
      }
      else
      {
        this.c = false;
        localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.r)
        {
          bool2 = this.b.onDoubleTapEvent(paramMotionEvent) | false;
        }
        else
        {
          if (this.n)
          {
            this.m.removeMessages(3);
            this.n = false;
          }
          else
          {
            if (this.o)
            {
              bool2 = this.a.onSingleTapUp(paramMotionEvent);
              if (this.d)
              {
                localObject = this.b;
                if (localObject != null) {
                  ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMotionEvent);
                }
              }
              break label820;
            }
            localObject = this.x;
            i1 = paramMotionEvent.getPointerId(0);
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.i);
            f1 = ((VelocityTracker)localObject).getYVelocity(i1);
            f2 = ((VelocityTracker)localObject).getXVelocity(i1);
            if ((Math.abs(f1) > this.h) || (Math.abs(f2) > this.h)) {
              break label802;
            }
          }
          bool2 = false;
          break label820;
          label802:
          bool2 = this.a.onFling(this.e, paramMotionEvent, f2, f1);
        }
        label820:
        paramMotionEvent = this.q;
        if (paramMotionEvent != null) {
          paramMotionEvent.recycle();
        }
        this.q = localMotionEvent;
        paramMotionEvent = this.x;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.x = null;
        }
        this.r = false;
        this.d = false;
        this.m.removeMessages(1);
        this.m.removeMessages(2);
        bool3 = bool2;
      }
      return bool3;
    }
    else
    {
      boolean bool1;
      if (this.b != null)
      {
        bool2 = this.m.hasMessages(3);
        if (bool2) {
          this.m.removeMessages(3);
        }
        localMotionEvent = this.e;
        if (localMotionEvent != null)
        {
          localObject = this.q;
          if ((localObject != null) && (bool2) && (a(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.r = true;
            bool1 = this.b.onDoubleTap(this.e) | false | this.b.onDoubleTapEvent(paramMotionEvent);
            break label1011;
          }
        }
        this.m.sendEmptyMessageDelayed(3, l);
      }
      else
      {
        bool1 = false;
      }
      label1011:
      this.s = f2;
      this.u = f2;
      this.t = f1;
      this.v = f1;
      localMotionEvent = this.e;
      if (localMotionEvent != null) {
        localMotionEvent.recycle();
      }
      this.e = MotionEvent.obtain(paramMotionEvent);
      this.o = true;
      this.p = true;
      this.c = true;
      this.n = false;
      this.d = false;
      if (this.w)
      {
        this.m.removeMessages(2);
        this.m.sendEmptyMessageAtTime(2, this.e.getDownTime() + k + j);
      }
      this.m.sendEmptyMessageAtTime(1, this.e.getDownTime() + k);
      bool2 = bool1 | this.a.onDown(paramMotionEvent);
    }
    label1157:
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.GestureDetectorCompat.GestureDetectorCompatImplBase
 * JD-Core Version:    0.7.0.1
 */