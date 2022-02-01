package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMFormVerifyCodeInputView$1
  implements View.OnFocusChangeListener
{
  MMFormVerifyCodeInputView$1(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == MMFormVerifyCodeInputView.a(this.a))
    {
      MMFormVerifyCodeInputView.b(this.a);
      if (paramBoolean) {
        this.a.setBackgroundResource(2130841265);
      } else {
        this.a.setBackgroundResource(2130841266);
      }
      MMFormVerifyCodeInputView.c(this.a);
    }
    if (MMFormVerifyCodeInputView.d(this.a) != null) {
      MMFormVerifyCodeInputView.d(this.a).onFocusChange(paramView, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView.1
 * JD-Core Version:    0.7.0.1
 */