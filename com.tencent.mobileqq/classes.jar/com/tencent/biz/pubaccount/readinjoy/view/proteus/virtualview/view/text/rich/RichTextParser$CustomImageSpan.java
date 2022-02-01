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

public class RichTextParser$CustomImageSpan
  extends ImageSpan
{
  static final int ALIGN_VERTICAL_CENTER = 101;
  public boolean isSingleLine = false;
  private WeakReference<Drawable> mDrawableRef;
  
  RichTextParser$CustomImageSpan(@NonNull Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  private Drawable getCachedDrawable()
  {
    Object localObject1 = this.mDrawableRef;
    if (localObject1 != null) {
      localObject1 = (Drawable)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = getDrawable();
      this.mDrawableRef = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getCachedDrawable();
    Rect localRect = paramCharSequence.getBounds();
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = localRect.bottom;
    paramInt2 = paramPaint.descent;
    paramInt3 = paramPaint.descent;
    paramInt5 = paramPaint.ascent;
    int i = localRect.bottom;
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt4 - paramInt1 + paramInt2 - (paramInt3 - paramInt5 >> 1) + (i >> 1));
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser.CustomImageSpan
 * JD-Core Version:    0.7.0.1
 */