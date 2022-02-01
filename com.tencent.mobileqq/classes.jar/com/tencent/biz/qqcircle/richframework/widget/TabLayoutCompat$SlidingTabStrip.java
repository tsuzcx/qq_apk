package com.tencent.biz.qqcircle.richframework.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.view.ViewCompat;

class TabLayoutCompat$SlidingTabStrip
  extends LinearLayout
{
  int a = -1;
  float b;
  private int d;
  private final Paint e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private ValueAnimator i;
  private int j;
  private int k;
  private int l;
  
  TabLayoutCompat$SlidingTabStrip(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.e = new Paint();
  }
  
  private void c()
  {
    View localView = getChildAt(this.a);
    int m;
    int n;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int i2 = localView.getLeft();
      int i1 = localView.getRight();
      m = i1;
      n = i2;
      if (this.b > 0.0F)
      {
        m = i1;
        n = i2;
        if (this.a < getChildCount() - 1)
        {
          localView = getChildAt(this.a + 1);
          float f1 = this.b;
          float f2 = localView.getLeft();
          float f3 = this.b;
          n = (int)(f1 * f2 + (1.0F - f3) * i2);
          m = (int)(f3 * localView.getRight() + (1.0F - this.b) * i1);
        }
      }
    }
    else
    {
      n = -1;
      m = -1;
    }
    a(n, m);
  }
  
  void a(int paramInt)
  {
    if (this.e.getColor() != paramInt)
    {
      this.e.setColor(paramInt);
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void a(int paramInt, float paramFloat)
  {
    ValueAnimator localValueAnimator = this.i;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.i.cancel();
    }
    this.a = paramInt;
    this.b = paramFloat;
    c();
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.g) || (paramInt2 != this.h))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  boolean a()
  {
    int n = getChildCount();
    int m = 0;
    while (m < n)
    {
      if (getChildAt(m).getWidth() <= 0) {
        return true;
      }
      m += 1;
    }
    return false;
  }
  
  float b()
  {
    return this.a + this.b;
  }
  
  void b(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.i;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.i.cancel();
    }
    int m;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    localObject = getChildAt(paramInt1);
    if (localObject == null)
    {
      c();
      return;
    }
    int i1 = ((View)localObject).getLeft();
    int i2 = ((View)localObject).getRight();
    int n;
    if (Math.abs(paramInt1 - this.a) <= 1)
    {
      m = this.g;
      n = this.h;
    }
    else
    {
      n = this.c.b(24);
      if (paramInt1 < this.a ? m == 0 : m != 0) {
        m = n + i2;
      } else {
        m = i1 - n;
      }
      n = m;
    }
    if ((m != i1) || (n != i2))
    {
      localObject = new ValueAnimator();
      this.i = ((ValueAnimator)localObject);
      ((ValueAnimator)localObject).setDuration(paramInt2);
      ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener(new TabLayoutCompat.SlidingTabStrip.1(this, m, i1, n, i2));
      ((ValueAnimator)localObject).addListener(new TabLayoutCompat.SlidingTabStrip.2(this, paramInt1));
      ((ValueAnimator)localObject).start();
    }
  }
  
  void c(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void d(int paramInt)
  {
    if (this.k != paramInt)
    {
      this.k = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int m = this.g;
    if ((m >= 0) && (this.h > m)) {
      paramCanvas.drawRect(m + this.j, getHeight() - this.d - this.l, this.h - this.k, getHeight() - this.l, this.e);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ValueAnimator localValueAnimator = this.i;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.i.cancel();
      long l1 = this.i.getDuration();
      b(this.a, Math.round((1.0F - this.i.getAnimatedFraction()) * (float)l1));
      return;
    }
    c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      return;
    }
    int m = this.c.l;
    int i3 = 1;
    if ((m == 1) && (this.c.k == 1))
    {
      int i4 = getChildCount();
      int i2 = 0;
      m = 0;
      Object localObject;
      int i1;
      for (int n = 0; m < i4; n = i1)
      {
        localObject = getChildAt(m);
        i1 = n;
        if (((View)localObject).getVisibility() == 0) {
          i1 = Math.max(n, ((View)localObject).getMeasuredWidth());
        }
        m += 1;
      }
      if (n <= 0) {
        return;
      }
      m = this.c.b(16);
      if (n * i4 <= getMeasuredWidth() - m * 2)
      {
        m = 0;
        i1 = i2;
        while (i1 < i4)
        {
          localObject = (LinearLayout.LayoutParams)getChildAt(i1).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width != n) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
          {
            ((LinearLayout.LayoutParams)localObject).width = n;
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            m = 1;
          }
          i1 += 1;
        }
      }
      else
      {
        localObject = this.c;
        ((TabLayoutCompat)localObject).k = 0;
        ((TabLayoutCompat)localObject).a(false);
        m = i3;
      }
      if (m != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.f != paramInt))
    {
      requestLayout();
      this.f = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.SlidingTabStrip
 * JD-Core Version:    0.7.0.1
 */