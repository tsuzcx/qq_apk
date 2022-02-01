package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import org.json.JSONObject;

class NotificationActivity$8
  implements DialogInterface.OnClickListener
{
  NotificationActivity$8(NotificationActivity paramNotificationActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("appid", "100686848");
      paramDialogInterface.put("apkId", "6633");
      paramDialogInterface.put("versionCode", String.valueOf(this.b.getPackageManager().getPackageInfo(this.a, 16384).versionCode));
      paramDialogInterface.put("via", "ANDROIDQQ.NEICE.OTHER");
      paramDialogInterface.put("appPackageName", this.a);
      paramDialogInterface.put("channel", "000316053134377c30");
      paramDialogInterface.put("appAuthorizedStr", NotificationActivity.access$300(this.b));
      paramDialogInterface = paramDialogInterface.toString();
      NotificationActivity.access$100().a(this.b, paramDialogInterface);
      NotificationActivity.access$402(this.b, true);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.8
 * JD-Core Version:    0.7.0.1
 */