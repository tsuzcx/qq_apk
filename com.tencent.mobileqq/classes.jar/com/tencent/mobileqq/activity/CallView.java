package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;

public class CallView
  extends View
{
  private Paint a = null;
  private int b = 0;
  private RectF c = null;
  private int d = 4;
  private volatile boolean e = true;
  private long f = 0L;
  private long g = 150L;
  
  public CallView(Context paramContext)
  {
    super(paramContext);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.d);
    this.b = -65536;
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.d;
    float f2 = getMeasuredHeight() - this.d;
    RectF localRectF = this.c;
    localRectF.left = (-f1 / 3.0F);
    localRectF.top = (2.0F * f2 / 3.0F);
    localRectF.right = (f1 / 3.0F);
    localRectF.bottom = (f2 * 4.0F / 3.0F);
    this.a.setColor(this.b);
    paramCanvas.drawArc(this.c, -100.0F, 100.0F, false, this.a);
  }
  
  private void b(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.d;
    float f2 = getMeasuredHeight() - this.d;
    RectF localRectF = this.c;
    localRectF.left = (-f1 * 2.0F / 3.0F);
    localRectF.top = (f2 / 3.0F);
    localRectF.right = (f1 * 2.0F / 3.0F);
    localRectF.bottom = (f2 * 5.0F / 3.0F);
    this.a.setColor(this.b);
    paramCanvas.drawArc(this.c, -100.0F, 100.0F, false, this.a);
  }
  
  private void c(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.d;
    float f2 = getMeasuredHeight();
    int i = this.d;
    float f3 = i;
    RectF localRectF = this.c;
    localRectF.left = (-f1);
    localRectF.top = i;
    localRectF.right = f1;
    localRectF.bottom = ((f2 - f3) * 2.0F);
    this.a.setColor(this.b);
    paramCanvas.drawArc(this.c, -100.0F, 100.0F, false, this.a);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e)
    {
      if (SystemClock.uptimeMillis() - this.f > this.g * 6L)
      {
        this.f = SystemClock.uptimeMillis();
      }
      else if (SystemClock.uptimeMillis() - this.f > this.g * 5L)
      {
        a(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.f > this.g * 4L)
      {
        a(paramCanvas);
        b(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.f > this.g * 3L)
      {
        a(paramCanvas);
        b(paramCanvas);
        c(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.f > this.g * 2L)
      {
        a(paramCanvas);
        b(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.f > this.g)
      {
        a(paramCanvas);
      }
      postInvalidateDelayed(150L);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CallView
 * JD-Core Version:    0.7.0.1
 */