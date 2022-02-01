package com.google.android.material.textfield;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class ClearTextEndIconDelegate$2
  implements View.OnFocusChangeListener
{
  ClearTextEndIconDelegate$2(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool2 = TextUtils.isEmpty(((EditText)paramView).getText());
    boolean bool1 = true;
    paramView = this.a;
    if (((bool2 ^ true)) && (paramBoolean)) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    }
    ClearTextEndIconDelegate.a(paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.2
 * JD-Core Version:    0.7.0.1
 */