package com.tencent.mobileqq.activity.selectmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$6$1
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$6$1(SelectMemberActivity.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.d == 36) {
      if (this.a.a.a == 1) {
        this.a.a.m();
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      ReportController.b(null, "CliOper", "", "", "0X8004CEE", "0X8004CEE", 0, 0, "", "", "", "");
      return;
      this.a.a.a();
      continue;
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.6.1
 * JD-Core Version:    0.7.0.1
 */