package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public final class jr$a
  extends View
{
  private Paint b = new Paint();
  private Paint c;
  
  public jr$a(jr paramjr, Context paramContext)
  {
    super(paramContext);
    this.b.setAntiAlias(true);
    this.b.setColor(-16777216);
    this.b.setStrokeWidth(1.0F * jr.d(paramjr));
    this.b.setStyle(Paint.Style.STROKE);
    this.c = new Paint(65);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(0);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j = getHeight();
    int i = (int)(6.0F * jr.d(this.a));
    j /= 2;
    paramCanvas.drawPaint(this.c);
    paramCanvas.drawLine(i, j, jr.e(this.a) + i, j, this.b);
    paramCanvas.drawLine(i, j - jr.d(this.a) * 3.0F, i, j + 1, this.b);
    paramCanvas.drawLine(jr.e(this.a) + i, j - jr.d(this.a) * 3.0F, jr.e(this.a) + i, j + 1, this.b);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(Math.min(Math.round(jr.e(this.a) + 12.0F * jr.d(this.a)), jr.f(this.a) / 2), Math.round(jr.g(this.a) * jr.d(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.a
 * JD-Core Version:    0.7.0.1
 */