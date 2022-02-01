package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;

class FriendProfileCardActivity$11$1
  implements DialogInterface.OnClickListener
{
  FriendProfileCardActivity$11$1(FriendProfileCardActivity.11 param11) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.f();
    ReportController.b(this.a.a.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
    if (this.a.a.a.b) {
      new ReportTask(this.a.a.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.a.a.a.jdField_a_of_type_JavaLangString }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.11.1
 * JD-Core Version:    0.7.0.1
 */