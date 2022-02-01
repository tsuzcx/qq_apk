package com.google.android.material.textfield;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DropdownMenuEndIconDelegate$6
  implements View.OnClickListener
{
  DropdownMenuEndIconDelegate$6(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void onClick(View paramView)
  {
    AutoCompleteTextView localAutoCompleteTextView = (AutoCompleteTextView)this.a.a.getEditText();
    DropdownMenuEndIconDelegate.a(this.a, localAutoCompleteTextView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
 * JD-Core Version:    0.7.0.1
 */