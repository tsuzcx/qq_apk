package com.tencent.mobileqq.ark.module;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkModuleAPIAuthority$1$3
  implements DialogInterface.OnClickListener
{
  ArkModuleAPIAuthority$1$3(ArkModuleAPIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.d != null) {
      this.b.d.a();
    }
    if (this.a.isShowing()) {}
    try
    {
      this.a.dismiss();
      label39:
      ArkModuleAPIAuthority.a(this.b.a, this.b.e, this.b.f, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1.3
 * JD-Core Version:    0.7.0.1
 */