package com.tencent.map.sdk.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

public final class if
  implements View.OnTouchListener
{
  private static final float c = (float)Math.cos(0.001745329278001762D);
  public ig a;
  public lg b;
  private boolean d;
  private boolean e;
  private int f = 0;
  private PointF g = new PointF();
  private PointF h = new PointF();
  private PointF i = new PointF();
  private PointF j = new PointF();
  private PointF k = new PointF();
  private PointF l = new PointF();
  private PointF m = new PointF();
  private long n = 0L;
  private GestureDetector o;
  private WeakReference<pt> p;
  
  static
  {
    os.b("MapGestureDetector");
  }
  
  public if(pt parampt)
  {
    this.p = new WeakReference(parampt);
    if (parampt.ay != null) {
      this.o = new GestureDetector(parampt.ay, new if.a(this, (byte)0));
    } else {
      this.o = new GestureDetector(new if.a(this, (byte)0));
    }
    this.a = new ig();
  }
  
  private static void a(PointF paramPointF1, PointF paramPointF2, MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getX(1);
      float f3 = paramMotionEvent.getY(0);
      float f4 = paramMotionEvent.getY(1);
      paramPointF1.set(f1, f3);
      paramPointF2.set(f2, f4);
      return;
    }
    catch (Exception paramPointF1) {}
  }
  
  public final void a(gr paramgr)
  {
    synchronized (this.a)
    {
      this.a.a(paramgr);
      return;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      double d1;
      double d2;
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if ((i1 != 6) || (this.e)) {
                break label2499;
              }
              this.e = true;
              this.a.d();
              return true;
            }
            this.n = System.currentTimeMillis();
            this.f = 0;
            this.d = true;
            this.e = false;
            a(this.i, this.j, paramMotionEvent);
            this.a.c();
            return true;
          }
        }
        else
        {
          if ((this.d) && (!this.e))
          {
            a(this.g, this.h, paramMotionEvent);
            float f3 = this.g.x - this.i.x;
            float f1 = this.g.y - this.i.y;
            float f4 = this.h.x - this.j.x;
            float f2 = this.h.y - this.j.y;
            paramView = os.a("MapGestureDetector");
            "point1MoveX:".concat(String.valueOf(f3));
            "point1MoveY:".concat(String.valueOf(f1));
            "point2MoveX:".concat(String.valueOf(f4));
            "point2MoveY:".concat(String.valueOf(f2));
            paramView.a();
            d1 = Math.abs(f1);
            d2 = Math.abs(f3);
            Double.isNaN(d2);
            if (d1 > d2 * 1.5D)
            {
              d1 = Math.abs(f2);
              d2 = Math.abs(f4);
              Double.isNaN(d2);
              if (d1 > d2 * 1.5D)
              {
                i1 = 1;
                break label336;
              }
            }
            i1 = 0;
            label336:
            d1 = Math.abs(f1);
            d2 = Math.abs(f3);
            Double.isNaN(d2);
            if (d1 > d2 * 1.5D)
            {
              d1 = Math.abs(f2);
              d2 = Math.abs(f4);
              Double.isNaN(d2);
              if (d1 > d2 * 1.5D)
              {
                i2 = 1;
                break label409;
              }
            }
            int i2 = 0;
            label409:
            d1 = Math.abs(f3);
            d2 = Math.abs(f1);
            Double.isNaN(d2);
            if (d1 > d2 * 1.5D)
            {
              d1 = Math.abs(f4);
              d2 = Math.abs(f2);
              Double.isNaN(d2);
              if (d1 > d2 * 1.5D)
              {
                i3 = 1;
                break label482;
              }
            }
            int i3 = 0;
            label482:
            d1 = Math.abs(f3);
            d2 = Math.abs(f1);
            Double.isNaN(d2);
            if (d1 > d2 * 1.5D)
            {
              d1 = Math.abs(f4);
              d2 = Math.abs(f2);
              Double.isNaN(d2);
              if (d1 > d2 * 1.5D)
              {
                i4 = 1;
                break label555;
              }
            }
            int i4 = 0;
            label555:
            boolean bool3;
            if (f3 * f4 > 0.0F) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            boolean bool4;
            if (f1 * f2 > 0.0F) {
              bool4 = true;
            } else {
              bool4 = false;
            }
            int i5 = this.f;
            d2 = 2.0D;
            if (((i5 & 0x8) != 0) && ((i5 & 0x1) != 0)) {
              d1 = 2.0D;
            } else {
              d1 = 6.0D;
            }
            boolean bool1;
            if ((Math.abs(f3) <= d1) && (Math.abs(f1) <= d1) && (Math.abs(f4) <= d1) && (Math.abs(f2) <= d1)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            boolean bool2;
            if ((bool1) && (bool3) && ((i3 != 0) || (i4 != 0))) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            boolean bool5;
            if ((bool1) && (bool4) && ((i1 != 0) || (i2 != 0))) {
              bool5 = true;
            } else {
              bool5 = false;
            }
            double d8 = this.j.x - this.i.x;
            float f5 = this.j.y;
            float f6 = this.i.y;
            boolean bool7 = bool2;
            double d9 = f5 - f6;
            double d10 = this.h.x - this.g.x;
            boolean bool8 = bool1;
            double d11 = this.h.y - this.g.y;
            Double.isNaN(d8);
            Double.isNaN(d8);
            Double.isNaN(d9);
            Double.isNaN(d9);
            double d4 = Math.sqrt(d8 * d8 + d9 * d9);
            Double.isNaN(d10);
            Double.isNaN(d10);
            Double.isNaN(d11);
            Double.isNaN(d11);
            double d5 = Math.sqrt(d10 * d10 + d11 * d11);
            Double.isNaN(d8);
            Double.isNaN(d10);
            Double.isNaN(d9);
            Double.isNaN(d11);
            double d7 = d4 * d5;
            double d6 = (d8 * d10 + d9 * d11) / d7;
            double d3 = Math.acos(d6) * 180.0D / 3.141592653589793D;
            Double.isNaN(d8);
            Double.isNaN(d11);
            Double.isNaN(d9);
            Double.isNaN(d10);
            d1 = d3;
            if (d8 * d11 - d9 * d10 < 0.0D) {
              d1 = -d3;
            }
            boolean bool6;
            if (Math.abs(d6) < c) {
              bool6 = true;
            } else {
              bool6 = false;
            }
            if ((this.f & 0x2) != 0) {
              d2 = 0.5D;
            }
            if ((d7 > 0.0D) && (bool6) && (Math.abs(d1) > d2)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            d7 = d5 / d4;
            if ((this.f & 0x4) == 0) {
              d3 = 0.006D;
            } else {
              d3 = 0.003D;
            }
            if ((d4 > 0.0D) && (Math.abs(d7 - 1.0D) > d3)) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            if (bool1)
            {
              bool2 = false;
              bool8 = false;
            }
            if (bool5)
            {
              bool2 = false;
              bool1 = false;
              bool7 = false;
            }
            paramView = os.a("MapGestureDetector");
            "beganMove:".concat(String.valueOf(bool8));
            "vertical:".concat(String.valueOf(bool4));
            "horizontal:".concat(String.valueOf(bool3));
            "verticalMove:".concat(String.valueOf(bool5));
            "horizontalMove:".concat(String.valueOf(bool7));
            paramView.a();
            paramView = os.a("MapGestureDetector");
            "beganRotate:".concat(String.valueOf(bool1));
            "cosValue : ".concat(String.valueOf(d6));
            "cosAngle : ".concat(String.valueOf(bool6));
            "angle:".concat(String.valueOf(d1));
            "rotateJudge : ".concat(String.valueOf(d2));
            paramView.a();
            paramView = os.a("MapGestureDetector");
            "beganScale:".concat(String.valueOf(bool2));
            "d1:".concat(String.valueOf(d4));
            paramMotionEvent = new StringBuilder("scale - 1 = ");
            paramMotionEvent.append(Math.abs(d7 - 1.0D));
            paramMotionEvent.toString();
            "scaleJudge : ".concat(String.valueOf(d3));
            paramView.a();
            if (bool8)
            {
              if (bool7)
              {
                this.f |= 0x8;
                os.a("MapGestureDetector").a();
                f3 = (f3 + f4) / 2.0F;
                f4 = (f1 + f2) / 2.0F;
                this.a.d(f3, f4);
              }
              if (bool5)
              {
                this.f |= 0x1;
                os.a("MapGestureDetector").a();
                this.i.set(this.g.x, this.g.y);
                this.j.set(this.h.x, this.h.y);
                paramView = this.a;
                if (Math.abs(f1) <= Math.abs(f2)) {
                  f1 = f2;
                }
                paramView.a(f1);
              }
            }
            if (bool1)
            {
              this.f |= 0x2;
              os.a("MapGestureDetector").a();
              paramView = this.j;
              paramMotionEvent = this.i;
              PointF localPointF1 = this.h;
              PointF localPointF2 = this.g;
              if ((paramMotionEvent.x != paramView.x) && (localPointF2.x != localPointF1.x))
              {
                f3 = (paramMotionEvent.y - paramView.y) / (paramMotionEvent.x - paramView.x);
                f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
                if (f3 != f1)
                {
                  f4 = (paramView.y * paramMotionEvent.x - paramMotionEvent.y * paramView.x) / (paramMotionEvent.x - paramView.x);
                  f2 = (localPointF1.y * localPointF2.x - localPointF2.y * localPointF1.x) / (localPointF2.x - localPointF1.x);
                  f3 = (f2 - f4) / (f3 - f1);
                  paramView = new PointF(f3, f1 * f3 + f2);
                  break label1769;
                }
              }
              paramView = null;
              label1769:
              if (paramView != null)
              {
                f3 = paramView.x;
                f4 = paramView.y;
                paramView = this.b;
                if (paramView == null) {
                  i1 = 0;
                } else {
                  i1 = paramView.h().width() / 2;
                }
                paramView = this.b;
                if (paramView == null) {
                  i2 = 0;
                } else {
                  i2 = paramView.h().height() / 2;
                }
                paramView = this.b;
                if (paramView == null) {
                  f1 = 0.0F;
                } else {
                  f1 = paramView.h().width() / 3.0F;
                }
                paramView = this.b;
                if (paramView == null) {
                  f2 = 0.0F;
                } else {
                  f2 = paramView.h().height() / 3.0F;
                }
                if ((Math.abs(f3 - i1) < f1) && (Math.abs(f4 - i2) < f2))
                {
                  i1 = 1;
                  break label1942;
                }
              }
              i1 = 0;
              label1942:
              if (i1 != 0)
              {
                paramView = this.b;
                if (paramView == null) {
                  i1 = 0;
                } else {
                  i1 = paramView.h().width() / 2;
                }
                paramView = this.b;
                if (paramView == null) {
                  i2 = 0;
                } else {
                  i2 = paramView.h().height() / 2;
                }
                this.m.set(i1, i2);
                paramView = this.a;
                paramMotionEvent = this.m;
                paramView.a(paramMotionEvent, paramMotionEvent, (float)d1);
              }
              else
              {
                this.k.set((this.i.x + this.j.x) / 2.0F, (this.i.y + this.j.y) / 2.0F);
                this.l.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
                this.a.a(this.k, this.l, (float)d1);
              }
            }
            if (bool2)
            {
              this.f |= 0x4;
              os.a("MapGestureDetector").a();
              this.k.set((this.i.x + this.j.x) / 2.0F, (this.i.y + this.j.y) / 2.0F);
              this.l.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
              this.a.a(this.k, this.l, d4, d5);
            }
            this.i.set(this.g.x, this.g.y);
            this.j.set(this.h.x, this.h.y);
            return true;
          }
          this.a.k(paramMotionEvent.getX(), paramMotionEvent.getY());
          break label2499;
        }
      }
      long l1 = System.currentTimeMillis() - this.n;
      if ((this.f == 0) && (l1 > 0L) && (l1 < 200L))
      {
        d1 = this.i.x - this.j.x;
        d2 = this.i.y - this.j.y;
        Double.isNaN(d1);
        Double.isNaN(d1);
        Double.isNaN(d2);
        Double.isNaN(d2);
        if (d1 * d1 + d2 * d2 > 2500.0D) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          this.a.b();
        }
      }
      this.a.j(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    else
    {
      this.n = 0L;
      this.d = false;
      this.a.i(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    label2499:
    if (!this.d) {
      this.o.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.if
 * JD-Core Version:    0.7.0.1
 */