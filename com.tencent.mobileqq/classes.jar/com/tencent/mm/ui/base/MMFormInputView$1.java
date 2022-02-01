package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMFormInputView$1
  implements View.OnFocusChangeListener
{
  MMFormInputView$1(MMFormInputView paramMMFormInputView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == MMFormInputView.a(this.a))
    {
      MMFormInputView.b(this.a);
      if (paramBoolean) {
        this.a.setBackgroundResource(2130841265);
      } else {
        this.a.setBackgroundResource(2130841266);
      }
      MMFormInputView.c(this.a);
    }
    if (MMFormInputView.d(this.a) != null) {
      MMFormInputView.d(this.a).onFocusChange(paramView, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView.1
 * JD-Core Version:    0.7.0.1
 */