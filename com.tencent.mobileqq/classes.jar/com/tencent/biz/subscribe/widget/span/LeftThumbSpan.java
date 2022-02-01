package com.tencent.biz.subscribe.widget.span;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

public class LeftThumbSpan
  extends ReplacementSpan
{
  private int a;
  private int b = 2147483647;
  private int c = -1;
  private boolean d = false;
  private Drawable e;
  private Shader f;
  private int[] g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    float f1 = paramFloat;
    paramCanvas.save();
    paramCanvas.translate(this.h, 0.0F);
    paramPaint.setAntiAlias(true);
    float f2 = paramInt4;
    paramInt4 = (int)(paramPaint.ascent() + f2);
    paramInt5 = (int)(paramPaint.descent() + f2);
    int i1;
    if (this.f != null)
    {
      i1 = (int)f1;
      localObject = new RectF(i1 + 1, paramInt4, i1 + this.a - this.i, paramInt5);
      Paint.Style localStyle = paramPaint.getStyle();
      Shader localShader = paramPaint.getShader();
      i1 = paramPaint.getColor();
      paramPaint.setColor(Color.parseColor("#7f000000"));
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, paramPaint);
      paramPaint.setColor(i1);
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(2.0F);
      paramPaint.setShader(this.f);
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, paramPaint);
      paramPaint.setShader(localShader);
      paramPaint.setStyle(localStyle);
    }
    paramCanvas.save();
    paramCanvas.translate(this.j, this.k + paramInt4 - paramInt3);
    Object localObject = this.e;
    paramFloat = f1;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).getBounds();
      paramInt3 = ((Rect)localObject).width();
      i1 = ((Rect)localObject).height();
      ((Rect)localObject).left = ((int)f1);
      ((Rect)localObject).right = (((Rect)localObject).left + paramInt3);
      ((Rect)localObject).top = ((paramInt5 - paramInt4 - this.k - this.m) / 2 - i1 / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + i1);
      this.e.draw(paramCanvas);
      paramFloat = f1 + (this.n + paramInt3);
    }
    float f3 = paramPaint.getTextSize();
    paramInt3 = this.c;
    if (paramInt3 != -1)
    {
      paramPaint.setTextSize(paramInt3);
      paramInt3 = (paramInt5 - paramInt4 - this.k - this.m) / 2;
      paramInt4 = this.c;
      f1 = paramInt3 + paramInt4 / 2 - paramInt4 * 11 / 100;
    }
    else
    {
      f1 = f2;
    }
    paramInt3 = paramPaint.getColor();
    paramInt4 = this.b;
    if (paramInt4 != 2147483647) {
      paramPaint.setColor(paramInt4);
    }
    boolean bool = paramPaint.isFakeBoldText();
    paramPaint.setFakeBoldText(this.d);
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, f1, paramPaint);
    paramCanvas.restore();
    paramPaint.setColor(paramInt3);
    paramPaint.setTextSize(f3);
    paramPaint.setFakeBoldText(bool);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    float f1 = paramPaint.getTextSize();
    int i1 = this.c;
    if (i1 != -1) {
      paramPaint.setTextSize(i1);
    }
    paramInt2 = (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.h + this.j + this.l + this.i;
    paramPaint.setTextSize(f1);
    paramPaint = this.e;
    paramInt1 = paramInt2;
    if (paramPaint != null) {
      paramInt1 = paramInt2 + (this.n + paramPaint.getBounds().width());
    }
    this.a = paramInt1;
    paramPaint = this.g;
    if (paramPaint != null) {
      this.f = new LinearGradient(0.0F, 0.0F, this.a, 0.0F, paramPaint, null, Shader.TileMode.CLAMP);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.LeftThumbSpan
 * JD-Core Version:    0.7.0.1
 */