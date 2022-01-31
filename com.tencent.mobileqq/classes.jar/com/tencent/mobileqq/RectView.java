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
    paramCanvas.drawLine(1, 1, 51, 1, this.mPaint);
    paramCanvas.drawLine(1, 1, 1, 51, this.mPaint);
    paramCanvas.drawLine(1, j, 1, j - 50, this.mPaint);
    paramCanvas.drawLine(1, j, 51, j, this.mPaint);
    paramCanvas.drawLine(i, 1, i - 50, 1, this.mPaint);
    paramCanvas.drawLine(i, 1, i, 51, this.mPaint);
    paramCanvas.drawLine(i, j, i, j - 50, this.mPaint);
    paramCanvas.drawLine(i, j, i - 50, j, this.mPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.RectView
 * JD-Core Version:    0.7.0.1
 */