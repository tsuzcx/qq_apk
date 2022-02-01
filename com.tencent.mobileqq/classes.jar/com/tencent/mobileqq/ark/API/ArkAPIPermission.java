package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.Application;
import com.tencent.qphone.base.util.QLog;

public class ArkAPIPermission
{
  public static boolean a(String paramString1, long paramLong, ark.Application paramApplication, String paramString2)
  {
    boolean bool;
    if (paramLong == 0L) {
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("ArkApp.ArkAPIPermission", 1, String.format("ModuleCheckPermission.denied:Name:%s,Permission:%s.", new Object[] { paramString1, paramString2 }));
      }
      return bool;
      if ((paramApplication != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        bool = paramApplication.CheckPermissions(paramString2);
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAPIPermission
 * JD-Core Version:    0.7.0.1
 */