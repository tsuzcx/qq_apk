package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class AddFriendVerifyActivity$26
  implements DialogInterface.OnClickListener
{
  AddFriendVerifyActivity$26(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VasH5PayUtil.a(this.c, "mvip.n.a.gnew_apply", this.a, 3, false, false, "", "", true, true);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4FB", this.b, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.26
 * JD-Core Version:    0.7.0.1
 */