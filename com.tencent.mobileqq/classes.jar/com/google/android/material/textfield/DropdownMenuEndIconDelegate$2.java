package com.google.android.material.textfield;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class DropdownMenuEndIconDelegate$2
  implements View.OnFocusChangeListener
{
  DropdownMenuEndIconDelegate$2(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.a.a.setEndIconActivated(paramBoolean);
    if (!paramBoolean)
    {
      DropdownMenuEndIconDelegate.a(this.a, false);
      DropdownMenuEndIconDelegate.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
 * JD-Core Version:    0.7.0.1
 */