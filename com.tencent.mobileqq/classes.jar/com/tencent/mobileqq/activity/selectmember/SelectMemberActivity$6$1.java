package com.tencent.mobileqq.activity.selectmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bdla;

class SelectMemberActivity$6$1
  implements DialogInterface.OnClickListener
{
  SelectMemberActivity$6$1(SelectMemberActivity.6 param6) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$1.this$0.mEntrance == 36) {
      if (this.this$1.this$0.mType == 1) {
        this.this$1.this$0.createNewTypeDiscussion();
      }
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      bdla.b(null, "CliOper", "", "", "0X8004CEE", "0X8004CEE", 0, 0, "", "", "", "");
      return;
      this.this$1.this$0.startCreateOrAdd();
      continue;
      this.this$1.this$0.startCreateOrAdd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.6.1
 * JD-Core Version:    0.7.0.1
 */