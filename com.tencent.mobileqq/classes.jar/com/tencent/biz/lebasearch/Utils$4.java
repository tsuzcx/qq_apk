package com.tencent.biz.lebasearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

final class Utils$4
  implements DialogInterface.OnClickListener
{
  Utils$4(Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils.4
 * JD-Core Version:    0.7.0.1
 */