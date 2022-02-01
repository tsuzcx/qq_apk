package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$29
  implements DialogInterface.OnClickListener
{
  NotificationActivity$29(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.access$1200(this.a, "0X800B654");
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", NotificationActivity.access$1000(this.a), "0X800AA30", "0X800AA30", 0, 0, "", "", "", NotificationActivity.access$300(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface != null) {
      paramDialogInterface = paramDialogInterface.getStringExtra("errorUrl");
    } else {
      paramDialogInterface = null;
    }
    Object localObject = paramDialogInterface;
    if (TextUtils.isEmpty(paramDialogInterface)) {
      localObject = "https://accounts.qq.com/007";
    }
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("loginFailed, before operate jump url is : ");
    paramDialogInterface.append((String)localObject);
    QLog.d("NotificationActivity", 1, paramDialogInterface.toString());
    localStringBuilder.append((String)localObject);
    if (!((String)localObject).contains("?")) {
      localStringBuilder.append("?");
    }
    if (!((String)localObject).endsWith("?")) {
      localStringBuilder.append("&");
    } else if (((String)localObject).indexOf("?") != ((String)localObject).lastIndexOf("?")) {
      localStringBuilder.append("&");
    }
    localStringBuilder.append("from=andapp");
    if (!NotificationActivity.access$1100(this.a))
    {
      localStringBuilder.append("&account=");
      localStringBuilder.append(NotificationActivity.access$1000(this.a));
    }
    paramDialogInterface = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loginFailed, after operate jump url is : ");
    ((StringBuilder)localObject).append(paramDialogInterface);
    QLog.d("NotificationActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    RouteUtils.a(this.a, ((Intent)localObject).putExtra("url", paramDialogInterface), "/base/browser");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.29
 * JD-Core Version:    0.7.0.1
 */