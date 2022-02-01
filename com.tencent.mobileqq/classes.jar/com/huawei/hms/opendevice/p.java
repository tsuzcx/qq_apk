package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx.VERSION;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;

public class p
{
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.createDeviceProtectedStorageContext().getDataDir());
      localStringBuilder.append("");
      paramContext = localStringBuilder.toString();
    }
    else
    {
      paramContext = paramContext.getFilesDir().getParent();
    }
    if (TextUtils.isEmpty(paramContext)) {
      HMSLog.e("CommFun", "get storage root path of the current user failed.");
    }
    return paramContext;
  }
  
  public static boolean a()
  {
    int i = HwBuildEx.VERSION.EMUI_SDK_INT;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Emui Api Level:");
    localStringBuilder.append(i);
    HMSLog.d("CommFun", localStringBuilder.toString());
    return i > 0;
  }
  
  public static long b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      int i = paramContext.getPackageInfo("com.huawei.android.pushagent", 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      label19:
      break label19;
    }
    HMSLog.e("CommFun", "get nc versionCode error");
    return -1L;
  }
  
  public static boolean c(Context paramContext)
  {
    return (a()) && (HwBuildEx.VERSION.EMUI_SDK_INT < 21) && (b(paramContext) < 110001400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.p
 * JD-Core Version:    0.7.0.1
 */