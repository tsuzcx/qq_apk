package com.tencent.biz.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class CenteredImageSpan
  extends ImageSpan
{
  private WeakReference<Drawable> a;
  
  public CenteredImageSpan(Drawable paramDrawable)
  {
    super(paramDrawable);
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
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    paramInt1 = paramCharSequence.getIntrinsicHeight();
    paramInt2 = paramPaint.getFontMetricsInt().ascent;
    paramInt3 = paramPaint.getFontMetricsInt().descent;
    paramCanvas.translate(paramFloat, (paramInt5 - paramCharSequence.getBounds().bottom + (paramInt1 - paramInt3 + paramInt2) / 2) / 5);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = a().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.ascent = paramPaint.ascent;
      paramFontMetricsInt.descent = paramPaint.descent;
      paramFontMetricsInt.top = paramPaint.top;
      paramFontMetricsInt.bottom = paramPaint.bottom;
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CenteredImageSpan
 * JD-Core Version:    0.7.0.1
 */