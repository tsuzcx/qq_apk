package com.tencent.biz.qqstory.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;

@TargetApi(11)
public class NeoVideoRecordButton
  extends RingView
{
  public float a = 0.0F;
  public RingView.DrawInfo b;
  public RingView.DrawInfo c;
  public RingView.DrawInfo d;
  public ValueAnimator e;
  public ValueAnimator f;
  public AnimatorSet g;
  public ValueAnimator h;
  final int i;
  final int j;
  final int k;
  final int l;
  final int m;
  final int n;
  
  public NeoVideoRecordButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = a(paramContext, 37.5F);
    this.j = a(paramContext, 6.0F);
    this.k = a(paramContext, 1.0F);
    this.n = a(paramContext, 45.5F);
    this.m = a(paramContext, 6.0F);
    this.l = a(paramContext, 31.799999F);
    paramContext = new RingView.DrawInfo(-90, 270, this.i, 0.0F, this.j, 0.0F, -15550475, -1, Paint.Style.STROKE);
    this.b = paramContext;
    super.a(paramContext);
    paramContext = new RingView.DrawInfo(-90, 270, 1, 0.0F, 1, 0.0F, 1090519039, 0, Paint.Style.FILL);
    this.d = paramContext;
    super.a(paramContext);
    paramContext = new RingView.DrawInfo(-90, 270, this.k, 0.0F, 1, 0.0F, -1, 0, Paint.Style.FILL);
    this.c = paramContext;
    super.a(paramContext);
    this.e = new ValueAnimator();
    this.e.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("border", new IntEvaluator(), new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.n) }), PropertyValuesHolder.ofObject("ring", new IntEvaluator(), new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.m) }), PropertyValuesHolder.ofObject("center", new IntEvaluator(), new Object[] { Integer.valueOf(this.k), Integer.valueOf(this.l) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(-1), Integer.valueOf(-15550475) }) });
    this.e.setDuration(400L);
    this.e.addUpdateListener(new NeoVideoRecordButton.1(this));
    this.f = new ValueAnimator();
    paramContext = this.f;
    paramAttributeSet = PropertyValuesHolder.ofObject("radius", new IntEvaluator(), new Object[] { Integer.valueOf(1), Integer.valueOf(this.n - this.j) });
    ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
    Integer localInteger = Integer.valueOf(16777215);
    paramContext.setValues(new PropertyValuesHolder[] { paramAttributeSet, PropertyValuesHolder.ofObject("color", localArgbEvaluator, new Object[] { localInteger, localInteger, localInteger, Integer.valueOf(2147483647), localInteger }) });
    this.f.setInterpolator(new DecelerateInterpolator());
    this.f.setDuration(1500L);
    this.f.setRepeatCount(-1);
    this.f.setRepeatMode(1);
    this.f.addUpdateListener(new NeoVideoRecordButton.2(this));
    this.g = new AnimatorSet();
    this.g.play(this.e).before(this.f);
    this.h = new ValueAnimator();
    this.h.setDuration(400L);
    this.h.addUpdateListener(new NeoVideoRecordButton.3(this));
    setProgress(this.a);
    this.c.a();
    this.d.a();
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return -90;
    }
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = paramFloat - 1.0F;
    }
    return (int)(f1 * 360.0F) - 90;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * a(paramContext) + 0.5F);
  }
  
  private void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public float getProgress()
  {
    return this.a;
  }
  
  public void setProgress(float paramFloat)
  {
    this.a = paramFloat;
    this.b.g = a(this.a);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.NeoVideoRecordButton
 * JD-Core Version:    0.7.0.1
 */