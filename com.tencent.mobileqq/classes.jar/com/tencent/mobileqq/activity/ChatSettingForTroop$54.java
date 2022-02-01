package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ChatSettingForTroop$54
  implements DialogInterface.OnClickListener
{
  ChatSettingForTroop$54(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.a.getIntent().getExtras());
      paramDialogInterface.putExtra("key_action", ChatSettingForTroop.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.a.cancel();
      RouteUtils.a(this.a, paramDialogInterface, "/base/login");
      this.a.finish();
    }
    while (paramInt != 0) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.54
 * JD-Core Version:    0.7.0.1
 */