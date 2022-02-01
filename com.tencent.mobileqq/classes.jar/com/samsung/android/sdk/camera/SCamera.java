package com.samsung.android.sdk.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Log;
import com.samsung.android.sdk.camera.delegator.AbstractSemCamera;
import com.samsung.android.sdk.camera.delegator.SemCamera10_1;
import com.samsung.android.sdk.camera.delegator.SemCamera10_2;
import com.samsung.android.sdk.camera.delegator.SemCameraDefault;
import com.samsung.android.sdk.camera.util.SsdkVendorCheck;
import com.samsung.android.sdk.camera.util.SsdkVersionCheck;

public class SCamera
{
  public static final int AVAILABILITY_SUPPORTED = 0;
  public static final int AVAILABILITY_UNSUPPORTED_DEVICE = 2;
  public static final int AVAILABILITY_UNSUPPORTED_VENDOR = 1;
  private static final String CAMERA_ID_FRONT = "1";
  private static final String CAMERA_ID_REAR = "0";
  private static final String CAMERA_ID_REAR_WIDE = "2";
  public static final int FEATURE_CAPTURE_PROCESSOR = 1;
  private static final String MICRO_VERSION_NAME = "2";
  private static final String SCAMERA_SERVICE_PACKAGE = "com.samsung.android.camerasdkservice";
  static final String SEP_CLIENT_VERSION_1 = "2.0.0";
  static final String SEP_CLIENT_VERSION_2 = "2.0.1";
  static final String SEP_CLIENT_VERSION_3 = "2.0.2";
  static final int SEP_VERSION_10_1 = 100100;
  static final int SEP_VERSION_10_2 = 100200;
  private static final String TAG = SCamera.class.getSimpleName();
  private static final int VERSION_CODE = 101;
  private static final String VERSION_NAME = "2.0.1";
  private static SCamera mSCamera;
  private Context mContext;
  private AbstractSemCamera mSemCamera = null;
  
  private SCamera()
  {
    Log.i(TAG, "SCamera SDK version: 2.0.1 mver: 2");
  }
  
  public static SCamera getInstance()
  {
    try
    {
      if (mSCamera == null) {
        mSCamera = new SCamera();
      }
      SCamera localSCamera = mSCamera;
      return localSCamera;
    }
    finally {}
  }
  
  private AbstractSemCamera getSemCamera()
  {
    for (;;)
    {
      try
      {
        if (this.mSemCamera == null)
        {
          int i = AbstractSemCamera.getSepPlatformVersion(this.mContext);
          if (i < 100100) {}
        }
        else
        {
          try
          {
            Object localObject1 = AbstractSemCamera.getSEPClientVersion();
            Log.i(TAG, "getSemCamera semVersion : " + (String)localObject1);
            if (SsdkVersionCheck.compareVersion((String)localObject1, "2.0.1") >= 0) {
              this.mSemCamera = new SemCamera10_2();
            }
            Log.i(TAG, "getSemCamera : " + this.mSemCamera);
            localObject1 = this.mSemCamera;
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            Log.i(TAG, "getSemCamera semVersion : SEP_VERSION_10_1 in caught Error:");
            this.mSemCamera = new SemCamera10_1();
            continue;
          }
        }
        this.mSemCamera = new SemCameraDefault();
      }
      finally {}
    }
  }
  
  private static boolean isNonCompatibleBinary()
  {
    boolean bool2 = false;
    String str1 = Build.MANUFACTURER;
    String str2 = Build.DEVICE;
    String str3 = Build.DISPLAY;
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      boolean bool1 = bool2;
      if (str1.toLowerCase().contains("samsung"))
      {
        bool1 = bool2;
        if (str2.toLowerCase().contains("beyond")) {
          if (!str3.toUpperCase().endsWith("SAT"))
          {
            bool1 = bool2;
            if (!str3.toUpperCase().endsWith("SAU")) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    return true;
  }
  
  private boolean isSDKServiceOnDevice(Context paramContext)
  {
    try
    {
      if (paramContext.getPackageManager().getPackageInfo("com.samsung.android.camerasdkservice", 0) == null)
      {
        Log.d(TAG, "isSDKServiceOnDevice - " + false);
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.d(TAG, "isSDKServiceOnDevice - " + false);
      return false;
    }
    catch (NullPointerException paramContext)
    {
      throw new IllegalArgumentException("Context is invalid");
    }
    return true;
  }
  
  private boolean isSEPSupported(Context paramContext)
  {
    int i = AbstractSemCamera.getSepPlatformVersion(paramContext);
    Log.i(TAG, " getSeCamera SEP VERSION: " + i);
    return i >= 100100;
  }
  
  public int checkAvailability(Context paramContext)
  {
    int j = 2;
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    int i;
    if (!SsdkVendorCheck.isSamsungDevice()) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (!isSDKServiceOnDevice(paramContext));
      i = j;
    } while (!isSEPSupported(paramContext));
    if (isNonCompatibleBinary())
    {
      Log.d(TAG, "checkAvailability: isNonCompatibleBinary - true");
      return 2;
    }
    return 0;
  }
  
  public int getVersionCode()
  {
    return 101;
  }
  
  public String getVersionName()
  {
    return "2.0.1";
  }
  
  public boolean isFeatureEnabled(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context cannot be null");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("cameraId cannot be null");
    }
    this.mContext = paramContext;
    try
    {
      getSemCamera();
      if ((SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), "2.0.1") != 1) && (!paramString.equals("0")) && (!paramString.equals("1"))) {
        return false;
      }
      getSemCamera();
      if (SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), "2.0.2") == 0)
      {
        boolean bool = paramString.equals("2");
        if (bool) {
          break label138;
        }
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      while ((paramString.equals("0")) || (paramString.equals("1"))) {}
    }
    if (checkAvailability(paramContext) == 0) {
      return getSemCamera().isFeatureEnabled(paramContext, paramString, paramInt);
    }
    label138:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCamera
 * JD-Core Version:    0.7.0.1
 */