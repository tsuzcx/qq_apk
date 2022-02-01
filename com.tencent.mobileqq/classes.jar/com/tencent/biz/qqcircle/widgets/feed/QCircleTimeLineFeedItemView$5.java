package com.tencent.biz.qqcircle.widgets.feed;

import android.text.TextPaint;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;

class QCircleTimeLineFeedItemView$5
  extends StyleSpan
{
  QCircleTimeLineFeedItemView$5(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    RFWTypefaceUtil.a(paramTextPaint, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.5
 * JD-Core Version:    0.7.0.1
 */