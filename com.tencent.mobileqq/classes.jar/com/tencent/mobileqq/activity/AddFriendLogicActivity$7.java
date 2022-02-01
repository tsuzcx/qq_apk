package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendLogicActivity$7
  implements DialogInterface.OnClickListener
{
  AddFriendLogicActivity$7(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.a.getIntent().getExtras());
      paramDialogInterface.putExtra("appid", AddFriendLogicActivity.m(this.a));
      paramDialogInterface.putExtra("openid", AddFriendLogicActivity.a);
      paramDialogInterface.putExtra("key_action", AddFriendLogicActivity.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.i.cancel();
      RouteUtils.a(this.a, paramDialogInterface, "/base/login");
      this.a.finish();
      return;
    }
    if (paramInt == 0)
    {
      this.a.setResult(0);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.7
 * JD-Core Version:    0.7.0.1
 */