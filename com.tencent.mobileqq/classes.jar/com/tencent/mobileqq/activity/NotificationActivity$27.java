package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.qqconnect.wtlogin.LoginHelper;

class NotificationActivity$27
  implements DialogInterface.OnClickListener
{
  NotificationActivity$27(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NotificationActivity.access$1300(this.a))
    {
      LoginHelper.a(this.a);
      NotificationActivity.access$1100(this.a, "0X800B655");
      return;
    }
    paramDialogInterface = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(paramDialogInterface.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.27
 * JD-Core Version:    0.7.0.1
 */