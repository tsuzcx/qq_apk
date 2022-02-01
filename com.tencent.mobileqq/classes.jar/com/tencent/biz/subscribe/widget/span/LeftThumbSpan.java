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
  private int jdField_a_of_type_Int;
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int b = 2147483647;
  private int c = -1;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(this.d, 0.0F);
    paramPaint.setAntiAlias(true);
    paramInt5 = (int)(paramInt4 + paramPaint.ascent());
    int k = (int)(paramInt4 + paramPaint.descent());
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsShader != null)
    {
      localObject = new RectF((int)paramFloat + 1, paramInt5, (int)paramFloat + this.jdField_a_of_type_Int - this.e, k);
      Paint.Style localStyle = paramPaint.getStyle();
      Shader localShader = paramPaint.getShader();
      int m = paramPaint.getColor();
      paramPaint.setColor(Color.parseColor("#7f000000"));
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, paramPaint);
      paramPaint.setColor(m);
      paramPaint.setStyle(Paint.Style.STROKE);
      paramPaint.setStrokeWidth(2.0F);
      paramPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, paramPaint);
      paramPaint.setShader(localShader);
      paramPaint.setStyle(localStyle);
    }
    paramCanvas.save();
    paramCanvas.translate(this.f, this.g + paramInt5 - paramInt3);
    float f1 = paramInt4;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
      paramInt3 = ((Rect)localObject).width();
      paramInt4 = ((Rect)localObject).height();
      ((Rect)localObject).left = ((int)paramFloat);
      ((Rect)localObject).right = (((Rect)localObject).left + paramInt3);
      ((Rect)localObject).top = ((k - paramInt5 - this.g - this.i) / 2 - paramInt4 / 2);
      ((Rect)localObject).bottom = (paramInt4 + ((Rect)localObject).top);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramFloat += this.j + paramInt3;
    }
    for (;;)
    {
      float f2 = paramPaint.getTextSize();
      if (this.c != -1)
      {
        paramPaint.setTextSize(this.c);
        f1 = (k - paramInt5 - this.g - this.i) / 2 + this.c / 2 - this.c * 11 / 100;
      }
      paramInt3 = paramPaint.getColor();
      if (this.b != 2147483647) {
        paramPaint.setColor(this.b);
      }
      boolean bool = paramPaint.isFakeBoldText();
      paramPaint.setFakeBoldText(this.jdField_a_of_type_Boolean);
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, f1, paramPaint);
      paramCanvas.restore();
      paramPaint.setColor(paramInt3);
      paramPaint.setTextSize(f2);
      paramPaint.setFakeBoldText(bool);
      paramCanvas.restore();
      return;
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    float f1 = paramPaint.getTextSize();
    if (this.c != -1) {
      paramPaint.setTextSize(this.c);
    }
    paramInt1 = (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.d + this.f + this.h + this.e;
    paramPaint.setTextSize(f1);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      paramInt1 += this.j + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (this.jdField_a_of_type_ArrayOfInt != null) {
        this.jdField_a_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, 0.0F, this.jdField_a_of_type_Int, 0.0F, this.jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP);
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.LeftThumbSpan
 * JD-Core Version:    0.7.0.1
 */