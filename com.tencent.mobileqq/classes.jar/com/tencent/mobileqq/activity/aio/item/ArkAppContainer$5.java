package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppContainer$5
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
        ArkAppCenter.a("initCheckMetaDialog", String.format("PositiveButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.5
 * JD-Core Version:    0.7.0.1
 */