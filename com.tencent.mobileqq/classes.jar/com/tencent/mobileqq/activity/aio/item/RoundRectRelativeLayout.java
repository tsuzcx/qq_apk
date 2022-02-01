package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.widget.RelativeLayout;

public class RoundRectRelativeLayout
  extends RelativeLayout
{
  private int a;
  private int b;
  private int c;
  private int d = 0;
  private Path e;
  
  public RoundRectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.e = new Path();
    int i = this.a;
    if (i == 0)
    {
      this.e.addRect(0.0F, 0.0F, this.b, this.c, Path.Direction.CCW);
      return;
    }
    i = Math.min(i * 2, Math.min(this.b, this.c)) / 2;
    Path localPath = this.e;
    RectF localRectF = new RectF(0.0F, 0.0F, this.b, this.c);
    float f = i;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CCW);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger;
    if (this.e != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.e);
    }
    else
    {
      localInteger = null;
    }
    paramCanvas.drawColor(this.d);
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.b) && (paramInt2 == this.c)) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt2;
    a();
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.a == i) {
      return;
    }
    this.a = i;
    a();
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    this.d = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RoundRectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */