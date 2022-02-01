package com.tencent.biz.qqstory.view.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class AlignImageSpan
  extends ImageSpan
{
  private WeakReference<Drawable> a;
  
  public AlignImageSpan(Drawable paramDrawable)
  {
    this(paramDrawable, 4);
  }
  
  public AlignImageSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  private Drawable a()
  {
    Object localObject1 = this.a;
    if (localObject1 != null) {
      localObject1 = (Drawable)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = getDrawable();
      this.a = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramPaint = paramCharSequence.getBounds();
    paramInt1 = this.mVerticalAlignment;
    float f;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 4) {}
        for (paramInt1 = paramInt5 - paramPaint.height();; paramInt1 = (paramInt5 - paramInt3 - paramPaint.height()) / 2 + paramInt3)
        {
          f = paramInt1;
          break;
        }
      }
      f = paramInt3;
    }
    else
    {
      f = paramInt4 - paramPaint.height();
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, f);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = a().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetrics();
      float f1 = paramPaint.top - paramPaint.ascent;
      float f2 = paramPaint.bottom - paramPaint.descent;
      float f3 = paramPaint.descent;
      float f4 = paramPaint.ascent;
      paramInt1 = paramCharSequence.height();
      paramInt2 = this.mVerticalAlignment;
      if (paramInt2 != 1)
      {
        if (paramInt2 != 3)
        {
          if (paramInt2 != 4)
          {
            f2 = paramPaint.descent - paramInt1;
            paramFontMetricsInt.ascent = ((int)f2);
            paramFontMetricsInt.top = ((int)(f2 + f1));
          }
          else
          {
            f4 = paramPaint.descent - (f3 - f4) / 2.0F;
            float f5 = paramInt1 / 2;
            f3 = f4 - f5;
            f4 += f5;
            paramFontMetricsInt.ascent = ((int)f3);
            paramFontMetricsInt.top = ((int)(f3 + f1));
            paramFontMetricsInt.descent = ((int)f4);
            paramFontMetricsInt.bottom = ((int)(f4 + f2));
          }
        }
        else
        {
          f1 = paramInt1 + paramPaint.ascent;
          paramFontMetricsInt.descent = ((int)f1);
          paramFontMetricsInt.bottom = ((int)(f1 + f2));
        }
      }
      else
      {
        paramInt1 = -paramInt1;
        f2 = paramInt1;
        paramFontMetricsInt.ascent = paramInt1;
        paramFontMetricsInt.top = ((int)(f2 + f1));
      }
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AlignImageSpan
 * JD-Core Version:    0.7.0.1
 */