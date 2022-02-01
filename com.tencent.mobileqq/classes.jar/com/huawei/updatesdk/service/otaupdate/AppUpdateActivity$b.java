package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;

class AppUpdateActivity$b
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("dialogstatus", 10001);
    d.a().b(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.b
 * JD-Core Version:    0.7.0.1
 */