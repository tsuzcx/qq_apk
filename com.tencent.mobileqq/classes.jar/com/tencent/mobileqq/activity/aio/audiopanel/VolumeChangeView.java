package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqui.R.styleable;

public class VolumeChangeView
  extends View
{
  public int[] a;
  private boolean b = true;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private Paint h;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  public VolumeChangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fu);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int m = R.styleable.fw;
    boolean bool = false;
    if (paramTypedArray.getInt(m, 0) == 0) {
      bool = true;
    }
    this.b = bool;
    this.c = paramTypedArray.getInt(R.styleable.fx, 5);
    this.d = ((int)paramTypedArray.getDimension(R.styleable.fz, 8.0F));
    this.e = ((int)paramTypedArray.getDimension(R.styleable.fy, 48.0F));
    this.f = getResources().getColor(2131167985);
    this.k = getResources().getColor(2131167984);
    this.l = getResources().getDimensionPixelOffset(2131300032);
    this.a = new int[this.c];
  }
  
  public void a()
  {
    if (this.a != null)
    {
      int m = 0;
      for (;;)
      {
        int[] arrayOfInt = this.a;
        if (m >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[m] = 0;
        m += 1;
      }
      this.g = 0;
    }
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    if (this.j < 1) {
      this.j = 1;
    }
    if (this.j > 10) {
      this.j = 10;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = 0;
    while (m < this.c)
    {
      boolean bool = this.b;
      float f1 = 0.0F;
      if (bool)
      {
        if (m < this.j) {
          this.h.setColor(this.k);
        } else {
          this.h.setColor(this.f);
        }
        if (m == 0) {
          break label156;
        }
        n = (this.l + this.d) * m;
      }
      else
      {
        if (m < this.j) {
          this.h.setColor(this.k);
        } else {
          this.h.setColor(this.f);
        }
        n = this.c;
        if (m == n - 1) {
          break label156;
        }
        n = (n - 1 - m) * (this.l + this.d);
      }
      f1 = n;
      label156:
      int n = this.i;
      int i1 = this.e;
      paramCanvas.drawRect(f1, n - i1 / 2, f1 + this.d, n + i1 / 2, this.h);
      m += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c;
    paramInt2 = this.d;
    int m = this.l;
    int n = this.e;
    setMeasuredDimension(paramInt1 * (paramInt2 + m) + getPaddingLeft() + getPaddingRight(), n + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = (paramInt2 / 2);
    if (this.h == null)
    {
      this.h = new Paint();
      this.h.setStyle(Paint.Style.FILL);
      this.h.setColor(this.f);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.k = paramInt;
    Paint localPaint = this.h;
    if (localPaint != null) {
      localPaint.setColor(this.k);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.c = paramInt;
    this.a = new int[this.c];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView
 * JD-Core Version:    0.7.0.1
 */