package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AddFriendLogicActivity$4
  implements DialogInterface.OnClickListener
{
  AddFriendLogicActivity$4(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendLogicActivity.i(this.a) == 1)
    {
      this.a.finish();
      return;
    }
    AddFriendLogicActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.4
 * JD-Core Version:    0.7.0.1
 */