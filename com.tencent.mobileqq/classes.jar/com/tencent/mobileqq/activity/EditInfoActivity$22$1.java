package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class EditInfoActivity$22$1
  implements DialogInterface.OnClickListener
{
  EditInfoActivity$22$1(EditInfoActivity.22 param22) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VasH5PayUtil.a(this.a.a, "mvip.g.a.qnc_gc", "CJCLUBT", -1, false, true);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.22.1
 * JD-Core Version:    0.7.0.1
 */