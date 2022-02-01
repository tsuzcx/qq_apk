package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class CircleProgressDrawable
  extends Drawable
{
  private static final RectF a = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
  private static final RectF b = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
  private Paint c;
  private ArrayList<Animator> d;
  private int e;
  private int f = 4;
  private int g = -16777216;
  private boolean h = false;
  private int i = 0;
  private CircleProgressDrawable.RingPathTransform j = new CircleProgressDrawable.RingPathTransform(null);
  private CircleProgressDrawable.RingRotation k = new CircleProgressDrawable.RingRotation(null);
  
  public CircleProgressDrawable(@NonNull Context paramContext)
  {
    this.e = Math.round(paramContext.getResources().getDisplayMetrics().density * 48.0F);
    this.d = new ArrayList();
  }
  
  private static Animator a(CircleProgressDrawable.RingPathTransform paramRingPathTransform)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(CircleProgressDrawable.c.a);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(CircleProgressDrawable.b.a);
    localObjectAnimator2.setRepeatCount(-1);
    paramRingPathTransform = ObjectAnimator.ofFloat(paramRingPathTransform, "trimPathOffset", new float[] { 0.0F, 0.25F });
    paramRingPathTransform.setDuration(1333L);
    paramRingPathTransform.setInterpolator(CircleProgressDrawable.a.a);
    paramRingPathTransform.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramRingPathTransform });
    return localAnimatorSet;
  }
  
  private static Animator a(CircleProgressDrawable.RingRotation paramRingRotation)
  {
    paramRingRotation = ObjectAnimator.ofFloat(paramRingRotation, "rotation", new float[] { 0.0F, 720.0F });
    paramRingRotation.setDuration(6665L);
    paramRingRotation.setInterpolator(CircleProgressDrawable.a.a);
    paramRingRotation.setRepeatCount(-1);
    return paramRingRotation;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramCanvas.scale(paramInt1 / a.width(), paramInt2 / a.height());
    paramCanvas.translate(a.width() / 2.0F, a.height() / 2.0F);
    if (this.h) {
      a(paramCanvas, paramPaint);
    }
    b(paramCanvas, paramPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint)
  {
    int m = paramCanvas.save();
    paramPaint.setColor(this.i);
    paramCanvas.drawArc(b, 0.0F, 360.0F, false, paramPaint);
    paramCanvas.restoreToCount(m);
  }
  
  private void b(Canvas paramCanvas, Paint paramPaint)
  {
    int m = paramCanvas.save();
    paramPaint.setColor(this.g);
    paramCanvas.rotate(CircleProgressDrawable.RingRotation.a(this.k));
    float f1 = this.j.c;
    float f2 = this.j.a;
    float f3 = this.j.b;
    float f4 = this.j.a;
    paramCanvas.drawArc(b, (f1 + f2) * 360.0F - 90.0F, (f3 - f4) * 360.0F, false, paramPaint);
    paramCanvas.restoreToCount(m);
  }
  
  private boolean d()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (((Animator)localIterator.next()).isStarted()) {
        return true;
      }
    }
    return false;
  }
  
  private int e()
  {
    return this.e;
  }
  
  private void f()
  {
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.f);
    this.c.setStrokeCap(Paint.Cap.SQUARE);
    this.c.setStrokeJoin(Paint.Join.MITER);
  }
  
  public void a()
  {
    c();
    this.d.clear();
    this.d.add(a(this.j));
    this.d.add(a(this.k));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    invalidateSelf();
  }
  
  public void b()
  {
    if (d()) {
      return;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
  }
  
  public void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (localRect.width() != 0)
    {
      if (localRect.height() == 0) {
        return;
      }
      if (this.c == null) {
        f();
      }
      int m = paramCanvas.save();
      paramCanvas.translate(localRect.left, localRect.top);
      a(paramCanvas, localRect.width(), localRect.height(), this.c);
      paramCanvas.restoreToCount(m);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return e();
  }
  
  public int getIntrinsicWidth()
  {
    return e();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */