package com.tencent.mobileqq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class RectView
  extends View
{
  private Paint mPaint = new Paint(1);
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mPaint.setColor(Color.parseColor("#00a5e0"));
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(8.0F);
    int i = getWidth() - 1;
    int j = getHeight() - 1;
    float f1 = 1;
    float f2 = 51;
    paramCanvas.drawLine(f1, f1, f2, f1, this.mPaint);
    paramCanvas.drawLine(f1, f1, f1, f2, this.mPaint);
    float f3 = j;
    float f4 = j - 50;
    paramCanvas.drawLine(f1, f3, f1, f4, this.mPaint);
    paramCanvas.drawLine(f1, f3, f2, f3, this.mPaint);
    float f5 = i;
    float f6 = i - 50;
    paramCanvas.drawLine(f5, f1, f6, f1, this.mPaint);
    paramCanvas.drawLine(f5, f1, f5, f2, this.mPaint);
    paramCanvas.drawLine(f5, f3, f5, f4, this.mPaint);
    paramCanvas.drawLine(f5, f3, f6, f3, this.mPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.RectView
 * JD-Core Version:    0.7.0.1
 */