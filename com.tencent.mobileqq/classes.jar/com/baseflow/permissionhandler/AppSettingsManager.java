package com.baseflow.permissionhandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

final class AppSettingsManager
{
  void a(Context paramContext, AppSettingsManager.OpenAppSettingsSuccessCallback paramOpenAppSettingsSuccessCallback, ErrorCallback paramErrorCallback)
  {
    if (paramContext == null)
    {
      Log.d("permissions_handler", "Context cannot be null.");
      paramErrorCallback.a("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
      return;
    }
    try
    {
      paramErrorCallback = new Intent();
      paramErrorCallback.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramErrorCallback.addCategory("android.intent.category.DEFAULT");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("package:");
      localStringBuilder.append(paramContext.getPackageName());
      paramErrorCallback.setData(Uri.parse(localStringBuilder.toString()));
      paramErrorCallback.addFlags(268435456);
      paramErrorCallback.addFlags(1073741824);
      paramErrorCallback.addFlags(8388608);
      paramContext.startActivity(paramErrorCallback);
      paramOpenAppSettingsSuccessCallback.a(true);
      return;
    }
    catch (Exception paramContext)
    {
      label119:
      break label119;
    }
    paramOpenAppSettingsSuccessCallback.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.AppSettingsManager
 * JD-Core Version:    0.7.0.1
 */