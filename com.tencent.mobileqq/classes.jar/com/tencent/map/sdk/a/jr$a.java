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
    this.b.setStrokeWidth(jr.d(paramjr) * 1.0F);
    this.b.setStyle(Paint.Style.STROKE);
    this.c = new Paint(65);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(0);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j = getHeight();
    int i = (int)(jr.d(this.a) * 6.0F);
    j /= 2;
    paramCanvas.drawPaint(this.c);
    float f1 = i;
    float f2 = j;
    paramCanvas.drawLine(f1, f2, jr.e(this.a) + i, f2, this.b);
    float f3 = jr.d(this.a);
    float f4 = j + 1;
    paramCanvas.drawLine(f1, f2 - f3 * 3.0F, f1, f4, this.b);
    paramCanvas.drawLine(jr.e(this.a) + i, f2 - jr.d(this.a) * 3.0F, i + jr.e(this.a), f4, this.b);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(Math.min(Math.round(jr.e(this.a) + jr.d(this.a) * 12.0F), jr.f(this.a) / 2), Math.round(jr.g(this.a) * jr.d(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.a
 * JD-Core Version:    0.7.0.1
 */