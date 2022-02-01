package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class SendMultiPictureHelper$3
  implements DialogInterface.OnClickListener
{
  SendMultiPictureHelper$3(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.l)
    {
      this.a.c.cancel();
      paramDialogInterface = this.a;
      paramDialogInterface.m = true;
      SendMultiPictureHelper.a(paramDialogInterface);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.3
 * JD-Core Version:    0.7.0.1
 */