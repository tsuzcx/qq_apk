package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;

class AppUpdateActivity$c
  implements DialogInterface.OnShowListener
{
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("dialogstatus", 10002);
    d.a().b(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.c
 * JD-Core Version:    0.7.0.1
 */