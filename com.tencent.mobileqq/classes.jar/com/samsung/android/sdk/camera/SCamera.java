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
  private static final String TAG = "SCamera";
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
    StringBuilder localStringBuilder;
    label88:
    try
    {
      if (this.mSemCamera == null)
      {
        int i = AbstractSemCamera.getSepPlatformVersion(this.mContext);
        if (i < 100100) {}
      }
    }
    finally {}
    try
    {
      localObject1 = AbstractSemCamera.getSEPClientVersion();
      localObject3 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSemCamera semVersion : ");
      localStringBuilder.append((String)localObject1);
      Log.i((String)localObject3, localStringBuilder.toString());
      if (SsdkVersionCheck.compareVersion((String)localObject1, "2.0.1") < 0) {
        break label122;
      }
      this.mSemCamera = new SemCamera10_2();
    }
    catch (Throwable localThrowable)
    {
      break label88;
    }
    Log.i(TAG, "getSemCamera semVersion : SEP_VERSION_10_1 in caught Error:");
    this.mSemCamera = new SemCamera10_1();
    break label122;
    this.mSemCamera = new SemCameraDefault();
    label122:
    Object localObject1 = TAG;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("getSemCamera : ");
    ((StringBuilder)localObject3).append(this.mSemCamera);
    Log.i((String)localObject1, ((StringBuilder)localObject3).toString());
    localObject1 = this.mSemCamera;
    return localObject1;
  }
  
  private static boolean isNonCompatibleBinary()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.DEVICE;
    String str3 = Build.DISPLAY;
    boolean bool = true;
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      if ((str1.toLowerCase().contains("samsung")) && (str2.toLowerCase().contains("beyond")))
      {
        if (!str3.toUpperCase().endsWith("SAT"))
        {
          if (str3.toUpperCase().endsWith("SAU")) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return false;
    }
    return true;
  }
  
  private boolean isSDKServiceOnDevice(Context paramContext)
  {
    try
    {
      if (paramContext.getPackageManager().getPackageInfo("com.samsung.android.camerasdkservice", 0) == null)
      {
        paramContext = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSDKServiceOnDevice - ");
        localStringBuilder.append(false);
        Log.d(paramContext, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      StringBuilder localStringBuilder;
      break label61;
    }
    catch (NullPointerException paramContext)
    {
      label51:
      label61:
      break label51;
    }
    throw new IllegalArgumentException("Context is invalid");
    paramContext = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSDKServiceOnDevice - ");
    localStringBuilder.append(false);
    Log.d(paramContext, localStringBuilder.toString());
    return false;
  }
  
  private boolean isSEPSupported(Context paramContext)
  {
    int i = AbstractSemCamera.getSepPlatformVersion(paramContext);
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getSeCamera SEP VERSION: ");
    localStringBuilder.append(i);
    Log.i(paramContext, localStringBuilder.toString());
    return i >= 100100;
  }
  
  public int checkAvailability(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!SsdkVendorCheck.isSamsungDevice()) {
        return 1;
      }
      if (isSDKServiceOnDevice(paramContext))
      {
        if (!isSEPSupported(paramContext)) {
          return 2;
        }
        if (isNonCompatibleBinary())
        {
          Log.d(TAG, "checkAvailability: isNonCompatibleBinary - true");
          return 2;
        }
        return 0;
      }
      return 2;
    }
    throw new IllegalArgumentException("context cannot be null");
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
    if (paramContext != null) {
      if (paramString != null) {
        this.mContext = paramContext;
      }
    }
    try
    {
      getSemCamera();
      if ((SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), "2.0.1") != 1) && (!paramString.equals("0")) && (!paramString.equals("1"))) {
        return false;
      }
      getSemCamera();
      if (SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), "2.0.2") != 0) {
        break label101;
      }
      boolean bool = paramString.equals("2");
      if (!bool) {
        break label101;
      }
      return false;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label81:
      break label81;
    }
    if ((!paramString.equals("0")) && (!paramString.equals("1"))) {
      return false;
    }
    label101:
    if (checkAvailability(paramContext) != 0) {
      return false;
    }
    return getSemCamera().isFeatureEnabled(paramContext, paramString, paramInt);
    throw new IllegalArgumentException("cameraId cannot be null");
    throw new IllegalArgumentException("context cannot be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCamera
 * JD-Core Version:    0.7.0.1
 */