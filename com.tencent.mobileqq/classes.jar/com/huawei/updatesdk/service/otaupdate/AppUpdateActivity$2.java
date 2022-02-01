package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class AppUpdateActivity$2
  implements DialogInterface.OnKeyListener
{
  AppUpdateActivity$2(AppUpdateActivity paramAppUpdateActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      AppUpdateActivity.b(this.a, 4);
      this.a.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.2
 * JD-Core Version:    0.7.0.1
 */