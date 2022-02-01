package com.tencent.mobileqq.activity.pendant;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class AvatarPendantActivity$21
  implements DialogInterface.OnClickListener
{
  AvatarPendantActivity$21(AvatarPendantActivity paramAvatarPendantActivity, PendantTipsInfo paramPendantTipsInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantPendantTipsInfo, false, this.jdField_a_of_type_Int);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8005FD9", "0X8005FD9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.21
 * JD-Core Version:    0.7.0.1
 */