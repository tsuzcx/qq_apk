package com.tencent.avcore.jni.data;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVSoProxy;

public class SDKConfigInfo
{
  private static final String TAG = "SDKConfigInfo";
  private final boolean isDebugVersion;
  private final boolean isGrayVersion;
  private final boolean isPublicVersion;
  private final String logDir;
  private final String logFilePrefix;
  private final String processName;
  private final int terminalType = 4;
  
  public SDKConfigInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.logDir = paramString1;
    this.logFilePrefix = paramString2;
    this.processName = paramString3;
    this.isDebugVersion = paramBoolean1;
    this.isGrayVersion = paramBoolean2;
    this.isPublicVersion = paramBoolean3;
  }
  
  @TargetApi(9)
  public static String getDeviceInfo(AVSoProxy paramAVSoProxy)
  {
    Object localObject = "PRODUCT=" + Build.PRODUCT + ";";
    localObject = (String)localObject + "CPU_ABI=" + Build.CPU_ABI + ";";
    localObject = (String)localObject + "TAGS=" + Build.TAGS + ";";
    localObject = (String)localObject + "VERSION_CODES_BASE=1;";
    localObject = (String)localObject + "MODEL=" + Build.MODEL + ";";
    localObject = (String)localObject + "SDK=" + Build.VERSION.SDK_INT + ";";
    localObject = (String)localObject + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    localObject = (String)localObject + "DEVICE=" + Build.DEVICE + ";";
    localObject = (String)localObject + "DISPLAY=" + Build.DISPLAY + ";";
    localObject = (String)localObject + "BRAND=" + Build.BRAND + ";";
    localObject = (String)localObject + "BOARD=" + Build.BOARD + ";";
    localObject = (String)localObject + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    localObject = (String)localObject + "ID=" + Build.ID + ";";
    localObject = (String)localObject + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    localObject = (String)localObject + "USER=" + Build.USER + ";";
    String str = Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel();
    localObject = (String)localObject + "CHIP_NAME=" + str + ";";
    str = (String)localObject + paramAVSoProxy.getAndroidCodecInfo();
    localObject = paramAVSoProxy.getContext().getApplicationInfo();
    str = str + "DATADIR=" + ((ApplicationInfo)localObject).dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject = str + "LIBDIR=" + ((ApplicationInfo)localObject).nativeLibraryDir + ";";
      paramAVSoProxy.updateHevcCodecSoDir();
      localObject = (String)localObject + "HEVC_ENC_SO_DIR=" + paramAVSoProxy.getHevcEncSoDir() + ";";
      localObject = (String)localObject + "HEVC_DEC_SO_DIR=" + paramAVSoProxy.getHevcDecSoDir() + ";";
      localObject = (String)localObject + "HARDWARE_DETECT_SO_DIR=" + paramAVSoProxy.getHardwareDetectSoDir() + ";";
      if (AVCoreSystemInfo.getCpuArchitecture() <= 2) {
        break label916;
      }
    }
    label916:
    for (localObject = (String)localObject + "SHARP_VIDEO=1;";; localObject = (String)localObject + "SHARP_VIDEO=2;")
    {
      paramAVSoProxy = paramAVSoProxy.getContext().getResources().getDisplayMetrics();
      int i = Math.max(paramAVSoProxy.widthPixels, paramAVSoProxy.heightPixels);
      int j = Math.min(paramAVSoProxy.widthPixels, paramAVSoProxy.heightPixels);
      paramAVSoProxy = (String)localObject + "SCREEN_WIDTH=" + i + ";";
      paramAVSoProxy = paramAVSoProxy + "SCREEN_HEIGHT=" + j + ";";
      AVCoreLog.printAllUserLog("SDKConfigInfo", "getDeviceInfo, info[" + paramAVSoProxy + "]");
      return paramAVSoProxy;
      localObject = str + "LIBDIR=" + ((ApplicationInfo)localObject).dataDir + "/lib;";
      break;
    }
  }
  
  public String toString()
  {
    return "SDKConfigInfo{logDir=" + this.logDir + ", logFilePrefix=" + this.logFilePrefix + ", processName=" + this.processName + ", isDebugVersion=" + this.isDebugVersion + ", isGrayVersion=" + this.isGrayVersion + ", isPublicVersion=" + this.isPublicVersion + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.data.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */