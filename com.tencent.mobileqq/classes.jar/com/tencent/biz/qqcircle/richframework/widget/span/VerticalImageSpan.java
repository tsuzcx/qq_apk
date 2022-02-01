package com.tencent.biz.qqcircle.richframework.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class VerticalImageSpan
  extends ImageSpan
{
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = (paramPaint.descent + paramInt4 + paramInt4 + paramPaint.ascent) / 2;
    paramInt2 = paramCharSequence.getBounds().bottom / 2;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt1 - paramInt2);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.span.VerticalImageSpan
 * JD-Core Version:    0.7.0.1
 */