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
    paramDialogInterface = this.a;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    AddRequestActivity.b(paramDialogInterface, bool);
    ReportController.b(this.a.app, "dc00898", "", "", "0X800B084", "0X800B084", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.15
 * JD-Core Version:    0.7.0.1
 */