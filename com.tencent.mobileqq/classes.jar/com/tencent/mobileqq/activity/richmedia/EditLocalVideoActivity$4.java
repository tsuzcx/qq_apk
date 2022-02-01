package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class EditLocalVideoActivity$4
  implements DialogInterface.OnClickListener
{
  EditLocalVideoActivity$4(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (EditLocalVideoActivity.h(this.a)) {
      paramInt = -1;
    } else {
      paramInt = 0;
    }
    EditLocalVideoActivity.g(this.a).dismiss();
    EditLocalVideoActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.4
 * JD-Core Version:    0.7.0.1
 */