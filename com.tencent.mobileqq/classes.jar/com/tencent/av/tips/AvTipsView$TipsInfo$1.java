package com.tencent.av.tips;

import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

final class AvTipsView$TipsInfo$1
  extends ClickableSpan
{
  AvTipsView$TipsInfo$1(View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.TipsInfo.1
 * JD-Core Version:    0.7.0.1
 */