package com.tencent.mm.ui.widget.picker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class MMDatePicker$4
  implements DialogInterface.OnCancelListener
{
  MMDatePicker$4(MMDatePicker paramMMDatePicker) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    MMDatePicker.a(this.a, false, 0, 0, 0);
    this.a.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMDatePicker.4
 * JD-Core Version:    0.7.0.1
 */