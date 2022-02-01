package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

@TargetApi(11)
public class StoryDownloadView
  extends View
{
  public static final int a = Color.parseColor("#FFFFFF");
  public static final int b = Color.parseColor("#BCBFC4");
  public static final int c = Color.parseColor("#7f8393");
  public boolean d = false;
  public int e = 0;
  public float f = 1.0F;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p;
  public float q;
  public float r;
  public float s;
  public float t;
  public float u;
  public float v;
  public float w = -45.0F;
  public float x = 0.1F;
  public AnimatorSet y;
  public AnimatorSet z;
  
  public StoryDownloadView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(this.f);
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 * super.getContext().getResources().getDisplayMetrics().density + 0.5F) * paramFloat2;
  }
  
  private void a(float paramFloat)
  {
    this.g = a(46.0F, paramFloat);
    this.h = a(46.0F, paramFloat);
    this.i = a(5.0F, paramFloat);
    this.j = a(5.0F, paramFloat);
    this.k = a(6.0F, paramFloat);
    this.l = a(4.0F, paramFloat);
    this.m = a(5.0F, paramFloat);
    this.n = a(2.0F, paramFloat);
    this.o = a(18.0F, paramFloat);
    this.p = (this.h - a(7.0F, paramFloat));
    this.q = a(6.0F, paramFloat);
    this.r = a(28.0F, paramFloat);
    this.s = (this.g - a(8.0F, paramFloat));
    this.t = a(20.0F, paramFloat);
    this.u = this.k;
    this.v = (this.h - this.l - this.m / 2.0F);
  }
  
  public void a()
  {
    this.e = 0;
    super.setEnabled(true);
    b();
    super.invalidate();
  }
  
  public void a(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    int i1;
    if (this.d) {
      i1 = a;
    } else {
      i1 = c;
    }
    localPaint.setColor(i1);
    localPaint.setAntiAlias(true);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.g / 2.0F - this.m / 2.0F, this.u + this.n);
    ((Path)localObject).lineTo(this.g / 2.0F - this.m / 2.0F, this.u + this.n + this.h * 13.0F / 46.0F);
    float f1 = this.g;
    ((Path)localObject).lineTo(f1 / 2.0F - this.m / 2.0F - f1 * 8.0F / 46.0F, this.u + this.n + this.h * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.g / 2.0F, this.u + this.n + this.h * 25.0F / 46.0F);
    f1 = this.g;
    ((Path)localObject).lineTo(f1 / 2.0F + this.m / 2.0F + f1 * 8.0F / 46.0F, this.u + this.n + this.h * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.g / 2.0F + this.m / 2.0F, this.u + this.n + this.h * 13.0F / 46.0F);
    ((Path)localObject).lineTo(this.g / 2.0F + this.m / 2.0F, this.u + this.n);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath((Path)localObject, localPaint);
    f1 = this.g;
    float f2 = f1 / 2.0F;
    float f3 = this.m;
    float f4 = f3 / 2.0F;
    float f5 = this.u;
    paramCanvas.drawArc(new RectF(f2 - f4, f5, f1 / 2.0F + f3 / 2.0F, this.n * 2.0F + f5), 180.0F, 360.0F, true, localPaint);
    f1 = this.g - this.j - this.n;
    f3 = this.h;
    f4 = this.l;
    f2 = f3 - f4 - this.m;
    f3 -= f4;
    localObject = new Path();
    ((Path)localObject).moveTo(this.i + this.n, this.h - this.l - this.m / 2.0F);
    ((Path)localObject).quadTo(this.g / 2.0F, this.v, f1, this.h - this.l - this.m / 2.0F);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.m);
    paramCanvas.drawPath((Path)localObject, localPaint);
    f4 = this.i;
    localObject = new RectF(f4, f2, this.n * 2.0F + f4, f3);
    f4 = this.n;
    RectF localRectF = new RectF(f1 - f4, f2, f1 + f4, f3);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawArc((RectF)localObject, 90.0F, 360.0F, true, localPaint);
    paramCanvas.drawArc(localRectF, -90.0F, 360.0F, true, localPaint);
  }
  
  public void b()
  {
    AnimatorSet localAnimatorSet = this.y;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.end();
      this.y.cancel();
      this.y = null;
    }
    localAnimatorSet = this.z;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.end();
      this.z.cancel();
      this.z = null;
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    Path localPath = new Path();
    int i1;
    if (this.d) {
      i1 = a;
    } else {
      i1 = c;
    }
    localPaint.setColor(i1);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(this.m);
    localPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.save();
    paramCanvas.rotate(this.w, this.o, this.p);
    float f1 = this.x;
    paramCanvas.scale(f1, f1, this.o, this.p);
    localPath.moveTo(this.q, this.r);
    localPath.lineTo(this.o, this.p);
    localPath.moveTo(this.o, this.p);
    localPath.lineTo(this.s, this.t);
    paramCanvas.drawPath(localPath, localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(this.q, this.r, this.m / 2.0F, localPaint);
    paramCanvas.drawCircle(this.s, this.t, this.m / 2.0F, localPaint);
    paramCanvas.drawCircle(this.o, this.p, this.m / 2.0F, localPaint);
    paramCanvas.restore();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(super.getPaddingLeft(), super.getPaddingTop());
    int i1 = this.e;
    if (i1 == 2)
    {
      b(paramCanvas);
      return;
    }
    if ((i1 == 1) || (i1 == 0)) {
      a(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    float f2 = 1.0F;
    float f1;
    if (i1 == 1073741824) {
      f1 = paramInt1 / a(46.0F, 1.0F);
    } else {
      f1 = 1.0F;
    }
    if (i2 == 1073741824) {
      f2 = paramInt2 / a(46.0F, 1.0F);
    }
    a(Math.min(f1, f2));
    super.setMeasuredDimension(super.getPaddingLeft() + (int)this.g + super.getPaddingRight(), super.getPaddingTop() + (int)this.h + super.getPaddingBottom());
  }
  
  public void setWhiteMode(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView
 * JD-Core Version:    0.7.0.1
 */