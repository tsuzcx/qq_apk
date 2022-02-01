package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class PhoneUnityBindInfoActivity$5
  implements DialogInterface.OnClickListener
{
  PhoneUnityBindInfoActivity$5(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      PhoneUnityBindInfoActivity.access$1500(this.a);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800BAEA", "0X800BAEA", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 0) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */