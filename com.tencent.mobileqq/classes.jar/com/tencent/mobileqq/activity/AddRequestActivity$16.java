package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddRequestActivity$16
  implements DialogInterface.OnClickListener
{
  AddRequestActivity$16(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (AddRequestActivity.c(paramDialogInterface, AddRequestActivity.e(paramDialogInterface)))
    {
      AddRequestActivity.b(this.a, 2131718766, 1000L, false);
      paramDialogInterface = this.a;
      AddRequestActivity.a(paramDialogInterface, AddRequestActivity.e(paramDialogInterface));
    }
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.16
 * JD-Core Version:    0.7.0.1
 */