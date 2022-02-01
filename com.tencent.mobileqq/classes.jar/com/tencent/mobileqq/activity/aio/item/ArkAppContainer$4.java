package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppContainer$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      try
      {
        this.a.dismiss();
        return;
      }
      catch (Exception paramDialogInterface)
      {
        ArkAppCenter.a("initCheckMetaDialog", String.format("NegativeButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.4
 * JD-Core Version:    0.7.0.1
 */