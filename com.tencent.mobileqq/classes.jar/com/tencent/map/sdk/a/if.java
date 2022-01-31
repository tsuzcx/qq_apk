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
    if (parampt.ay != null) {}
    for (this.o = new GestureDetector(parampt.ay, new if.a(this, (byte)0));; this.o = new GestureDetector(new if.a(this, (byte)0)))
    {
      this.a = new ig();
      return;
    }
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
    double d1;
    double d2;
    int i1;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 1: 
    case 3: 
    case 6: 
      label262:
      do
      {
        for (;;)
        {
          if (!this.d) {
            this.o.onTouchEvent(paramMotionEvent);
          }
          return true;
          this.n = 0L;
          this.d = false;
          this.a.i(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        this.n = System.currentTimeMillis();
        this.f = 0;
        this.d = true;
        this.e = false;
        a(this.i, this.j, paramMotionEvent);
        this.a.c();
        return true;
        long l1 = System.currentTimeMillis() - this.n;
        if ((this.f == 0) && (l1 > 0L) && (l1 < 200L))
        {
          d1 = this.i.x - this.j.x;
          d2 = this.i.y - this.j.y;
          if (d1 * d1 + d2 * d2 <= 2500.0D) {
            break label262;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            this.a.b();
          }
          this.a.j(paramMotionEvent.getX(), paramMotionEvent.getY());
          break;
        }
      } while (this.e);
      this.e = true;
      this.a.d();
      return true;
    }
    float f3;
    float f1;
    float f4;
    float f2;
    int i2;
    label524:
    int i3;
    label567:
    int i4;
    label610:
    boolean bool5;
    label623:
    boolean bool6;
    label636:
    boolean bool2;
    label659:
    label706:
    boolean bool1;
    label729:
    boolean bool7;
    label752:
    double d3;
    double d6;
    double d7;
    double d4;
    double d5;
    boolean bool8;
    label944:
    label958:
    boolean bool3;
    label986:
    label1007:
    boolean bool4;
    if ((this.d) && (!this.e))
    {
      a(this.g, this.h, paramMotionEvent);
      f3 = this.g.x - this.i.x;
      f1 = this.g.y - this.i.y;
      f4 = this.h.x - this.j.x;
      f2 = this.h.y - this.j.y;
      paramView = os.a("MapGestureDetector");
      "point1MoveX:".concat(String.valueOf(f3));
      "point1MoveY:".concat(String.valueOf(f1));
      "point2MoveX:".concat(String.valueOf(f4));
      "point2MoveY:".concat(String.valueOf(f2));
      paramView.a();
      if ((Math.abs(f1) > Math.abs(f3) * 1.5D) && (Math.abs(f2) > Math.abs(f4) * 1.5D))
      {
        i1 = 1;
        if ((Math.abs(f1) <= Math.abs(f3) * 1.5D) || (Math.abs(f2) <= Math.abs(f4) * 1.5D)) {
          break label1798;
        }
        i2 = 1;
        if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
          break label1804;
        }
        i3 = 1;
        if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
          break label1810;
        }
        i4 = 1;
        if (f3 * f4 <= 0.0F) {
          break label1816;
        }
        bool5 = true;
        if (f1 * f2 <= 0.0F) {
          break label1822;
        }
        bool6 = true;
        if (((this.f & 0x8) != 0) && ((this.f & 0x1) != 0)) {
          break label1828;
        }
        d1 = 6.0D;
        if ((Math.abs(f3) <= d1) && (Math.abs(f1) <= d1) && (Math.abs(f4) <= d1) && (Math.abs(f2) <= d1)) {
          break label1835;
        }
        bool2 = true;
        if ((!bool2) || (!bool5) || ((i3 == 0) && (i4 == 0))) {
          break label1841;
        }
        bool1 = true;
        if ((!bool2) || (!bool6) || ((i1 == 0) && (i2 == 0))) {
          break label1847;
        }
        bool7 = true;
        d3 = this.j.x - this.i.x;
        d6 = this.j.y - this.i.y;
        d7 = this.h.x - this.g.x;
        double d8 = this.h.y - this.g.y;
        d4 = Math.sqrt(d3 * d3 + d6 * d6);
        d5 = Math.sqrt(d7 * d7 + d8 * d8);
        d2 = 180.0D * Math.acos((d3 * d7 + d6 * d8) / (d4 * d5)) / 3.141592653589793D;
        d1 = d2;
        if (d3 * d8 - d6 * d7 < 0.0D) {
          d1 = -d2;
        }
        d6 = (d3 * d7 + d6 * d8) / (d4 * d5);
        if (Math.abs(d6) >= c) {
          break label1853;
        }
        bool8 = true;
        if ((this.f & 0x2) != 0) {
          break label1859;
        }
        d2 = 2.0D;
        if ((d4 * d5 <= 0.0D) || (!bool8) || (Math.abs(d1) <= d2)) {
          break label1867;
        }
        bool3 = true;
        d7 = d5 / d4;
        if ((this.f & 0x4) != 0) {
          break label1873;
        }
        d3 = 0.006D;
        if ((d4 <= 0.0D) || (Math.abs(d7 - 1.0D) <= d3)) {
          break label1881;
        }
        bool4 = true;
        label1030:
        if (bool3)
        {
          bool2 = false;
          bool4 = false;
        }
        if (!bool7) {
          break label2303;
        }
        bool1 = false;
        bool4 = false;
        bool3 = false;
      }
    }
    for (;;)
    {
      paramView = os.a("MapGestureDetector");
      "beganMove:".concat(String.valueOf(bool2));
      "vertical:".concat(String.valueOf(bool6));
      "horizontal:".concat(String.valueOf(bool5));
      "verticalMove:".concat(String.valueOf(bool7));
      "horizontalMove:".concat(String.valueOf(bool1));
      paramView.a();
      paramView = os.a("MapGestureDetector");
      "beganRotate:".concat(String.valueOf(bool4));
      "cosValue : ".concat(String.valueOf(d6));
      "cosAngle : ".concat(String.valueOf(bool8));
      "angle:".concat(String.valueOf(d1));
      "rotateJudge : ".concat(String.valueOf(d2));
      paramView.a();
      paramView = os.a("MapGestureDetector");
      "beganScale:".concat(String.valueOf(bool3));
      "d1:".concat(String.valueOf(d4));
      new StringBuilder("scale - 1 = ").append(Math.abs(d7 - 1.0D)).toString();
      "scaleJudge : ".concat(String.valueOf(d3));
      paramView.a();
      if (bool2)
      {
        if (bool1)
        {
          this.f |= 0x8;
          os.a("MapGestureDetector").a();
          f3 = (f3 + f4) / 2.0F;
          f4 = (f1 + f2) / 2.0F;
          this.a.d(f3, f4);
        }
        if (bool7)
        {
          this.f |= 0x1;
          os.a("MapGestureDetector").a();
          this.i.set(this.g.x, this.g.y);
          this.j.set(this.h.x, this.h.y);
          paramView = this.a;
          if (Math.abs(f1) <= Math.abs(f2)) {
            break label1887;
          }
          label1398:
          paramView.a(f1);
        }
      }
      PointF localPointF1;
      PointF localPointF2;
      if (bool4)
      {
        this.f |= 0x2;
        os.a("MapGestureDetector").a();
        paramView = this.j;
        paramMotionEvent = this.i;
        localPointF1 = this.h;
        localPointF2 = this.g;
        if ((paramMotionEvent.x != paramView.x) && (localPointF2.x != localPointF1.x)) {
          break label1894;
        }
        paramView = null;
        label1478:
        if (paramView == null) {
          break label2137;
        }
        f3 = paramView.x;
        f4 = paramView.y;
        if (this.b != null) {
          break label2055;
        }
        i1 = 0;
        label1504:
        if (this.b != null) {
          break label2074;
        }
        i2 = 0;
        label1514:
        if (this.b != null) {
          break label2093;
        }
        f1 = 0.0F;
        label1524:
        if (this.b != null) {
          break label2115;
        }
        f2 = 0.0F;
        label1534:
        if ((Math.abs(f3 - i1) >= f1) || (Math.abs(f4 - i2) >= f2)) {
          break label2137;
        }
        i1 = 1;
        label1567:
        if (i1 == 0) {
          break label2181;
        }
        if (this.b != null) {
          break label2143;
        }
        i1 = 0;
        label1582:
        if (this.b != null) {
          break label2162;
        }
        i2 = 0;
        label1592:
        this.m.set(i1, i2);
        this.a.a(this.m, this.m, (float)d1);
      }
      for (;;)
      {
        if (bool3)
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
        i1 = 0;
        break;
        label1798:
        i2 = 0;
        break label524;
        label1804:
        i3 = 0;
        break label567;
        label1810:
        i4 = 0;
        break label610;
        label1816:
        bool5 = false;
        break label623;
        label1822:
        bool6 = false;
        break label636;
        label1828:
        d1 = 2.0D;
        break label659;
        label1835:
        bool2 = false;
        break label706;
        label1841:
        bool1 = false;
        break label729;
        label1847:
        bool7 = false;
        break label752;
        label1853:
        bool8 = false;
        break label944;
        label1859:
        d2 = 0.5D;
        break label958;
        label1867:
        bool3 = false;
        break label986;
        label1873:
        d3 = 0.003D;
        break label1007;
        label1881:
        bool4 = false;
        break label1030;
        label1887:
        f1 = f2;
        break label1398;
        label1894:
        f3 = (paramMotionEvent.y - paramView.y) / (paramMotionEvent.x - paramView.x);
        f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
        if (f3 == f1)
        {
          paramView = null;
          break label1478;
        }
        f4 = (paramView.y * paramMotionEvent.x - paramMotionEvent.y * paramView.x) / (paramMotionEvent.x - paramView.x);
        f2 = (localPointF1.y * localPointF2.x - localPointF2.y * localPointF1.x) / (localPointF2.x - localPointF1.x);
        f3 = (f2 - f4) / (f3 - f1);
        paramView = new PointF(f3, f2 + f1 * f3);
        break label1478;
        label2055:
        i1 = this.b.h().width() / 2;
        break label1504;
        label2074:
        i2 = this.b.h().height() / 2;
        break label1514;
        label2093:
        f1 = this.b.h().width() / 3.0F;
        break label1524;
        label2115:
        f2 = this.b.h().height() / 3.0F;
        break label1534;
        label2137:
        i1 = 0;
        break label1567;
        label2143:
        i1 = this.b.h().width() / 2;
        break label1582;
        label2162:
        i2 = this.b.h().height() / 2;
        break label1592;
        label2181:
        this.k.set((this.i.x + this.j.x) / 2.0F, (this.i.y + this.j.y) / 2.0F);
        this.l.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
        this.a.a(this.k, this.l, (float)d1);
      }
      this.a.k(paramMotionEvent.getX(), paramMotionEvent.getY());
      break;
      label2303:
      boolean bool9 = bool3;
      bool3 = bool4;
      bool4 = bool9;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.if
 * JD-Core Version:    0.7.0.1
 */