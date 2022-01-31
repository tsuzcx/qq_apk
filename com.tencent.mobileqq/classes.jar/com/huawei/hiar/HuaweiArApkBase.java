package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;
import com.huawei.hiar.annotations.UsedByNative;

class HuaweiArApkBase
{
  @UsedByNative("HuaweiArapk.cc")
  static final int CURRENT_SDK_VERSIONCODE = 56;
  @UsedByNative("HuaweiArapk.cc")
  static final int REQUIRED_MIN_APK_VERSIONCODE = 49;
  
  public static HuaweiArApkBase a()
  {
    return j.b();
  }
  
  public HuaweiArApkBase.ARAvailability a(Context paramContext)
  {
    throw new UnsupportedOperationException("Stub");
  }
  
  public HuaweiArApkBase.ARInstallStatus a(Activity paramActivity, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Stub");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.HuaweiArApkBase
 * JD-Core Version:    0.7.0.1
 */