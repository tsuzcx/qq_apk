package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory;
import com.tencent.biz.qqstory.support.logging.SLog;

@TargetApi(14)
public class ElasticImageView
  extends ImageView
{
  public float a = 1.0F;
  public float b = 1.0F;
  public float c = 1.0F;
  public final long d = 100L;
  public float e = this.b;
  public boolean f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public ValueAnimator p;
  public ValueAnimator q;
  public boolean r = false;
  public float s = 1.0F;
  public float t = 1.0F;
  public boolean u = true;
  private Matrix v;
  private Matrix w;
  
  public ElasticImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ElasticImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private ValueAnimator a(float paramFloat1, float paramFloat2, long paramLong)
  {
    return AnimatorFactory.a(paramLong, paramFloat1, paramFloat2, new ElasticImageView.1(this));
  }
  
  private void a()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.w = new Matrix(getImageMatrix());
    this.v = new Matrix();
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateMatrix:");
    localStringBuilder.append(paramFloat);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    this.v.set(this.w);
    this.v.postTranslate(this.m, this.n);
    this.v.postScale(this.s, this.t, this.k, this.l);
    this.v.postScale(paramFloat, paramFloat, this.k, this.l);
    super.setImageMatrix(this.v);
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = this.q;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.q.cancel();
    }
    localValueAnimator = this.p;
    if ((localValueAnimator == null) || (!localValueAnimator.isRunning()))
    {
      this.p = a(this.e, this.c, 100L);
      this.p.start();
    }
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = this.p;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.p.cancel();
    }
    localValueAnimator = this.q;
    if ((localValueAnimator == null) || (!localValueAnimator.isRunning()))
    {
      this.q = a(this.e, this.a, 100L);
      this.q.start();
    }
  }
  
  private void d()
  {
    boolean bool;
    if (getDrawable() != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if (!bool) {
      return;
    }
    int i3 = getDrawable().getIntrinsicWidth();
    int i4 = getDrawable().getIntrinsicHeight();
    int i1 = i3;
    int i2 = i4;
    if (this.r) {
      if (i3 < i4)
      {
        this.t = (i3 / i4);
        this.s = 1.0F;
        i2 = i3;
        i1 = i3;
      }
      else if (i3 > i4)
      {
        this.s = (i4 / i3);
        this.t = 1.0F;
        i1 = i4;
        i2 = i4;
      }
      else
      {
        this.s = 1.0F;
        this.t = 1.0F;
        i2 = i4;
        i1 = i3;
      }
    }
    i3 = this.i;
    float f2;
    float f3;
    if (i1 <= i3)
    {
      i4 = this.j;
      if (i2 <= i4)
      {
        f2 = i3 / i1;
        f3 = i4 / i2;
        f1 = f3;
        if (f2 < f3)
        {
          f1 = f2;
          break label315;
        }
      }
    }
    for (;;)
    {
      break;
      i3 = this.i;
      i4 = i1 - i3;
      int i5 = this.j;
      int i6 = i2 - i5;
      if ((i4 > 0) && (i6 > 0))
      {
        f2 = i3 / i1;
        f3 = i5 / i2;
        f1 = f3;
        if (f2 < f3) {
          f1 = f2;
        }
      }
      else
      {
        if (i4 > 0) {
          f1 = this.i;
        }
        for (f2 = i1;; f2 = i2)
        {
          f1 /= f2;
          break;
          if (i6 <= 0) {
            break label313;
          }
          f1 = this.j;
        }
        label313:
        f1 = 1.0F;
      }
    }
    label315:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drawableWidth:");
    localStringBuilder.append(i1);
    localStringBuilder.append(",drawableHeight:");
    localStringBuilder.append(i2);
    localStringBuilder.append(",AvaliableWidth:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",AvaliableHeight:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",scaleValue:");
    localStringBuilder.append(f1);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    this.a = f1;
    float f1 = this.a;
    this.b = (0.9F * f1);
    this.c = (f1 * 0.5F);
    this.m = ((int)(this.k - i1 / this.s / 2.0F));
    this.n = ((int)(this.l - i2 / this.t / 2.0F));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = paramInt1;
    this.h = paramInt2;
    this.k = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 2);
    this.l = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 2);
    paramInt1 = this.l;
    this.o = (paramInt1 * 2);
    this.i = (this.k * 2);
    this.j = (paramInt1 * 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageViewWidth:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",ImageViewHeight:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",centerX:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",centerY:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",AvaliableWidth:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",AvaliableHeight:");
    localStringBuilder.append(this.j);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    d();
    this.e = this.a;
    a(this.e);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.f) && (this.u))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2)
          {
            if (i1 != 3) {
              break label128;
            }
          }
          else
          {
            if ((f1 >= 0.0F) && (f1 <= getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight()))
            {
              b();
              break label128;
            }
            c();
            break label128;
          }
        }
        c();
      }
      else
      {
        d();
        this.e = this.b;
        b();
      }
    }
    label128:
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    d();
    this.e = this.a;
    a(this.e);
  }
  
  public void setIsNeedAdjustDrawableToSquare(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.ElasticImageView
 * JD-Core Version:    0.7.0.1
 */