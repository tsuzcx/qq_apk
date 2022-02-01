package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class LoginFailedHelper$4
  implements DialogInterface.OnClickListener
{
  LoginFailedHelper$4(Context paramContext, String paramString, AppRuntime paramAppRuntime) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("LoginFailedHelper", 1, "handleAccountFrozen: goto LoginView.");
    paramDialogInterface = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/base/login");
    Bundle localBundle = paramDialogInterface.extra();
    localBundle.putBoolean("is_change_account", true);
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("befault_uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localBundle.putBoolean("is_show_not_login_uin", true);
    QRoute.startUri(paramDialogInterface, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginFailedHelper.4
 * JD-Core Version:    0.7.0.1
 */