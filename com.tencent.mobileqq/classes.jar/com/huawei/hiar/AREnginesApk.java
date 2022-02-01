package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;

public class AREnginesApk
{
  private static final String TAG = AREnginesApk.class.getSimpleName();
  
  public static AREnginesApk.ARAvailability checkAvailability(Context paramContext)
  {
    return AREnginesApk.ARAvailability.forNumber(HuaweiArApkBase.a().a(paramContext).nativeCode);
  }
  
  public static AREnginesApk.ARInstallStatus requestInstall(Activity paramActivity, boolean paramBoolean)
  {
    return AREnginesApk.ARInstallStatus.forNumber(HuaweiArApkBase.a().a(paramActivity, paramBoolean).nativeCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.AREnginesApk
 * JD-Core Version:    0.7.0.1
 */