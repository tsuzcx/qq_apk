package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class FriendProfilePicBrowserActivity$3
  implements DialogInterface.OnClickListener
{
  FriendProfilePicBrowserActivity$3(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismiss();
    paramDialogInterface = this.b.getIntent();
    paramDialogInterface.putExtra("delHead_fileid", FriendProfilePicBrowserActivity.h(this.b));
    this.b.setResult(-1, paramDialogInterface);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */