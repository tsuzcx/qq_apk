package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class EditInfoActivity$22$2
  implements DialogInterface.OnClickListener
{
  EditInfoActivity$22$2(EditInfoActivity.22 param22) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onSetColorNick failed. save colorNick");
    }
    this.a.a.a.sendEmptyMessage(259);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.22.2
 * JD-Core Version:    0.7.0.1
 */