package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;

class DropdownMenuEndIconDelegate$7
  implements View.OnTouchListener
{
  DropdownMenuEndIconDelegate$7(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate, AutoCompleteTextView paramAutoCompleteTextView) {}
  
  public boolean onTouch(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (DropdownMenuEndIconDelegate.e(this.b)) {
        DropdownMenuEndIconDelegate.b(this.b, false);
      }
      DropdownMenuEndIconDelegate.a(this.b, this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
 * JD-Core Version:    0.7.0.1
 */