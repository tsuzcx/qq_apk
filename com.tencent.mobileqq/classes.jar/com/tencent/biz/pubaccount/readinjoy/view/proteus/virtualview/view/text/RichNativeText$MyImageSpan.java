package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;

class RichNativeText$MyImageSpan
  extends ImageSpan
{
  public RichNativeText$MyImageSpan(RichNativeText paramRichNativeText, Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    paramCanvas.translate(paramFloat, paramInt1 - RichNativeText.access$000(this.this$0));
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText.MyImageSpan
 * JD-Core Version:    0.7.0.1
 */