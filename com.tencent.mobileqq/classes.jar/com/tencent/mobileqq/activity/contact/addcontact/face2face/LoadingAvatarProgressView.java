package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class LoadingAvatarProgressView
  extends View
{
  private LoadingAvatarProgressView.IProgressListener a;
  private int b;
  private int c;
  private int d;
  private boolean e = false;
  private Paint f;
  private Path g;
  private Paint h;
  private int i = 0;
  private float j;
  private int k = 1500;
  private RectF l;
  private int m = 0;
  private int n = 0;
  private int o = 30;
  private RectF p;
  private PathMeasure q;
  private float r;
  private Path s;
  private float t;
  private int u;
  private RectF v;
  private Paint w;
  
  public LoadingAvatarProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.s = new Path();
    int i1 = this.b;
    int i2 = this.c;
    float f1 = i1 * 2;
    float f2 = i2 * 2;
    this.p = new RectF(0.0F, 0.0F, f1, f2);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.b, 0.0F);
    ((Path)localObject).lineTo(f1, 0.0F);
    ((Path)localObject).lineTo(f1, f2);
    ((Path)localObject).lineTo(0.0F, f2);
    ((Path)localObject).lineTo(0.0F, 0.0F);
    ((Path)localObject).lineTo(this.b, 0.0F);
    ((Path)localObject).close();
    this.q = new PathMeasure((Path)localObject, false);
    this.t = this.q.getLength();
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(this.k);
    ((ValueAnimator)localObject).addUpdateListener(new LoadingAvatarProgressView.1(this));
    ((ValueAnimator)localObject).start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleLoadingView);
    this.j = paramContext.getInteger(2, 5);
    this.j = AIOUtils.b(this.j, getResources());
    this.u = paramContext.getInteger(1, 5);
    this.u = AIOUtils.b(this.u, getResources());
    this.i = paramContext.getInteger(0, -16776961);
    paramContext.recycle();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeWidth(this.j);
    this.h.setColor(this.i);
    this.w = new Paint();
    this.w.setAntiAlias(true);
    this.w.setStyle(Paint.Style.FILL);
    this.w.setStrokeWidth(this.j);
    this.w.setColor(this.i);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeWidth(this.j);
    this.f.setColor(this.i);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.n < 100)
    {
      this.w.setStyle(Paint.Style.STROKE);
      this.w.setColor(Color.parseColor("#8E8E93"));
      paramCanvas.drawArc(this.v, -90.0F, this.n * 360 / 100, false, this.w);
      this.n += 2;
      postInvalidateDelayed(this.o);
      return;
    }
    this.n = 0;
    postInvalidateDelayed(this.o);
  }
  
  private void b()
  {
    int i4 = AIOUtils.b(12.0F, getResources());
    int i1 = AIOUtils.b(4.0F, getResources());
    int i2 = this.b;
    float f1 = i2 - i4 + i1;
    int i3 = this.c;
    float f2 = i3;
    int i5 = i4 / 2;
    float f3 = i2 - i5 + i1;
    float f4 = i5 + i3;
    i4 = i4 * 2 / 4;
    float f5 = i2 + i4 + i1;
    float f6 = i3 - i4;
    this.g = new Path();
    this.g.reset();
    this.g.moveTo(f1, f2);
    this.g.lineTo(f3, f4);
    this.g.lineTo(f5, f6);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.r < this.t)
    {
      this.s.reset();
      this.s.lineTo(0.0F, 0.0F);
      this.q.getSegment(0.0F, this.r, this.s, false);
      paramCanvas.drawPath(this.s, this.h);
      return;
    }
    if (this.e)
    {
      this.h.setStyle(Paint.Style.FILL);
      RectF localRectF = this.p;
      int i1 = this.u;
      paramCanvas.drawRoundRect(localRectF, i1, i1, this.h);
      paramCanvas.drawPath(this.g, this.f);
    }
    paramCanvas = this.a;
    if (paramCanvas != null) {
      paramCanvas.a(this.m);
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = this.m;
    if (i1 < 100)
    {
      paramCanvas.drawArc(this.l, -90.0F, i1 * 360 / 100, false, this.h);
      this.m += 2;
      postInvalidateDelayed(this.o);
      return;
    }
    if (this.e)
    {
      this.h.setStyle(Paint.Style.FILL);
      i1 = this.b;
      float f1 = i1;
      int i2 = this.c;
      paramCanvas.drawCircle(f1, i2, Math.min(i1, i2), this.h);
      paramCanvas.drawPath(this.g, this.f);
    }
    paramCanvas = this.a;
    if (paramCanvas != null) {
      paramCanvas.a(this.m);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.d;
    if (i1 == 0)
    {
      c(paramCanvas);
      return;
    }
    if (i1 == 1)
    {
      b(paramCanvas);
      return;
    }
    if (i1 == 2) {
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.b = (paramInt1 / 2);
    this.c = (paramInt2 / 2);
    float f3 = this.j;
    float f4 = f3 / 2.0F;
    float f5 = f3 / 2.0F;
    float f1 = paramInt1;
    float f6 = f3 / 2.0F;
    float f2 = paramInt2;
    this.l = new RectF(f4, f5, f1 - f6, f2 - f3 / 2.0F);
    f3 = this.j;
    this.v = new RectF(f3 / 2.0F, f3 / 2.0F, f1 - f3 / 2.0F, f2 - f3 / 2.0F);
    a();
    if (this.e) {
      b();
    }
  }
  
  public void setAnimDuration(int paramInt)
  {
    this.k = paramInt;
    this.o = (paramInt / 50);
  }
  
  public void setLoadType(int paramInt)
  {
    this.m = 0;
    this.d = paramInt;
  }
  
  public void setNeedCover(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setProgressListener(LoadingAvatarProgressView.IProgressListener paramIProgressListener)
  {
    this.a = paramIProgressListener;
  }
  
  public void setRoundSize(int paramInt)
  {
    this.u = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.LoadingAvatarProgressView
 * JD-Core Version:    0.7.0.1
 */