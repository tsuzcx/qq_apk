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
    if (AddRequestActivity.c(this.a, AddRequestActivity.e(this.a)))
    {
      AddRequestActivity.b(this.a, 2131719050, 1000L, false);
      AddRequestActivity.a(this.a, AddRequestActivity.e(this.a));
    }
    AddRequestActivity.a(this.a).dismiss();
    AddRequestActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.16
 * JD-Core Version:    0.7.0.1
 */