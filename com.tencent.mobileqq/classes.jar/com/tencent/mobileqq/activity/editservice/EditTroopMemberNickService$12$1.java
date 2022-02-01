package com.tencent.mobileqq.activity.editservice;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class EditTroopMemberNickService$12$1
  implements DialogInterface.OnClickListener
{
  EditTroopMemberNickService$12$1(EditTroopMemberNickService.12 param12) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VasH5PayUtil.a(EditTroopMemberNickService.a(this.a.a), "mvip.g.a.qnc_gc", "CJCLUBT", -1, false, true);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.12.1
 * JD-Core Version:    0.7.0.1
 */