package com.tencent.mobileqq.activity.selectmember;

import anca;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class SelectMemberActivity$7
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$7(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((anca)this.this$0.app.getBusinessHandler(20)).a(this.this$0.mGroupCode, this.val$inviteMems, "");
    SelectMemberActivity.access$000(this.this$0);
    this.this$0.pd.show();
    this.this$0.reportInviteFriend("Clk_invite");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.7
 * JD-Core Version:    0.7.0.1
 */