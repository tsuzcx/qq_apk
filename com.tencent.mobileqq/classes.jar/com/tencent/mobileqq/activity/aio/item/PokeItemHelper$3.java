package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class PokeItemHelper$3
  implements DialogInterface.OnClickListener
{
  PokeItemHelper$3(QQAppInterface paramQQAppInterface, int paramInt1, Activity paramActivity, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (true == PokeItemHelper.l) {
      PokeItemHelper.l = false;
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.a == null)
    {
      QLog.d("vaspoke", 4, "dialogInterfaceOnClick mApp is null.");
      return;
    }
    int i = this.b;
    if (((2 == i) || (4 == i)) && (paramInt == 1))
    {
      if (2 == this.b)
      {
        paramDialogInterface = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mvip.g.a.poke_");
        localStringBuilder.append(this.d);
        VasH5PayUtil.a(paramDialogInterface, localStringBuilder.toString(), 3, "1450000515", "LTMCLUB", this.a.getApp().getString(2131892806), "");
        VasWebviewUtil.a("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.d), "vip", "", "", "", "", 0, 0, 0, 0);
        return;
      }
      paramDialogInterface = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mvip.g.a.poke_");
      localStringBuilder.append(this.d);
      VasH5PayUtil.a(paramDialogInterface, localStringBuilder.toString(), 3, "1450000516", "CJCLUBT", this.a.getApp().getString(2131916948), "");
      VasWebviewUtil.a("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(this.d), "svip", "", "", "", "", 0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.3
 * JD-Core Version:    0.7.0.1
 */