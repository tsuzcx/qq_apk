package com.tencent.luggage.wxa.sv;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

public class c
{
  private static final Interpolator v = new c.1();
  private int a;
  private int b;
  private int c = -1;
  private float[] d;
  private float[] e;
  private float[] f;
  private float[] g;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private VelocityTracker l;
  private float m;
  private float n;
  private int o;
  private int p;
  private ScrollerCompat q;
  private final c.a r;
  private View s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w = new c.2(this);
  
  private c(Context paramContext, ViewGroup paramViewGroup, c.a parama)
  {
    if (paramViewGroup != null)
    {
      if (parama != null)
      {
        this.u = paramViewGroup;
        this.r = parama;
        paramViewGroup = ViewConfiguration.get(paramContext);
        this.o = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
        this.b = paramViewGroup.getScaledTouchSlop();
        this.m = paramViewGroup.getScaledMaximumFlingVelocity();
        this.n = paramViewGroup.getScaledMinimumFlingVelocity();
        this.q = ScrollerCompat.create(paramContext, v);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      return 0.0F;
    }
    if (f1 > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      return -paramFloat3;
    }
    return paramFloat1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f1 = i2;
    f2 = c(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = b(paramInt3, (int)this.n, (int)this.m);
    paramInt4 = b(paramInt4, (int)this.n, (int)this.m);
    int i1 = Math.abs(paramInt1);
    int i2 = Math.abs(paramInt2);
    int i3 = Math.abs(paramInt3);
    int i4 = Math.abs(paramInt4);
    int i5 = i3 + i4;
    int i6 = i1 + i2;
    float f1;
    float f2;
    if (paramInt3 != 0)
    {
      f1 = i3;
      f2 = i5;
    }
    else
    {
      f1 = i1;
      f2 = i6;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = i4;
      f2 = i5;
    }
    else
    {
      f1 = i2;
      f2 = i6;
    }
    f1 /= f2;
    paramInt1 = a(paramInt1, paramInt3, this.r.a(paramView));
    paramInt2 = a(paramInt2, paramInt4, this.r.b(paramView));
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  public static c a(ViewGroup paramViewGroup, c.a parama)
  {
    return new c(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.t = true;
    this.r.a(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1) {
      d(0);
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    f(paramInt);
    float[] arrayOfFloat = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.h[paramInt] = f((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i1 = this.h[paramInt1];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i1 & paramInt2) == paramInt2)
    {
      bool1 = bool2;
      if ((this.p & paramInt2) != 0)
      {
        bool1 = bool2;
        if ((this.j[paramInt1] & paramInt2) != paramInt2)
        {
          bool1 = bool2;
          if ((this.i[paramInt1] & paramInt2) != paramInt2)
          {
            i1 = this.b;
            if ((paramFloat1 <= i1) && (paramFloat2 <= i1)) {
              return false;
            }
            if ((paramFloat1 < paramFloat2 * 0.5F) && (this.r.b(paramInt2)))
            {
              int[] arrayOfInt = this.j;
              arrayOfInt[paramInt1] |= paramInt2;
              return false;
            }
            bool1 = bool2;
            if ((this.i[paramInt1] & paramInt2) == 0)
            {
              bool1 = bool2;
              if (paramFloat1 > this.b) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.q.abortAnimation();
      d(0);
      return false;
    }
    paramInt3 = a(this.s, paramInt1, paramInt2, paramInt3, paramInt4);
    this.q.startScroll(i1, i2, paramInt1, paramInt2, paramInt3);
    d(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramView == null) {
      return false;
    }
    int i1;
    if (this.r.a(paramView) > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (this.r.b(paramView) > 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 != 0) && (i2 != 0))
    {
      i1 = this.b;
      if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > i1 * i1) {
        bool1 = true;
      }
      return bool1;
    }
    if (i1 != 0)
    {
      bool1 = bool3;
      if (Math.abs(paramFloat1) > this.b) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (i2 != 0)
    {
      bool1 = bool2;
      if (Math.abs(paramFloat2) > this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      return 0;
    }
    if (i1 > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      return -paramInt3;
    }
    return paramInt1;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i2 = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, 1)) {
      i2 = 0;
    }
    int i1 = i2;
    if (a(paramFloat2, paramFloat1, paramInt, 4)) {
      i1 = i2 | 0x4;
    }
    i2 = i1;
    if (a(paramFloat1, paramFloat2, paramInt, 2)) {
      i2 = i1 | 0x2;
    }
    i1 = i2;
    if (a(paramFloat2, paramFloat1, paramInt, 8)) {
      i1 = i2 | 0x8;
    }
    if (i1 != 0)
    {
      int[] arrayOfInt = this.i;
      arrayOfInt[paramInt] |= i1;
      this.r.b(i1, paramInt);
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = this.s.getLeft();
    int i3 = this.s.getTop();
    int i1 = paramInt1;
    if (paramInt3 != 0)
    {
      i1 = this.r.a(this.s, paramInt1, paramInt3);
      this.s.offsetLeftAndRight(i1 - i2);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt1 = this.r.b(this.s, paramInt2, paramInt4);
      this.s.offsetTopAndBottom(paramInt1 - i3);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      this.r.a(this.s, i1, paramInt1, i1 - i2, paramInt1 - i3);
    }
  }
  
  private float c(float paramFloat)
  {
    double d1 = paramFloat - 0.5F;
    Double.isNaN(d1);
    return (float)Math.sin((float)(d1 * 0.47123891676382D));
  }
  
  private void c()
  {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int i2 = MotionEventCompat.getPointerCount(paramMotionEvent);
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      float f1 = MotionEventCompat.getX(paramMotionEvent, i1);
      float f2 = MotionEventCompat.getY(paramMotionEvent, i1);
      this.f[i3] = f1;
      this.g[i3] = f2;
      i1 += 1;
    }
  }
  
  private void d()
  {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), a(VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
  }
  
  private void e(int paramInt)
  {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null) {
      return;
    }
    arrayOfFloat[paramInt] = 0.0F;
    this.e[paramInt] = 0.0F;
    this.f[paramInt] = 0.0F;
    this.g[paramInt] = 0.0F;
    this.h[paramInt] = 0;
    this.i[paramInt] = 0;
    this.j[paramInt] = 0;
    this.k = ((1 << paramInt ^ 0xFFFFFFFF) & this.k);
  }
  
  private int f(int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 < this.u.getLeft() + this.o) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramInt2 < this.u.getTop() + this.o) {
      i1 = 4;
    }
    if (paramInt1 > this.u.getRight() - this.o) {
      i1 = 2;
    }
    if (paramInt2 > this.u.getBottom() - this.o) {
      i1 = 8;
    }
    return i1;
  }
  
  private void f(int paramInt)
  {
    float[] arrayOfFloat1 = this.d;
    if ((arrayOfFloat1 == null) || (arrayOfFloat1.length <= paramInt))
    {
      paramInt += 1;
      arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      float[] arrayOfFloat4 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      Object localObject = this.d;
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, arrayOfFloat1, 0, localObject.length);
        localObject = this.e;
        System.arraycopy(localObject, 0, arrayOfFloat2, 0, localObject.length);
        localObject = this.f;
        System.arraycopy(localObject, 0, arrayOfFloat3, 0, localObject.length);
        localObject = this.g;
        System.arraycopy(localObject, 0, arrayOfFloat4, 0, localObject.length);
        localObject = this.h;
        System.arraycopy(localObject, 0, arrayOfInt1, 0, localObject.length);
        localObject = this.i;
        System.arraycopy(localObject, 0, arrayOfInt2, 0, localObject.length);
        localObject = this.j;
        System.arraycopy(localObject, 0, arrayOfInt3, 0, localObject.length);
      }
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView.getParent() == this.u)
    {
      this.s = paramView;
      this.c = paramInt;
      this.r.b(paramView, paramInt);
      d(1);
      return;
    }
    paramView = new StringBuilder();
    paramView.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    paramView.append(this.u);
    paramView.append(")");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.t) {
      return a(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.l, this.c), (int)VelocityTrackerCompat.getYVelocity(this.l, this.c));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i1 == 0) {
      b();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    boolean bool = false;
    float f1;
    float f2;
    int i3;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                break label455;
              }
              e(MotionEventCompat.getPointerId(paramMotionEvent, i2));
              break label455;
            }
            i1 = MotionEventCompat.getPointerId(paramMotionEvent, i2);
            f1 = MotionEventCompat.getX(paramMotionEvent, i2);
            f2 = MotionEventCompat.getY(paramMotionEvent, i2);
            a(f1, f2, i1);
            i2 = this.a;
            if (i2 == 0)
            {
              i2 = this.h[i1];
              i3 = this.p;
              if ((i2 & i3) == 0) {
                break label455;
              }
              this.r.a(i2 & i3, i1);
              break label455;
            }
            if (i2 != 2) {
              break label455;
            }
            paramMotionEvent = e((int)f1, (int)f2);
            if (paramMotionEvent != this.s) {
              break label455;
            }
            b(paramMotionEvent, i1);
            break label455;
          }
        }
        else
        {
          i2 = MotionEventCompat.getPointerCount(paramMotionEvent);
          i1 = 0;
          while (i1 < i2)
          {
            i3 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
            f1 = MotionEventCompat.getX(paramMotionEvent, i1);
            f2 = MotionEventCompat.getY(paramMotionEvent, i1);
            float f3 = f1 - this.d[i3];
            float f4 = f2 - this.e[i3];
            b(f3, f4, i3);
            if (this.a == 1) {
              break;
            }
            View localView = e((int)f1, (int)f2);
            if ((localView != null) && (a(localView, f3, f4)) && (b(localView, i3))) {
              break;
            }
            i1 += 1;
          }
          c(paramMotionEvent);
          break label455;
        }
      }
      b();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      a(f1, f2, i1);
      paramMotionEvent = e((int)f1, (int)f2);
      if ((paramMotionEvent == this.s) && (this.a == 2)) {
        b(paramMotionEvent, i1);
      }
      i2 = this.h[i1];
      i3 = this.p;
      if ((i2 & i3) != 0) {
        this.r.a(i2 & i3, i1);
      }
    }
    label455:
    if (this.a == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt1 >= paramView.getLeft())
    {
      bool1 = bool2;
      if (paramInt1 < paramView.getRight())
      {
        bool1 = bool2;
        if (paramInt2 >= paramView.getTop())
        {
          bool1 = bool2;
          if (paramInt2 < paramView.getBottom()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i1 = this.a;
    boolean bool2 = false;
    if (i1 == 2)
    {
      boolean bool3 = this.q.computeScrollOffset();
      i1 = this.q.getCurrX();
      int i2 = this.q.getCurrY();
      int i3 = i1 - this.s.getLeft();
      int i4 = i2 - this.s.getTop();
      if (i3 != 0) {
        this.s.offsetLeftAndRight(i3);
      }
      if (i4 != 0) {
        this.s.offsetTopAndBottom(i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        this.r.a(this.s, i1, i2, i3, i4);
      }
      boolean bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i1 == this.q.getFinalX())
        {
          bool1 = bool3;
          if (i2 == this.q.getFinalY())
          {
            this.q.abortAnimation();
            bool1 = this.q.isFinished();
          }
        }
      }
      if (!bool1) {
        if (paramBoolean) {
          this.u.post(this.w);
        } else {
          d(0);
        }
      }
    }
    paramBoolean = bool2;
    if (this.a == 2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public void b()
  {
    this.c = -1;
    c();
    VelocityTracker localVelocityTracker = this.l;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.l = null;
    }
  }
  
  public void b(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    int i4 = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i4 == 0) {
      b();
    }
    if (this.l == null) {
      this.l = VelocityTracker.obtain();
    }
    this.l.addMovement(paramMotionEvent);
    int i2 = 0;
    int i1 = 0;
    float f1;
    float f2;
    if (i4 != 0)
    {
      if (i4 != 1)
      {
        Object localObject;
        if (i4 != 2)
        {
          if (i4 != 3)
          {
            if (i4 != 5)
            {
              if (i4 != 6) {
                return;
              }
              i2 = MotionEventCompat.getPointerId(paramMotionEvent, i3);
              if ((this.a == 1) && (i2 == this.c))
              {
                i3 = MotionEventCompat.getPointerCount(paramMotionEvent);
                while (i1 < i3)
                {
                  i4 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
                  if (i4 != this.c)
                  {
                    f1 = MotionEventCompat.getX(paramMotionEvent, i1);
                    f2 = MotionEventCompat.getY(paramMotionEvent, i1);
                    localObject = e((int)f1, (int)f2);
                    View localView = this.s;
                    if ((localObject == localView) && (b(localView, i4)))
                    {
                      i1 = this.c;
                      break label213;
                    }
                  }
                  i1 += 1;
                }
                i1 = -1;
                label213:
                if (i1 == -1) {
                  d();
                }
              }
              e(i2);
              return;
            }
            i1 = MotionEventCompat.getPointerId(paramMotionEvent, i3);
            f1 = MotionEventCompat.getX(paramMotionEvent, i3);
            f2 = MotionEventCompat.getY(paramMotionEvent, i3);
            a(f1, f2, i1);
            if (this.a == 0)
            {
              b(e((int)f1, (int)f2), i1);
              i2 = this.h[i1];
              i3 = this.p;
              if ((i2 & i3) != 0) {
                this.r.a(i2 & i3, i1);
              }
            }
            else if (d((int)f1, (int)f2))
            {
              b(this.s, i1);
            }
          }
          else
          {
            if (this.a == 1) {
              a(0.0F, 0.0F);
            }
            b();
          }
        }
        else
        {
          if (this.a == 1)
          {
            i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.c);
            f1 = MotionEventCompat.getX(paramMotionEvent, i1);
            f2 = MotionEventCompat.getY(paramMotionEvent, i1);
            localObject = this.f;
            i2 = this.c;
            i1 = (int)(f1 - localObject[i2]);
            i2 = (int)(f2 - this.g[i2]);
            b(this.s.getLeft() + i1, this.s.getTop() + i2, i1, i2);
            c(paramMotionEvent);
            return;
          }
          i3 = MotionEventCompat.getPointerCount(paramMotionEvent);
          i1 = i2;
          while (i1 < i3)
          {
            i2 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
            f1 = MotionEventCompat.getX(paramMotionEvent, i1);
            f2 = MotionEventCompat.getY(paramMotionEvent, i1);
            float f3 = f1 - this.d[i2];
            float f4 = f2 - this.e[i2];
            b(f3, f4, i2);
            if (this.a == 1) {
              break;
            }
            localObject = e((int)f1, (int)f2);
            if ((a((View)localObject, f3, f4)) && (b((View)localObject, i2))) {
              break;
            }
            i1 += 1;
          }
          c(paramMotionEvent);
        }
      }
      else
      {
        if (this.a == 1) {
          d();
        }
        b();
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      paramMotionEvent = e((int)f1, (int)f2);
      a(f1, f2, i1);
      b(paramMotionEvent, i1);
      i2 = this.h[i1];
      i3 = this.p;
      if ((i2 & i3) != 0) {
        this.r.a(i2 & i3, i1);
      }
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    boolean bool4 = c(paramInt2);
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool4) {
      return false;
    }
    int i1;
    if ((paramInt1 & 0x1) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    float f1 = this.f[paramInt2] - this.d[paramInt2];
    float f2 = this.g[paramInt2] - this.e[paramInt2];
    if ((i1 != 0) && (paramInt1 != 0))
    {
      paramInt1 = this.b;
      if (f1 * f1 + f2 * f2 > paramInt1 * paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    if (i1 != 0)
    {
      bool1 = bool3;
      if (Math.abs(f1) > this.b) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt1 != 0)
    {
      bool1 = bool2;
      if (Math.abs(f2) > this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean b(View paramView, int paramInt)
  {
    if ((paramView == this.s) && (this.c == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.r.a(paramView, paramInt)))
    {
      this.c = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean c(int paramInt)
  {
    return (1 << paramInt & this.k) != 0;
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return (c(paramInt2)) && ((paramInt1 & this.h[paramInt2]) != 0);
  }
  
  void d(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.r.a(paramInt);
      if (paramInt == 0) {
        this.s = null;
      }
    }
  }
  
  public boolean d(int paramInt1, int paramInt2)
  {
    return a(this.s, paramInt1, paramInt2);
  }
  
  public View e(int paramInt1, int paramInt2)
  {
    int i1 = this.u.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = this.u.getChildAt(this.r.c(i1));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i1 -= 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sv.c
 * JD-Core Version:    0.7.0.1
 */