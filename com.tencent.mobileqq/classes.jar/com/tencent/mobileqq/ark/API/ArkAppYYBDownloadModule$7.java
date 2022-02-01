package com.tencent.mobileqq.ark.API;

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
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131691388)).setPositiveButton(2131691386, local2).setNegativeButton(2131691387, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.7
 * JD-Core Version:    0.7.0.1
 */