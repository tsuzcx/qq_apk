package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class PrivacyPolicyHelper$1
  implements DialogInterface.OnClickListener
{
  PrivacyPolicyHelper$1(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper.1
 * JD-Core Version:    0.7.0.1
 */