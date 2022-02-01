package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$29
  implements DialogInterface.OnClickListener
{
  NotificationActivity$29(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.access$1100(this.a, "0X800B654");
    ReportController.a(this.a.app, "dc00898", "", NotificationActivity.access$900(this.a), "0X800AA30", "0X800AA30", 0, 0, "", "", "", NotificationActivity.access$200(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.a.getIntent();
    paramDialogInterface = null;
    if (localObject != null) {
      paramDialogInterface = ((Intent)localObject).getStringExtra("errorUrl");
    }
    localObject = paramDialogInterface;
    if (TextUtils.isEmpty(paramDialogInterface)) {
      localObject = "https://accounts.qq.com/007";
    }
    QLog.d("NotificationActivity", 1, "loginFailed, before operate jump url is : " + (String)localObject);
    localStringBuilder.append((String)localObject);
    if (!((String)localObject).contains("?")) {
      localStringBuilder.append("?");
    }
    if (!((String)localObject).endsWith("?")) {
      localStringBuilder.append("&");
    }
    for (;;)
    {
      localStringBuilder.append("from=andapp");
      if (!NotificationActivity.access$1000(this.a)) {
        localStringBuilder.append("&account=").append(NotificationActivity.access$900(this.a));
      }
      paramDialogInterface = localStringBuilder.toString();
      QLog.d("NotificationActivity", 1, "loginFailed, after operate jump url is : " + paramDialogInterface);
      localObject = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      this.a.startActivity(((Intent)localObject).putExtra("url", paramDialogInterface));
      this.a.finish();
      return;
      if (((String)localObject).indexOf("?") != ((String)localObject).lastIndexOf("?")) {
        localStringBuilder.append("&");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.29
 * JD-Core Version:    0.7.0.1
 */