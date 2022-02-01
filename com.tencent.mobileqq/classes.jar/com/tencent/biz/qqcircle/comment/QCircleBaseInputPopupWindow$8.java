package com.tencent.biz.qqcircle.comment;

import android.text.TextPaint;
import android.text.style.StyleSpan;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCircleBaseInputPopupWindow$8
  extends StyleSpan
{
  QCircleBaseInputPopupWindow$8(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(QCircleSkinHelper.getInstance().getColor(2131167083));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.8
 * JD-Core Version:    0.7.0.1
 */