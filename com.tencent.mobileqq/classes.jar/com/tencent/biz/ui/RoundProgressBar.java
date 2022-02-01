package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class RoundProgressBar
  extends View
{
  Runnable a = new RoundProgressBar.1(this);
  private Paint b = new Paint();
  private int c = -252645121;
  private int d = -1529614848;
  private int e = -16777216;
  private float f = 20.0F;
  private float g = 18.0F;
  private float h = 5.0F;
  private int i = 100;
  private int j = 0;
  private int k;
  private RectF l = new RectF();
  private boolean m = true;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.k = paramInt;
    ThreadManager.getUIHandler().postDelayed(this.a, 30L);
  }
  
  public int getCircleColor()
  {
    return this.c;
  }
  
  public int getCircleProgressColor()
  {
    return this.d;
  }
  
  public int getMax()
  {
    try
    {
      int n = this.i;
      return n;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getProgress()
  {
    try
    {
      int n = this.j;
      return n;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public float getRoundWidth()
  {
    return this.h;
  }
  
  public int getTextColor()
  {
    return this.e;
  }
  
  public float getTextSize()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = getWidth() / 2;
    float f1 = n;
    int i1 = (int)(f1 - this.h / 2.0F);
    this.b.setColor(this.c);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.h);
    this.b.setAntiAlias(true);
    paramCanvas.drawCircle(f1, f1, i1, this.b);
    this.b.setStrokeWidth(this.h);
    this.b.setColor(this.d);
    Object localObject = this.l;
    float f2 = n - i1;
    float f3 = n + i1;
    ((RectF)localObject).set(f2, f2, f3, f3);
    this.b.setStyle(Paint.Style.STROKE);
    paramCanvas.drawArc(this.l, -90.0F, this.j * 360 / this.i, false, this.b);
    this.b.setStrokeWidth(0.0F);
    this.b.setColor(this.e);
    this.b.setTextSize(this.f);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    n = this.j * 100 / this.i;
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append("");
    f2 = ((Paint)localObject).measureText(localStringBuilder.toString());
    this.b.setTextSize(this.g);
    f3 = this.b.measureText("%");
    if ((n != 0) && (this.m))
    {
      this.b.setTextSize(this.f);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      f3 = f1 - (f3 + f2) / 2.0F;
      paramCanvas.drawText((String)localObject, f3, this.f / 2.0F + f1, this.b);
      this.b.setTextSize(this.g);
      paramCanvas.drawText("%", f3 + f2, f1 + this.f / 2.0F, this.b);
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        this.i = paramInt;
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
  
  public void setNeedShowProgreeText(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setPercentMarkTextSize(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 0)
    {
      int n = paramInt;
      try
      {
        if (paramInt > this.i) {
          n = this.i;
        }
        if ((n <= this.i) && (this.j != n)) {
          a(n);
        }
        return;
      }
      finally
      {
        break label59;
      }
    }
    throw new IllegalArgumentException("progress not less than 0");
    label59:
    throw localObject;
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setTextColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.f = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */