package com.tencent.av.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GVideoUpdateUtil$3
  implements DialogInterface.OnClickListener
{
  GVideoUpdateUtil$3(GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener, Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoUpdateUtil.3
 * JD-Core Version:    0.7.0.1
 */