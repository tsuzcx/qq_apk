package com.tencent.mobileqq.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class LoginInfoActivity$NoLineClickableSpan
  extends ClickableSpan
{
  private LoginInfoActivity$NoLineClickableSpan(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onClick(View paramView) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.NoLineClickableSpan
 * JD-Core Version:    0.7.0.1
 */