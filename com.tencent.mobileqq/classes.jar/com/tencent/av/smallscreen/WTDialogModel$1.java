package com.tencent.av.smallscreen;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.app.BaseActivity;

class WTDialogModel$1
  implements DialogInterface.OnClickListener
{
  WTDialogModel$1(WTDialogModel paramWTDialogModel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WTDialogModel.a(this.a, null);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.WTDialogModel.1
 * JD-Core Version:    0.7.0.1
 */