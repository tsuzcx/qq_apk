package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class AlphaLoadingView
  extends View
{
  private int a;
  private int b;
  private int c = -1;
  private int d = 5;
  private int e = this.f;
  private int f = 100;
  private Paint g = new Paint();
  private String h = "#00CAFC";
  private Handler i;
  private int j = 16;
  private boolean k;
  
  public AlphaLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g.setStyle(Paint.Style.FILL_AND_STROKE);
    this.g.setAntiAlias(true);
    this.i = new AlphaLoadingView.1(this);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int n = View.MeasureSpec.getMode(paramInt);
    int m = View.MeasureSpec.getSize(paramInt);
    if (n != -2147483648)
    {
      if (n != 0)
      {
        paramInt = m;
        if (n != 1073741824)
        {
          if (paramBoolean) {
            return this.c;
          }
          paramInt = this.d;
        }
        return paramInt;
      }
      if (paramBoolean) {
        return this.c;
      }
      return this.d;
    }
    if (paramBoolean) {
      paramInt = this.c;
    } else {
      paramInt = this.d;
    }
    return Math.min(paramInt, m);
  }
  
  public void a()
  {
    Handler localHandler = this.i;
    if (localHandler != null)
    {
      this.k = false;
      localHandler.sendEmptyMessage(1);
      setVisibility(0);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.i;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.k = true;
      setVisibility(8);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    Handler localHandler = this.i;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = this.e;
    if (m < this.a) {
      this.e = (m + 30);
    } else {
      this.e = this.f;
    }
    int n = 255 - this.e * 255 / this.a;
    m = n;
    if (n > 255) {
      m = 255;
    }
    n = m;
    if (m < 30) {
      n = 30;
    }
    String str = Integer.toHexString(n);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(str);
    str = this.h;
    localStringBuilder.append(str.substring(1, str.length()));
    m = Color.parseColor(localStringBuilder.toString());
    this.g.setColor(m);
    m = this.a;
    int i1 = m / 2;
    n = this.e;
    float f1 = i1 - n / 2;
    i1 = this.d;
    paramCanvas.drawLine(f1, i1 / 2, m / 2 + n / 2, i1 / 2, this.g);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = paramInt1;
    this.b = paramInt2;
    paramInt1 = this.a;
    paramInt2 = this.e;
    if (paramInt1 < paramInt2) {
      this.a = paramInt2;
    }
    this.g.setStrokeWidth(this.b);
  }
  
  public void setTimePeriod(int paramInt)
  {
    if (this.j > 0) {
      this.j = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AlphaLoadingView
 * JD-Core Version:    0.7.0.1
 */