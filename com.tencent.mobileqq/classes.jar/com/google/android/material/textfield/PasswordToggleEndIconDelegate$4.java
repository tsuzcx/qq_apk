package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class PasswordToggleEndIconDelegate$4
  implements View.OnClickListener
{
  PasswordToggleEndIconDelegate$4(PasswordToggleEndIconDelegate paramPasswordToggleEndIconDelegate) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a();
    if (paramView == null) {
      return;
    }
    int i = paramView.getSelectionEnd();
    if (PasswordToggleEndIconDelegate.a(this.a)) {
      paramView.setTransformationMethod(null);
    } else {
      paramView.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    if (i >= 0) {
      paramView.setSelection(i);
    }
    this.a.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
 * JD-Core Version:    0.7.0.1
 */