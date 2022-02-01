package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

class VideoFeedsSoftAdBarDelegateForAd$MarginSpan
  extends ReplacementSpan
{
  private int a;
  
  public VideoFeedsSoftAdBarDelegateForAd$MarginSpan(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {}
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.MarginSpan
 * JD-Core Version:    0.7.0.1
 */