package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class AddRequestActivity$15
  implements DialogInterface.OnClickListener
{
  AddRequestActivity$15(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    paramDialogInterface = this.a;
    if (paramInt == 1) {}
    for (;;)
    {
      AddRequestActivity.b(paramDialogInterface, bool);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800B084", "0X800B084", 0, 0, "", "", "", "");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.15
 * JD-Core Version:    0.7.0.1
 */