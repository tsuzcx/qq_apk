package com.tencent.mobileqq.activity.aio.item;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class GrayTipsItemBuilder$6
  extends ClickableSpan
{
  GrayTipsItemBuilder$6(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString) {}
  
  public void onClick(View paramView)
  {
    Integer.parseInt(this.a);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */