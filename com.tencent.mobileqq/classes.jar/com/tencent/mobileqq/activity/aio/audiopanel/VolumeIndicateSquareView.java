package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqui.R.styleable;

public class VolumeIndicateSquareView
  extends View
{
  public int[] a;
  private boolean b = true;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private Paint g;
  private int h = 0;
  
  public VolumeIndicateSquareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fu);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int i = R.styleable.fw;
    boolean bool = false;
    if (paramTypedArray.getInt(i, 0) == 0) {
      bool = true;
    }
    this.b = bool;
    this.c = paramTypedArray.getInt(R.styleable.fx, 5);
    this.d = ((int)paramTypedArray.getDimension(R.styleable.fz, 8.0F));
    this.e = paramTypedArray.getColor(R.styleable.fv, -16776961);
    this.a = new int[this.c];
  }
  
  public void a()
  {
    if (this.a != null)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = 0;
        i += 1;
      }
      this.f = 0;
    }
    invalidate();
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = this.f;
    arrayOfInt[i] = paramInt;
    this.f = (i + 1);
    if (this.f >= this.c) {
      this.f = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.f - 1;
    int j = 0;
    for (;;)
    {
      int m = this.c;
      if (j >= m) {
        break;
      }
      int k = i;
      if (i < 0) {
        k = m - 1;
      }
      float f2 = this.a[k];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f1 = f2 / 2.0F;
      i = this.d;
      f2 = f1 * i;
      if (this.b) {
        f1 = j * 2.0F * i;
      } else {
        f1 = (this.c - 1 - j) * 2.0F * i + i;
      }
      i = this.h;
      paramCanvas.drawRect(f1, i - f2, f1 + this.d, i + f2, this.g);
      i = k - 1;
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c;
    paramInt2 = this.d;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), paramInt2 * 8 + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (paramInt2 / 2);
    if (this.g == null)
    {
      this.g = new Paint();
      this.g.setStyle(Paint.Style.FILL);
      this.g.setColor(this.e);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
    Paint localPaint = this.g;
    if (localPaint != null) {
      localPaint.setColor(this.e);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView
 * JD-Core Version:    0.7.0.1
 */