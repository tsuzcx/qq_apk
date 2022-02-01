package com.google.android.material.textfield;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class ClearTextEndIconDelegate$5
  implements View.OnClickListener
{
  ClearTextEndIconDelegate$5(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.a().getText();
    if (paramView != null) {
      paramView.clear();
    }
    this.a.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.5
 * JD-Core Version:    0.7.0.1
 */