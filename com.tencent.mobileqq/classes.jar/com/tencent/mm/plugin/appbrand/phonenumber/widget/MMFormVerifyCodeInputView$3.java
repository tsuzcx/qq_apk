package com.tencent.mm.plugin.appbrand.phonenumber.widget;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;

class MMFormVerifyCodeInputView$3
  implements v.a
{
  MMFormVerifyCodeInputView$3(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public boolean p_()
  {
    MMFormVerifyCodeInputView.f(this.a);
    MMFormVerifyCodeInputView.h(this.a).setText(this.a.getContext().getString(2131886952, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(this.a)) }));
    if (MMFormVerifyCodeInputView.g(this.a) == 0)
    {
      MMFormVerifyCodeInputView.i(this.a).c();
      MMFormVerifyCodeInputView localMMFormVerifyCodeInputView = this.a;
      MMFormVerifyCodeInputView.a(localMMFormVerifyCodeInputView, MMFormVerifyCodeInputView.j(localMMFormVerifyCodeInputView));
      MMFormVerifyCodeInputView.k(this.a).setVisibility(0);
      MMFormVerifyCodeInputView.h(this.a).setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.widget.MMFormVerifyCodeInputView.3
 * JD-Core Version:    0.7.0.1
 */