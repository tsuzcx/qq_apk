package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendCheckFragment$4
  implements DialogInterface.OnClickListener
{
  AddFriendCheckFragment$4(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.a.getActivity().getIntent().getExtras());
      paramDialogInterface.putExtra("appid", AddFriendCheckFragment.d(this.a));
      paramDialogInterface.putExtra("openid", AddFriendCheckFragment.b());
      paramDialogInterface.putExtra("key_action", "key_sdk_add_friend");
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.c.cancel();
      RouteUtils.a(this.a.getActivity(), paramDialogInterface, "/base/login");
      this.a.getActivity().finish();
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface = this.a.getActivity();
      this.a.getActivity();
      paramDialogInterface.setResult(0);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.4
 * JD-Core Version:    0.7.0.1
 */