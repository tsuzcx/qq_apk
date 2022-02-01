package com.tencent.biz.subscribe.widget.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class CustomUrlSpan
  extends ClickableSpan
{
  private String a;
  private String b;
  private CustomUrlSpan.OnCustomUrlClickListener c;
  private int d;
  
  public void onClick(View paramView)
  {
    paramView = this.c;
    if (paramView != null) {
      paramView.a(this.a, this.b);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.d;
    if (i != -2147483648)
    {
      paramTextPaint.setColor(i);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.CustomUrlSpan
 * JD-Core Version:    0.7.0.1
 */