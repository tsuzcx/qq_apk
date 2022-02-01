package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class InterceptTouchRelativeLayout$FakeViewPager
{
  private String a;
  private int b = 0;
  private boolean c;
  private int d = -1;
  private float e;
  private float f;
  private float g;
  private float h;
  private MotionEvent i;
  private int j;
  
  public InterceptTouchRelativeLayout$FakeViewPager(Context paramContext, String paramString)
  {
    this.j = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
    this.a = paramString;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction() & 0xFF;
    int k = 3;
    if ((n != 3) && (n != 1))
    {
      Object localObject;
      if (n != 0)
      {
        if (this.b != 0)
        {
          paramMotionEvent = this.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Intercept returning true! ");
          ((StringBuilder)localObject).append(this.b);
          Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
          return this.b;
        }
        if (this.c)
        {
          Log.v(this.a, "Intercept returning false!");
          return 0;
        }
      }
      float f1;
      if (n != 0)
      {
        int m = 2;
        if (n == 2)
        {
          n = this.d;
          if (n != -1)
          {
            n = MotionEventCompat.findPointerIndex(paramMotionEvent, n);
            f1 = MotionEventCompat.getX(paramMotionEvent, n);
            float f3 = f1 - this.e;
            float f4 = Math.abs(f3);
            float f2 = MotionEventCompat.getY(paramMotionEvent, n);
            float f5 = f2 - this.f;
            float f6 = Math.abs(f5);
            paramMotionEvent = this.a;
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
            ((StringBuilder)localObject).append(this.j);
            Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
            if ((f4 > this.j) && (f4 > f6))
            {
              Log.v(this.a, "Starting drag horizontal !");
              if (f3 <= 0.0F) {
                k = 1;
              }
              this.b = k;
              if (f3 > 0.0F) {
                f1 = this.g + this.j;
              } else {
                f1 = this.g - this.j;
              }
              this.e = f1;
              this.f = f2;
            }
            else if ((f6 > this.j) && (f6 > f4))
            {
              Log.v(this.a, "Starting drag vertical !");
              k = m;
              if (f5 > 0.0F) {
                k = 4;
              }
              this.b = k;
              this.e = f1;
              if (f5 > 0.0F) {
                f1 = this.h + this.j;
              } else {
                f1 = this.h - this.j;
              }
              this.f = f1;
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.g = f1;
        this.e = f1;
        f1 = paramMotionEvent.getY();
        this.h = f1;
        this.f = f1;
        this.d = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.c = false;
        this.b = 0;
        localObject = this.i;
        if (localObject != null) {
          ((MotionEvent)localObject).recycle();
        }
        this.i = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Down at ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" mIsBeingDragged=");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("mIsUnableToDrag=");
        ((StringBuilder)localObject).append(this.c);
        Log.v(paramMotionEvent, ((StringBuilder)localObject).toString());
      }
      return this.b;
    }
    Log.v(this.a, "Intercept done!");
    k = this.b;
    this.b = 0;
    this.c = false;
    this.d = -1;
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout.FakeViewPager
 * JD-Core Version:    0.7.0.1
 */