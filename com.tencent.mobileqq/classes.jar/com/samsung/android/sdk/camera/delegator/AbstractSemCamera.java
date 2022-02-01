package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.samsung.android.sep.camera.SemCamera;

public abstract class AbstractSemCamera
{
  public static final String SEM_FEATURE_SAMSUNG_EXPERIENCE_MOBILE = "com.samsung.feature.samsung_experience_mobile";
  
  public static String getSEPClientVersion()
  {
    return SemCamera.getInstance().getSEPClientVersion();
  }
  
  public static int getSepPlatformVersion(Context paramContext)
  {
    if ((isSemAvailable(paramContext)) && (Build.VERSION.SEM_PLATFORM_INT >= 80100)) {
      return Build.VERSION.SEM_PLATFORM_INT;
    }
    return -1;
  }
  
  private static final boolean isSemAvailable(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getPackageManager().hasSystemFeature("com.samsung.feature.samsung_experience_mobile")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public abstract int checkAvailability(Context paramContext);
  
  public abstract boolean isFeatureEnabled(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.AbstractSemCamera
 * JD-Core Version:    0.7.0.1
 */