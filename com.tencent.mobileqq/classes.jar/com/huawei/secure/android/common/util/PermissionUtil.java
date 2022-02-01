package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

public class PermissionUtil
{
  private static final String TAG = "PermissionUtil";
  
  public static boolean checkCallingPermission(Context paramContext, String paramString1, String paramString2)
  {
    if (Binder.getCallingPid() == Process.myPid()) {
      return false;
    }
    return checkPermission(paramContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
  }
  
  public static boolean checkPermission(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      paramInt1 = PermissionChecker.checkPermission(paramContext, paramString1, paramInt1, paramInt2, paramString2);
      return paramInt1 == 0;
    }
    catch (Throwable paramContext)
    {
      paramString1 = TAG;
      paramString2 = new StringBuilder();
      paramString2.append("checkPermission: ");
      paramString2.append(paramContext.getMessage());
      paramString2.append(" , you should implementation support library or androidx library");
      Log.e(paramString1, paramString2.toString());
      throw new NoPermissionCheckerException("you should implementation support library or androidx library");
    }
  }
  
  public static boolean checkSelfPermission(Context paramContext, String paramString)
  {
    return checkPermission(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.PermissionUtil
 * JD-Core Version:    0.7.0.1
 */