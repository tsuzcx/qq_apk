package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseChatPie$80
  implements DialogInterface.OnClickListener
{
  BaseChatPie$80(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.addFriendDialog != null) && (this.this$0.addFriendDialog.isShowing())) {
      this.this$0.addFriendDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.80
 * JD-Core Version:    0.7.0.1
 */