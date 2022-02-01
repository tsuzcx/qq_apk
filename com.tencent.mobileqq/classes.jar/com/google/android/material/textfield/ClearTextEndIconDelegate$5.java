package com.google.android.material.textfield;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ClearTextEndIconDelegate$5
  implements View.OnClickListener
{
  ClearTextEndIconDelegate$5(ClearTextEndIconDelegate paramClearTextEndIconDelegate) {}
  
  public void onClick(View paramView)
  {
    Editable localEditable = this.a.a.getEditText().getText();
    if (localEditable != null) {
      localEditable.clear();
    }
    this.a.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate.5
 * JD-Core Version:    0.7.0.1
 */