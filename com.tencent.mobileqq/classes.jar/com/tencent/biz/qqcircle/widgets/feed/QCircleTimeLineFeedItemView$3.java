package com.tencent.biz.qqcircle.widgets.feed;

import android.text.TextPaint;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import zzr;

class QCircleTimeLineFeedItemView$3
  extends StyleSpan
{
  QCircleTimeLineFeedItemView$3(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    zzr.a(paramTextPaint, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */