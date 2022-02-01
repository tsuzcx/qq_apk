package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class AddFriendCheckFragment$7
  implements DialogInterface.OnClickListener
{
  AddFriendCheckFragment$7(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendCheckFragment.b(this.a)) {
      return;
    }
    ReportController.b(AddFriendCheckFragment.f(this.a), "P_CliOper", "Safe_AntiFraud", AddFriendCheckFragment.f(this.a).getCurrentAccountUin(), "AlertDialog", "UserClick", 0, AddFriendCheckFragment.e(this.a), "", "", "", "");
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.7
 * JD-Core Version:    0.7.0.1
 */