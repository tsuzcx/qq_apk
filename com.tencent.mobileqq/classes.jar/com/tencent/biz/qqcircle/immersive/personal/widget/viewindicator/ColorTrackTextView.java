package com.tencent.biz.qqcircle.immersive.personal.widget.viewindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import androidx.appcompat.widget.AppCompatTextView;

public class ColorTrackTextView
  extends AppCompatTextView
{
  private final int a;
  private final int b;
  private float c;
  private final int d;
  private boolean e;
  private int f;
  private Paint g;
  
  private void a(Canvas paramCanvas, int paramInt, float paramFloat1, float paramFloat2)
  {
    String str = getText().toString();
    this.g.setColor(paramInt);
    paramCanvas.save();
    paramCanvas.clipRect(paramFloat1, 0.0F, paramFloat2, getHeight());
    Rect localRect = new Rect();
    this.g.getTextBounds(str, 0, str.length(), localRect);
    Paint.FontMetrics localFontMetrics = this.g.getFontMetrics();
    paramFloat1 = localFontMetrics.bottom - localFontMetrics.top;
    paramFloat2 = paramFloat1 / 2.0F;
    float f1 = localFontMetrics.bottom;
    paramCanvas.drawText(str, (this.f - localRect.width()) / 2, (getHeight() + paramFloat1) / 2.0F - (paramFloat2 - f1), this.g);
    paramCanvas.restore();
  }
  
  void a(float paramFloat, boolean paramBoolean)
  {
    this.c = paramFloat;
    this.e = paramBoolean;
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.c;
    if (f1 == -1.0F)
    {
      a(paramCanvas, this.a, 0.0F, this.f);
      return;
    }
    f1 *= this.f;
    if (this.e)
    {
      a(paramCanvas, this.a, 0.0F, f1);
      a(paramCanvas, this.b, f1, this.f);
      return;
    }
    a(paramCanvas, this.b, 0.0F, f1);
    a(paramCanvas, this.a, f1, this.f);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (getWidth() - this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.viewindicator.ColorTrackTextView
 * JD-Core Version:    0.7.0.1
 */