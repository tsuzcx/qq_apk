package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ReadInjoyHeaderAdDownloadView$SimpleRoundProgress
  extends View
{
  public Paint a = new Paint();
  public int b;
  public float c;
  public int d;
  public float e;
  public float f;
  public int g;
  public int h;
  public int i;
  public int j;
  RectF k;
  private volatile boolean l;
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getProgress()
  {
    try
    {
      int m = this.j;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getWidth() / 2;
    float f1 = m;
    float f2 = this.c;
    int n = (int)(f1 - f2 / 2.0F);
    this.a.setStrokeWidth(f2);
    this.a.setColor(this.b);
    this.a.setAntiAlias(true);
    this.a.setStrokeCap(Paint.Cap.ROUND);
    int i1 = this.h;
    if (i1 != 0)
    {
      if (i1 == 1) {
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
      }
    }
    else {
      this.a.setStyle(Paint.Style.STROKE);
    }
    paramCanvas.drawCircle(f1, f1, n, this.a);
    this.a.setStrokeWidth(this.e);
    this.a.setColor(this.d);
    f2 = m - n;
    float f3 = m + n;
    RectF localRectF = new RectF(f2, f2, f3, f3);
    m = this.j * 360 / this.g;
    n = this.h;
    if (n != 0)
    {
      if (n == 1) {
        paramCanvas.drawArc(localRectF, this.i, m, true, this.a);
      }
    }
    else {
      paramCanvas.drawArc(localRectF, this.i, m, false, this.a);
    }
    if (this.l)
    {
      this.a.setStyle(Paint.Style.FILL);
      f3 = this.f / 2.0F;
      if (this.k == null)
      {
        f2 = f1 - f3;
        f1 += f3;
        this.k = new RectF(f2, f2, f1, f1);
      }
      paramCanvas.drawRect(this.k, this.a);
    }
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        this.g = paramInt;
        return;
      }
      finally
      {
        break label28;
      }
    }
    throw new IllegalArgumentException("max not less than 0");
    label28:
    throw localObject;
  }
  
  public void setPauseWithoutInvalidate(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.l = paramBoolean;
    postInvalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 0)
    {
      int m = paramInt;
      try
      {
        if (paramInt > this.g) {
          m = this.g;
        }
        this.j = m;
        postInvalidate();
        return;
      }
      finally
      {
        break label47;
      }
    }
    throw new IllegalArgumentException("progress not less than 0");
    label47:
    throw localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress
 * JD-Core Version:    0.7.0.1
 */