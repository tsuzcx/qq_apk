package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class ArkAppYYBDownloadModule$7
  implements Runnable
{
  ArkAppYYBDownloadModule$7(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule, DownloadInfo paramDownloadInfo, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new ArkAppYYBDownloadModule.7.1(this);
    ArkAppYYBDownloadModule.7.2 local2 = new ArkAppYYBDownloadModule.7.2(this);
    QLog.i("ArkApp.downloadyyb.module", 1, "dialog create and show");
    localObject = new AlertDialog.Builder(this.b).setMessage(this.b.getString(2131888265)).setPositiveButton(2131888263, local2).setNegativeButton(2131888264, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.b.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.7
 * JD-Core Version:    0.7.0.1
 */