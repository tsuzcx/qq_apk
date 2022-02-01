package com.tencent.mobileqq.ark.api.scheme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TelSchemeHandler$1$2
  implements DialogInterface.OnClickListener
{
  TelSchemeHandler$1$2(TelSchemeHandler.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {}
    try
    {
      this.a.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.1.2
 * JD-Core Version:    0.7.0.1
 */