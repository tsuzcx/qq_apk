package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class AddFriendLogicActivity$5
  implements DialogInterface.OnClickListener
{
  AddFriendLogicActivity$5(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "P_CliOper", "Safe_AntiFraud", this.a.app.getCurrentAccountUin(), "AlertDialog", "UserClick", 0, AddFriendLogicActivity.d(this.a), "", "", "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.5
 * JD-Core Version:    0.7.0.1
 */