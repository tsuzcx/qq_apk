package com.tencent.biz.subscribe.widget.span;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class UserNameSapn
  extends ClickableSpan
{
  private String a;
  private int b;
  private ColorStateList c;
  private UserNameSapn.OnUserNameClickListener d;
  
  public UserNameSapn(String paramString, int paramInt, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.a = paramString;
    this.b = paramInt;
    this.d = paramOnUserNameClickListener;
  }
  
  public UserNameSapn(String paramString, ColorStateList paramColorStateList, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.a = paramString;
    this.c = paramColorStateList;
    this.d = paramOnUserNameClickListener;
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      paramView = this.d;
      if (paramView != null) {
        paramView.a(this.a);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.b;
    if (i > 0) {
      paramTextPaint.setColor(i);
    }
    ColorStateList localColorStateList = this.c;
    if (localColorStateList != null) {
      paramTextPaint.setColor(localColorStateList.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.UserNameSapn
 * JD-Core Version:    0.7.0.1
 */