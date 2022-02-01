package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.widgets.InputDialog;

class ForwardFriendListActivity$2
  implements DialogInterface.OnClickListener
{
  ForwardFriendListActivity$2(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ForwardFriendListActivity.a(this.a).getInputValue();
    if (!TextUtils.isEmpty(paramDialogInterface))
    {
      ForwardFriendListActivity.a(this.a, ForwardFriendListActivity.a(this.a).getEditText());
      Intent localIntent = new Intent();
      localIntent.putExtras(this.a.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_name", paramDialogInterface);
      this.a.setResult(-1, localIntent);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.2
 * JD-Core Version:    0.7.0.1
 */