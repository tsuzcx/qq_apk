package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class MMClearEditText$2
  implements View.OnFocusChangeListener
{
  MMClearEditText$2(MMClearEditText paramMMClearEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (MMClearEditText.b(this.a) != null) {
      MMClearEditText.b(this.a).onFocusChange(paramView, paramBoolean);
    }
    MMClearEditText.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.2
 * JD-Core Version:    0.7.0.1
 */