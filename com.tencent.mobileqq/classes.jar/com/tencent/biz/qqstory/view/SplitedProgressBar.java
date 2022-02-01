package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

public class SplitedProgressBar
  extends View
{
  public int a = 1;
  public int b = 1;
  public int c;
  public int d;
  public int e = 872415231;
  public int f = 2147483647;
  public int g = 3;
  public int h = 4;
  public int i = 0;
  public int j = 1;
  public Paint k = new Paint();
  
  public SplitedProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getTotalCount()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = super.getWidth();
    if (this.b == 0) {
      return;
    }
    this.k.setStrokeWidth(this.g);
    int i1 = this.j;
    int m = this.i;
    float f1 = (n - (i1 - m - 1) * this.h) / (i1 - m);
    while (m < this.j)
    {
      i1 = this.i;
      float f2 = m - i1;
      int i2 = this.h;
      n = (int)(f2 * (i2 + f1));
      i1 = (int)((m - i1) * (i2 + f1) + f1);
      i2 = this.c;
      float f3;
      if (m < i2)
      {
        this.k.setStrokeWidth(this.g);
        this.k.setColor(this.f);
        f2 = n + 1;
        f3 = i1 - 1;
        paramCanvas.drawLine(f2, 1.0F, f3, 1.0F, this.k);
        this.k.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(n, 1.0F, this.k);
        paramCanvas.drawPoint(f3, 1.0F, this.k);
      }
      else if (m == i2)
      {
        this.k.setStrokeWidth(this.g);
        this.k.setColor(this.f);
        f3 = n + 1;
        f2 = n;
        paramCanvas.drawLine(f3, 1.0F, f2 + this.d * f1 / 100.0F, 1.0F, this.k);
        this.k.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(f2, 1.0F, this.k);
        this.k.setStrokeWidth(this.g);
        this.k.setColor(this.e);
        f3 = this.d * f1 / 100.0F;
        float f4 = i1 - 1;
        paramCanvas.drawLine(f2 + f3, 1.0F, f4, 1.0F, this.k);
        this.k.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(f4, 1.0F, this.k);
      }
      else
      {
        this.k.setStrokeWidth(this.g);
        this.k.setColor(this.e);
        f2 = n + 1;
        f3 = i1 - 1;
        paramCanvas.drawLine(f2, 1.0F, f3, 1.0F, this.k);
        this.k.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(n, 1.0F, this.k);
        paramCanvas.drawPoint(f3, 1.0F, this.k);
      }
      m += 1;
    }
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    int m = this.b;
    if (m <= 0) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < m))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= 100))
      {
        this.c = paramInt1;
        this.d = paramInt2;
        paramInt1 = this.c;
        paramInt2 = this.a;
        if (paramInt1 < paramInt2)
        {
          this.i = 0;
          this.j = paramInt2;
        }
        else
        {
          for (this.i = paramInt2;; this.i = (paramInt2 + m))
          {
            paramInt2 = this.i;
            m = this.a;
            if (paramInt2 + m > this.c) {
              break;
            }
          }
          paramInt1 = this.b;
          if (paramInt1 >= paramInt2 + m) {
            paramInt1 = paramInt2 + m;
          }
          this.j = paramInt1;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          super.invalidate();
          return;
        }
        super.postInvalidate();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setProgress Exception, progress is < 0 or > 100, progress = ");
      ((StringBuilder)localObject).append(paramInt2);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setProgress Exception, progressIndex is < 0 or > mTotalCount, progressIndex = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", mTotalCount = ");
    ((StringBuilder)localObject).append(this.b);
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setShowMaxCount(int paramInt)
  {
    if (paramInt >= 1)
    {
      int m = paramInt;
      if (paramInt > 50) {
        m = 50;
      }
      this.a = m;
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        super.invalidate();
        return;
      }
      super.postInvalidate();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setShowMaxCount Exception, count is < 1, count = ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.b = paramInt;
      setShowMaxCount(paramInt);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        super.invalidate();
        return;
      }
      super.postInvalidate();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTotalCount Exception, count is < 0, count = ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.SplitedProgressBar
 * JD-Core Version:    0.7.0.1
 */