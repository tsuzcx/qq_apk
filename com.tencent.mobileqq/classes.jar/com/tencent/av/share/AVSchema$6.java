package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AVSchema$6
  implements DialogInterface.OnDismissListener
{
  AVSchema$6(AVSchema paramAVSchema) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.6
 * JD-Core Version:    0.7.0.1
 */