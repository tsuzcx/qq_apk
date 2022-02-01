package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class QIMCommonLoadingView
  extends View
  implements QIMCommonLoadingProgress.Observer
{
  private static float q;
  protected Paint a;
  protected Paint b;
  protected Path c;
  protected int d;
  protected int e;
  protected RectF f;
  protected RectF g;
  protected long h;
  protected long i;
  protected float j;
  protected float k;
  protected float l;
  boolean m;
  boolean n;
  boolean o;
  QIMCommonLoadingProgress p;
  private int r;
  private int s;
  
  public QIMCommonLoadingView(Context paramContext)
  {
    super(paramContext);
    int i1 = this.d;
    float f1 = i1 - 16843176;
    int i2 = this.e;
    this.g = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    this.o = false;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = this.d;
    float f1 = i1 - 16843176;
    int i2 = this.e;
    this.g = new RectF(f1, i2 - 16843176, i1 + 16843176, i2 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    this.o = false;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.d;
    float f1 = paramInt - 16843176;
    int i1 = this.e;
    this.g = new RectF(f1, i1 - 16843176, paramInt + 16843176, i1 + 16843176);
    this.h = 100L;
    this.i = 0L;
    this.j = a(2.0F, getContext());
    this.k = a(17.5F, getContext());
    this.l = a(2.5F, getContext());
    this.m = false;
    this.n = true;
    this.o = false;
    b();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (q == 0.0F) {
      q = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * q);
  }
  
  public void a()
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.p;
    if (localQIMCommonLoadingProgress != null) {
      setProgress(Math.round(localQIMCommonLoadingProgress.b() * (float)this.h));
    }
  }
  
  public void a(QIMCommonLoadingProgress paramQIMCommonLoadingProgress)
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.p;
    if (localQIMCommonLoadingProgress != null) {
      localQIMCommonLoadingProgress.a(this);
    }
    this.p = paramQIMCommonLoadingProgress;
    if (paramQIMCommonLoadingProgress != null)
    {
      paramQIMCommonLoadingProgress.b(this);
      setProgress(Math.round(paramQIMCommonLoadingProgress.b() * (float)this.h));
    }
  }
  
  protected void b()
  {
    this.a = new Paint(1);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setColor(2130706432);
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(0);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.c = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF;
    float f1;
    if (this.m)
    {
      localRectF = this.f;
      f1 = this.j;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.a);
      return;
    }
    long l1 = this.i;
    if ((l1 != 0L) && (l1 != this.h))
    {
      localRectF = this.f;
      f1 = this.j;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.a);
      f1 = (float)this.i * 360.0F / (float)this.h;
      if (this.n)
      {
        paramCanvas.drawCircle(this.d, this.e, this.k, this.b);
        paramCanvas.drawCircle(this.d, this.e, this.k - this.l, this.a);
        this.c.reset();
        this.c.moveTo(this.d, this.e);
        this.c.arcTo(this.g, 270.0F, f1);
        paramCanvas.drawPath(this.c, this.b);
      }
      else
      {
        paramCanvas.drawArc(this.g, 270.0F, f1, false, this.b);
      }
      if (this.o)
      {
        if (this.i != this.h)
        {
          paramCanvas = this.p;
          if (paramCanvas != null)
          {
            setProgress(Math.round(paramCanvas.b() * (float)this.h));
            return;
          }
        }
        this.o = false;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.r = paramInt1;
    this.s = paramInt2;
    paramInt1 = this.r;
    this.d = (paramInt1 / 2);
    paramInt2 = this.s;
    this.e = (paramInt2 / 2);
    this.f = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    float f1 = this.k - this.l;
    paramInt1 = this.d;
    float f2 = paramInt1;
    paramInt2 = this.e;
    this.g = new RectF(f2 - f1, paramInt2 - f1, paramInt1 + f1, paramInt2 + f1);
  }
  
  public void setBgColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
  
  public void setBgCorner(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void setMax(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    if (paramLong == 0L) {
      this.i = paramLong;
    }
    this.i = paramLong;
    if ((this.i != this.h) && (this.p != null)) {
      this.o = true;
    }
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.b.setColor(paramInt);
  }
  
  public void setProgressSizeAndMode(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.k = paramFloat1;
    this.l = paramFloat2;
    paramFloat1 = this.k - this.l;
    int i1 = this.d;
    float f1 = i1;
    int i2 = this.e;
    this.g = new RectF(f1 - paramFloat1, i2 - paramFloat1, i1 + paramFloat1, i2 + paramFloat1);
    this.n = paramBoolean;
    if (this.n)
    {
      this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.b.setStyle(Paint.Style.FILL);
      return;
    }
    this.b.setStrokeWidth(paramFloat2);
    this.b.setXfermode(null);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(Paint.Cap.ROUND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */