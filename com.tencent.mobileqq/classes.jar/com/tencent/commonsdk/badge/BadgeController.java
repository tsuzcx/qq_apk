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
  private static final String[] LAUNCHER_WHITE_LIST = { "com.tct.launcher", "com.bbk.studyos.launcher", "com.android.launcher3", "com.gionee.amisystem" };
  private static final String TAG = "BadgeUtils";
  private static Context sApplication;
  private static String sCurBadgeProviderAuthorities;
  private static String sCurLauncherPackageName;
  private static boolean sDebug = false;
  private static volatile Integer sNextCount;
  private static volatile boolean sResumed = true;
  
  private static String getCurLauncherPackageName()
  {
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
        if (!((ResolveInfo)localObject).activityInfo.packageName.equals("android"))
        {
          localObject = ((ResolveInfo)localObject).activityInfo.packageName;
          return localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void init(Context paramContext)
  {
    sApplication = paramContext.getApplicationContext();
    paramContext = getCurLauncherPackageName();
    int k = 0;
    String[] arrayOfString = LAUNCHER_WHITE_LIST;
    int m = arrayOfString.length;
    int i = 0;
    int j = k;
    if (i < m)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramContext)) {
        j = 1;
      }
    }
    else
    {
      if (sDebug) {
        break label106;
      }
      if (j == 0) {}
    }
    label106:
    for (sCurLauncherPackageName = paramContext;; sCurLauncherPackageName = paramContext)
    {
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
      i += 1;
      break;
    }
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
    if (!sResumed) {}
    boolean bool;
    for (sNextCount = Integer.valueOf(paramInt);; sNextCount = null)
    {
      bool = false;
      if (sCurBadgeProviderAuthorities != null) {
        break;
      }
      return false;
    }
    Object localObject = Uri.parse("content://" + sCurBadgeProviderAuthorities + "/badge");
    Bundle localBundle = new Bundle();
    localBundle.putInt("count", paramInt);
    localObject = sApplication.getContentResolver().call((Uri)localObject, "setBadge", "", localBundle);
    if (localObject != null) {
      bool = ((Bundle)localObject).getBoolean("result");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.badge.BadgeController
 * JD-Core Version:    0.7.0.1
 */