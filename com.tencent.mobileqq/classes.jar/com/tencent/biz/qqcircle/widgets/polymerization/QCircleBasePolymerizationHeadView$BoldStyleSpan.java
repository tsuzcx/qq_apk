package com.tencent.biz.qqcircle.widgets.polymerization;

import android.text.TextPaint;
import android.text.style.StyleSpan;

class QCircleBasePolymerizationHeadView$BoldStyleSpan
  extends StyleSpan
{
  public QCircleBasePolymerizationHeadView$BoldStyleSpan(int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleBasePolymerizationHeadView.BoldStyleSpan
 * JD-Core Version:    0.7.0.1
 */