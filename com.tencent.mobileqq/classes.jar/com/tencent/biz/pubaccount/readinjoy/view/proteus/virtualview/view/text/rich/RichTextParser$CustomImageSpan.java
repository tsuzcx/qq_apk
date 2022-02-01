package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

class RichTextParser$CustomImageSpan
  extends ImageSpan
{
  static final int ALIGN_VERTICAL_CENTER = 101;
  private WeakReference<Drawable> mDrawableRef;
  
  RichTextParser$CustomImageSpan(@NonNull Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  private Drawable getCachedDrawable()
  {
    Object localObject = this.mDrawableRef;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      this.mDrawableRef = new WeakReference(localObject);
    }
    return localObject;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getCachedDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    for (;;)
    {
      paramCanvas.translate(paramFloat, paramInt1);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
      if (this.mVerticalAlignment == 101)
      {
        paramInt3 = paramInt5 / 2 - paramCharSequence.getBounds().bottom / 2 - RichTextParser.access$000() / 2;
        paramInt1 = paramInt3;
        if (paramInt3 <= 0) {
          paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
        }
      }
      else
      {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramPaint = getCachedDrawable().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-paramPaint.bottom);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return paramPaint.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser.CustomImageSpan
 * JD-Core Version:    0.7.0.1
 */