package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;

final class Utils$1
  implements DialogInterface.OnClickListener
{
  Utils$1(int paramInt, BusinessObserver paramBusinessObserver, Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (this.a == 1)
      {
        this.b.onUpdate(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.sendPluginSetMessage(this.c, this.d, this.b, this.e, false);
      return;
    }
    if (this.a == 1)
    {
      Utils.sendPluginSetMessage(this.c, this.d, this.b, this.e, true);
      return;
    }
    this.b.onUpdate(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils.1
 * JD-Core Version:    0.7.0.1
 */