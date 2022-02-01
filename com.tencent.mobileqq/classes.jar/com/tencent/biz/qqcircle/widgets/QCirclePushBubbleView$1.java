package com.tencent.biz.qqcircle.widgets;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class QCirclePushBubbleView$1
  extends ClickableSpan
{
  QCirclePushBubbleView$1(QCirclePushBubbleView paramQCirclePushBubbleView) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    this.a.a(112, 2);
    this.a.e();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-11145);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView.1
 * JD-Core Version:    0.7.0.1
 */