package com.tencent.mobileqq.activity.editservice;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class EditTroopMemberNickService$12$2
  implements DialogInterface.OnClickListener
{
  EditTroopMemberNickService$12$2(EditTroopMemberNickService.12 param12) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onSetColorNick failed. save colorNick");
    }
    this.a.a.L.sendEmptyMessage(259);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.12.2
 * JD-Core Version:    0.7.0.1
 */