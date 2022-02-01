package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.tencent.mobileqq.utils.ViewUtils;
import org.jetbrains.annotations.NotNull;

class CommentViewItem$AuthorFlagSpan
  extends ReplacementSpan
{
  private float a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
  }
  
  private TextPaint a(Paint paramPaint)
  {
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(ViewUtils.d(10.0F));
    return paramPaint;
  }
  
  public void draw(@NotNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NotNull Paint paramPaint)
  {
    paramPaint.getFontMetricsInt();
    paramPaint.setTextSize(ViewUtils.b(10.0F));
    paramPaint.setColor(Color.parseColor("#1A006BFF"));
    paramPaint.setAntiAlias(true);
    RectF localRectF = new RectF();
    localRectF.left = ((int)paramFloat);
    localRectF.top = (ViewUtils.b(2.0F) + paramInt3);
    localRectF.bottom = paramInt4;
    localRectF.right = (localRectF.left + (int)a(paramPaint, paramCharSequence, paramInt1, paramInt2) + ViewUtils.b(6.0F));
    paramCanvas.drawRoundRect(localRectF, ViewUtils.b(7.5F), ViewUtils.b(7.5F), paramPaint);
    paramPaint.setColor(Color.parseColor("#006BFF"));
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + ViewUtils.b(3.0F), paramInt4 - ViewUtils.b(3.0F), paramPaint);
  }
  
  public int getSize(@NotNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)a(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem.AuthorFlagSpan
 * JD-Core Version:    0.7.0.1
 */