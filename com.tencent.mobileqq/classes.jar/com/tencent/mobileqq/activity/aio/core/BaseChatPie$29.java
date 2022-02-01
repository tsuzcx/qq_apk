package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BaseChatPie$29
  implements DialogInterface.OnClickListener
{
  BaseChatPie$29(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.be != null) && (this.a.be.isShowing())) {
      this.a.be.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.29
 * JD-Core Version:    0.7.0.1
 */