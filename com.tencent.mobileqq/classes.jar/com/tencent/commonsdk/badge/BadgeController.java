package com.tencent.commonsdk.badge;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

public final class BadgeController
{
  private static final String[] LAUNCHER_WHITE_LIST = { "com.tct.launcher", "com.bbk.studyos.launcher", "com.android.launcher3", "com.gionee.amisystem", "com.oppo.launcher", "com.ape.launcher3" };
  private static final String TAG = "BadgeUtils";
  private static Context sApplication;
  private static String sCurBadgeProviderAuthorities;
  private static String sCurLauncherPackageName;
  private static boolean sDebug = false;
  private static volatile Integer sNextCount;
  private static volatile boolean sResumed = true;
  
  private static String getCurLauncherPackageName()
  {
    String str = null;
    try
    {
      Object localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.HOME");
      localObject = sApplication.getPackageManager().resolveActivity((Intent)localObject, 0);
      if (localObject != null)
      {
        if (((ResolveInfo)localObject).activityInfo == null) {
          return null;
        }
        if (((ResolveInfo)localObject).activityInfo.packageName.equals("android")) {
          return null;
        }
        str = ((ResolveInfo)localObject).activityInfo.packageName;
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void init(Context paramContext)
  {
    sApplication = paramContext.getApplicationContext();
    paramContext = getCurLauncherPackageName();
    String[] arrayOfString = LAUNCHER_WHITE_LIST;
    int m = arrayOfString.length;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (arrayOfString[i].equalsIgnoreCase(paramContext))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (!sDebug)
    {
      if (j != 0) {
        sCurLauncherPackageName = paramContext;
      }
    }
    else {
      sCurLauncherPackageName = paramContext;
    }
    if (sCurLauncherPackageName != null) {}
    try
    {
      paramContext = sApplication.getPackageManager().getApplicationInfo(sCurLauncherPackageName, 128);
      if (paramContext != null) {
        sCurBadgeProviderAuthorities = paramContext.metaData.getString("badge_provider");
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean isSupport(Context paramContext)
  {
    if (sCurLauncherPackageName == null) {
      init(paramContext);
    }
    return sCurBadgeProviderAuthorities != null;
  }
  
  public static void resumeOrPause(boolean paramBoolean)
  {
    sResumed = paramBoolean;
    Integer localInteger = sNextCount;
    if ((sResumed) && (localInteger != null)) {
      setBadge(localInteger.intValue());
    }
  }
  
  public static boolean setBadge(int paramInt)
  {
    if (!sResumed) {
      sNextCount = Integer.valueOf(paramInt);
    } else {
      sNextCount = null;
    }
    boolean bool = false;
    if (sCurBadgeProviderAuthorities == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("content://");
    ((StringBuilder)localObject).append(sCurBadgeProviderAuthorities);
    ((StringBuilder)localObject).append("/badge");
    localObject = Uri.parse(((StringBuilder)localObject).toString());
    Bundle localBundle = new Bundle();
    localBundle.putInt("count", paramInt);
    localObject = sApplication.getContentResolver().call((Uri)localObject, "setBadge", "", localBundle);
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("result");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.badge.BadgeController
 * JD-Core Version:    0.7.0.1
 */