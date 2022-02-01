package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

class DialogActivity$5
  implements DialogInterface.OnClickListener
{
  DialogActivity$5(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("qqBaseActivity", 1, "checkBackgroundRestricWhilteList conform to setting.");
    paramDialogInterface.dismiss();
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("package:");
    paramDialogInterface.append(this.a.getPackageName());
    paramDialogInterface = new Intent("android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS", Uri.parse(paramDialogInterface.toString()));
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity.5
 * JD-Core Version:    0.7.0.1
 */