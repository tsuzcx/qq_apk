package com.tencent.biz.qqcircle.utils;

import android.annotation.TargetApi;
import android.content.Context;

public class PermissionUtils
{
  @TargetApi(23)
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */