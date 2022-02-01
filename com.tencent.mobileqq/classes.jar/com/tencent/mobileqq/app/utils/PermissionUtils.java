package com.tencent.mobileqq.app.utils;

import android.annotation.TargetApi;
import android.content.Context;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class PermissionUtils
{
  @TargetApi(23)
  public static boolean isStorePermissionEnable(Context paramContext)
  {
    return (paramContext != null) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  @TargetApi(23)
  public static void requestStorePermission(AppActivity paramAppActivity, int paramInt, QQPermissionCallback paramQQPermissionCallback)
  {
    if (paramAppActivity != null) {
      paramAppActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */