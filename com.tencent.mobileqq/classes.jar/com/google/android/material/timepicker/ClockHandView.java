package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClockHandView
  extends View
{
  private ValueAnimator a;
  private boolean b;
  private float c;
  private float d;
  private boolean e;
  private int f;
  private final List<ClockHandView.OnRotateListener> g = new ArrayList();
  private final int h;
  private final float i;
  private final Paint j = new Paint();
  private final RectF k = new RectF();
  @Px
  private final int l;
  private float m;
  private boolean n;
  private ClockHandView.OnActionUpListener o;
  private double p;
  private int q;
  
  public ClockHandView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClockHandView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.I);
  }
  
  public ClockHandView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bN, paramInt, R.style.L);
    this.q = paramAttributeSet.getDimensionPixelSize(R.styleable.bP, 0);
    this.h = paramAttributeSet.getDimensionPixelSize(R.styleable.bQ, 0);
    Resources localResources = getResources();
    this.l = localResources.getDimensionPixelSize(R.dimen.v);
    this.i = localResources.getDimensionPixelSize(R.dimen.t);
    paramInt = paramAttributeSet.getColor(R.styleable.bO, 0);
    this.j.setAntiAlias(true);
    this.j.setColor(paramInt);
    a(0.0F);
    this.f = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    ViewCompat.setImportantForAccessibility(this, 2);
    paramAttributeSet.recycle();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i1 = getWidth() / 2;
    int i2 = getHeight() / 2;
    double d1 = paramFloat1 - i1;
    i2 = (int)Math.toDegrees(Math.atan2(paramFloat2 - i2, d1)) + 90;
    i1 = i2;
    if (i2 < 0) {
      i1 = i2 + 360;
    }
    return i1;
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getWidth() / 2;
    float f1 = i2;
    float f3 = this.q;
    float f4 = (float)Math.cos(this.p);
    float f2 = i1;
    float f5 = this.q;
    float f6 = (float)Math.sin(this.p);
    this.j.setStrokeWidth(0.0F);
    paramCanvas.drawCircle(f3 * f4 + f1, f5 * f6 + f2, this.h, this.j);
    double d1 = Math.sin(this.p);
    double d2 = Math.cos(this.p);
    double d3 = this.q - this.h;
    Double.isNaN(d3);
    f3 = i2 + (int)(d2 * d3);
    Double.isNaN(d3);
    f4 = i1 + (int)(d3 * d1);
    this.j.setStrokeWidth(this.l);
    paramCanvas.drawLine(f1, f2, f3, f4, this.j);
    paramCanvas.drawCircle(f1, f2, this.i, this.j);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = a(paramFloat1, paramFloat2);
    paramFloat1 = a();
    paramFloat2 = i1;
    boolean bool = false;
    if (paramFloat1 != paramFloat2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramBoolean2) && (i1 != 0)) {
      return true;
    }
    if ((i1 == 0) && (!paramBoolean1)) {
      return false;
    }
    paramBoolean1 = bool;
    if (paramBoolean3)
    {
      paramBoolean1 = bool;
      if (this.b) {
        paramBoolean1 = true;
      }
    }
    a(paramFloat2, paramBoolean1);
    return true;
  }
  
  private Pair<Float, Float> b(float paramFloat)
  {
    float f4 = a();
    float f3 = f4;
    float f2 = paramFloat;
    if (Math.abs(f4 - paramFloat) > 180.0F)
    {
      float f1 = paramFloat;
      if (f4 > 180.0F)
      {
        f1 = paramFloat;
        if (paramFloat < 180.0F) {
          f1 = paramFloat + 360.0F;
        }
      }
      f3 = f4;
      f2 = f1;
      if (f4 < 180.0F)
      {
        f3 = f4;
        f2 = f1;
        if (f1 > 180.0F)
        {
          f3 = f4 + 360.0F;
          f2 = f1;
        }
      }
    }
    return new Pair(Float.valueOf(f3), Float.valueOf(f2));
  }
  
  private void b(@FloatRange(from=0.0D, to=360.0D) float paramFloat, boolean paramBoolean)
  {
    paramFloat %= 360.0F;
    this.m = paramFloat;
    this.p = Math.toRadians(this.m - 90.0F);
    int i1 = getHeight() / 2;
    float f1 = getWidth() / 2 + this.q * (float)Math.cos(this.p);
    float f2 = i1 + this.q * (float)Math.sin(this.p);
    Object localObject = this.k;
    i1 = this.h;
    ((RectF)localObject).set(f1 - i1, f2 - i1, f1 + i1, f2 + i1);
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ClockHandView.OnRotateListener)((Iterator)localObject).next()).a(paramFloat, paramBoolean);
    }
    invalidate();
  }
  
  @FloatRange(from=0.0D, to=360.0D)
  public float a()
  {
    return this.m;
  }
  
  public void a(@FloatRange(from=0.0D, to=360.0D) float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public void a(@FloatRange(from=0.0D, to=360.0D) float paramFloat, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    if (!paramBoolean)
    {
      b(paramFloat, false);
      return;
    }
    localObject = b(paramFloat);
    this.a = ValueAnimator.ofFloat(new float[] { ((Float)((Pair)localObject).first).floatValue(), ((Float)((Pair)localObject).second).floatValue() });
    this.a.setDuration(200L);
    this.a.addUpdateListener(new ClockHandView.1(this));
    this.a.addListener(new ClockHandView.2(this));
    this.a.start();
  }
  
  public void a(@Dimension int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
  
  public void a(ClockHandView.OnActionUpListener paramOnActionUpListener)
  {
    this.o = paramOnActionUpListener;
  }
  
  public void a(ClockHandView.OnRotateListener paramOnRotateListener)
  {
    this.g.add(paramOnRotateListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public RectF b()
  {
    return this.k;
  }
  
  public int c()
  {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(a());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2))
      {
        bool2 = false;
        bool1 = false;
      }
      for (;;)
      {
        bool3 = false;
        break;
        int i2 = (int)(f1 - this.c);
        int i3 = (int)(f2 - this.d);
        if (i2 * i2 + i3 * i3 > this.f) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.e = bool1;
        bool1 = this.n;
        if (i1 == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
    }
    this.c = f1;
    this.d = f2;
    this.e = true;
    this.n = false;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool4 = this.n;
    this.n = (a(f1, f2, bool1, bool3, bool2) | bool4);
    if ((this.n) && (bool2))
    {
      paramMotionEvent = this.o;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(a(f1, f2), this.e);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockHandView
 * JD-Core Version:    0.7.0.1
 */