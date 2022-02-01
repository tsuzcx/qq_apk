package com.tencent.biz.richframework.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class QCircleRippleAnimView
  extends View
{
  private Paint a = new Paint();
  private int b;
  private int c;
  private int d;
  private boolean e;
  private long f;
  private float g;
  private float h;
  private ViewGroup i;
  private QCircleRippleAnimView.OnAnimationEndListener j;
  private Animator.AnimatorListener k;
  private ValueAnimator.AnimatorUpdateListener l;
  private TimeInterpolator m;
  private int n;
  private boolean o;
  
  public QCircleRippleAnimView(Context paramContext)
  {
    super(paramContext);
    this.a.setAntiAlias(true);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    b();
  }
  
  private void b()
  {
    this.k = new QCircleRippleAnimView.1(this);
    this.l = new QCircleRippleAnimView.2(this);
  }
  
  private void c()
  {
    setVisibility(0);
    if (!this.o)
    {
      this.i.addView(this, new ViewGroup.LayoutParams(-1, -1));
      this.o = true;
    }
  }
  
  private void d()
  {
    if (this.i != null)
    {
      setVisibility(8);
      this.i = null;
    }
    if (this.a != null) {
      this.a = null;
    }
  }
  
  private ValueAnimator getAnimator()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.c, this.b }).setDuration(this.f);
    TimeInterpolator localTimeInterpolator = this.m;
    if (localTimeInterpolator != null) {
      localValueAnimator.setInterpolator(localTimeInterpolator);
    }
    localValueAnimator.addUpdateListener(this.l);
    localValueAnimator.addListener(this.k);
    return localValueAnimator;
  }
  
  public QCircleRippleAnimView a(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    this.h = paramFloat2;
    return this;
  }
  
  public QCircleRippleAnimView a(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public QCircleRippleAnimView a(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
  
  public QCircleRippleAnimView a(TimeInterpolator paramTimeInterpolator)
  {
    this.m = paramTimeInterpolator;
    return this;
  }
  
  public QCircleRippleAnimView a(ViewGroup paramViewGroup)
  {
    this.i = paramViewGroup;
    return this;
  }
  
  public QCircleRippleAnimView a(QCircleRippleAnimView.OnAnimationEndListener paramOnAnimationEndListener)
  {
    this.j = paramOnAnimationEndListener;
    return this;
  }
  
  public void a()
  {
    if (!this.e)
    {
      this.e = true;
      c();
      getAnimator().start();
    }
  }
  
  public QCircleRippleAnimView b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public QCircleRippleAnimView c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 21) {
      i1 = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
    } else {
      i1 = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    }
    paramCanvas.drawColor(this.n);
    paramCanvas.drawCircle(this.g, this.h, this.d, this.a);
    paramCanvas.restoreToCount(i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.QCircleRippleAnimView
 * JD-Core Version:    0.7.0.1
 */