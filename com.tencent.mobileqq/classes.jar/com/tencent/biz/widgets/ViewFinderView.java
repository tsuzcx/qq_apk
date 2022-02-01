package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

class ViewFinderView
  extends View
{
  Drawable a = getResources().getDrawable(2130844364);
  Drawable b = getResources().getDrawable(2130844381);
  Paint c = new Paint(1);
  Rect d;
  int e = 0;
  int f = 0;
  boolean g = false;
  long h;
  protected int i;
  protected int j = this.b.getIntrinsicHeight();
  protected double k;
  
  public ViewFinderView(Context paramContext)
  {
    super(paramContext);
    this.c.setColor(1275068416);
  }
  
  protected void a()
  {
    if (!this.g)
    {
      this.h = System.currentTimeMillis();
      this.g = true;
      invalidate();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.setBounds(localRect);
    this.i = (paramInt4 - paramInt2 - this.j);
    double d1 = this.i;
    Double.isNaN(d1);
    this.k = (d1 / 5000.0D);
    this.d = localRect;
    invalidate();
  }
  
  protected void b()
  {
    this.g = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.d;
    if ((localRect != null) && (localRect.width() != 0) && (localRect.height() != 0))
    {
      paramCanvas.drawRect(0.0F, 0.0F, this.e, localRect.top, this.c);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.c);
      paramCanvas.drawRect(localRect.right, localRect.top, this.e, localRect.bottom, this.c);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.e, this.f, this.c);
      this.a.draw(paramCanvas);
      if (this.g)
      {
        double d1 = System.currentTimeMillis() - this.h;
        double d2 = this.k;
        Double.isNaN(d1);
        int m = (int)(d1 * d2) % this.i;
        this.b.setBounds(localRect.left, localRect.top + m, localRect.right, localRect.top + m + this.j);
        this.b.draw(paramCanvas);
        postInvalidateDelayed(20L, localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
    }
    else
    {
      paramCanvas.drawRect(0.0F, 0.0F, this.e, this.f, this.c);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new ViewFinderView.1(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ViewFinderView
 * JD-Core Version:    0.7.0.1
 */