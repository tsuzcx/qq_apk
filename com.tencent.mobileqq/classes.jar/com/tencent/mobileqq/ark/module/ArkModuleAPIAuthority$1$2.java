package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkModuleAPIAuthority$1$2
  implements DialogInterface.OnClickListener
{
  ArkModuleAPIAuthority$1$2(ArkModuleAPIAuthority.1 param1, QQCustomDialog paramQQCustomDialog, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.c.d != null) {
      this.c.d.b();
    }
    if (this.a.isShowing()) {}
    try
    {
      this.a.dismiss();
      ArkModuleAPIAuthority.a(this.c.a, this.c.e, this.c.f, 2);
      paramDialogInterface = this.b;
      paramDialogInterface = DialogUtil.a(paramDialogInterface, paramDialogInterface.getString(2131887033), 2131916601, 2131916601, new DialogUtil.DialogOnClickAdapter(), null);
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        try
        {
          paramDialogInterface.show();
          return;
        }
        catch (Exception paramDialogInterface) {}
        paramDialogInterface = paramDialogInterface;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1.2
 * JD-Core Version:    0.7.0.1
 */