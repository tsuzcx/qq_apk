package com.tencent.mobileqq.activity.selectmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

class SelectMemberActivity$17
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$17(SelectMemberActivity paramSelectMemberActivity, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.doInviteTroopMember(this.val$outGroupMemberList);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.17
 * JD-Core Version:    0.7.0.1
 */