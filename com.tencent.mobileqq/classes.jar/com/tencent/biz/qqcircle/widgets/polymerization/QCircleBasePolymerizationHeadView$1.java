package com.tencent.biz.qqcircle.widgets.polymerization;

import android.text.TextPaint;
import android.text.style.StyleSpan;

class QCircleBasePolymerizationHeadView$1
  extends StyleSpan
{
  QCircleBasePolymerizationHeadView$1(QCircleBasePolymerizationHeadView paramQCircleBasePolymerizationHeadView, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView.1
 * JD-Core Version:    0.7.0.1
 */