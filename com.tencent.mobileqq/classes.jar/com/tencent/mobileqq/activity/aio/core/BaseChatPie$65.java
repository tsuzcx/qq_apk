package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseChatPie$65
  implements DialogInterface.OnClickListener
{
  BaseChatPie$65(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.b != null) && (this.a.b.isShowing())) {
      this.a.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.65
 * JD-Core Version:    0.7.0.1
 */