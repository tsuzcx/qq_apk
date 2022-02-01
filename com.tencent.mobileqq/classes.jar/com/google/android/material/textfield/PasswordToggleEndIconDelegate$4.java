package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PasswordToggleEndIconDelegate$4
  implements View.OnClickListener
{
  PasswordToggleEndIconDelegate$4(PasswordToggleEndIconDelegate paramPasswordToggleEndIconDelegate) {}
  
  public void onClick(View paramView)
  {
    EditText localEditText = this.a.a.getEditText();
    if (localEditText != null)
    {
      int i = localEditText.getSelectionEnd();
      if (PasswordToggleEndIconDelegate.a(this.a)) {
        localEditText.setTransformationMethod(null);
      } else {
        localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      if (i >= 0) {
        localEditText.setSelection(i);
      }
      this.a.a.h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
 * JD-Core Version:    0.7.0.1
 */