package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.widgets.InputDialog;

class ForwardFriendListActivity$3
  implements DialogInterface.OnClickListener
{
  ForwardFriendListActivity$3(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardFriendListActivity.a(this.a).dismiss();
    ForwardFriendListActivity.a(this.a, ForwardFriendListActivity.a(this.a).getEditText());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.3
 * JD-Core Version:    0.7.0.1
 */