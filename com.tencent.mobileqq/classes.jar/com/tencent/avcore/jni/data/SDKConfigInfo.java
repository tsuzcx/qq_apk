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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PRODUCT=");
    ((StringBuilder)localObject1).append(Build.PRODUCT);
    ((StringBuilder)localObject1).append(";");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("CPU_ABI=");
    ((StringBuilder)localObject2).append(Build.CPU_ABI);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("TAGS=");
    ((StringBuilder)localObject2).append(Build.TAGS);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("VERSION_CODES_BASE=1;");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("MODEL=");
    ((StringBuilder)localObject2).append(Build.MODEL);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("SDK=");
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("VERSION_RELEASE=");
    ((StringBuilder)localObject2).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("DEVICE=");
    ((StringBuilder)localObject2).append(Build.DEVICE);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("DISPLAY=");
    ((StringBuilder)localObject2).append(Build.DISPLAY);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("BRAND=");
    ((StringBuilder)localObject2).append(Build.BRAND);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("BOARD=");
    ((StringBuilder)localObject2).append(Build.BOARD);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("FINGERPRINT=");
    ((StringBuilder)localObject2).append(Build.FINGERPRINT);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("ID=");
    ((StringBuilder)localObject2).append(Build.ID);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("MANUFACTURER=");
    ((StringBuilder)localObject2).append(Build.MANUFACTURER);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("USER=");
    ((StringBuilder)localObject2).append(Build.USER);
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.HARDWARE);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(AVCoreSystemInfo.getCpuModel());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("CHIP_NAME=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(";");
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramAVSoProxy.getAndroidCodecInfo());
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = paramAVSoProxy.getContext().getApplicationInfo();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("DATADIR=");
    ((StringBuilder)localObject3).append(((ApplicationInfo)localObject1).dataDir);
    ((StringBuilder)localObject3).append(";");
    localObject2 = ((StringBuilder)localObject3).toString();
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("LIBDIR=");
      ((StringBuilder)localObject3).append(((ApplicationInfo)localObject1).nativeLibraryDir);
      ((StringBuilder)localObject3).append(";");
      localObject2 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("LIBDIR=");
      ((StringBuilder)localObject3).append(((ApplicationInfo)localObject1).dataDir);
      ((StringBuilder)localObject3).append("/lib;");
      localObject2 = ((StringBuilder)localObject3).toString();
    }
    localObject3 = paramAVSoProxy.getAVTraeSoDir();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject3).length() != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("DOWNLOADED_TRAE_SO_DIR=");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(";");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject3 = paramAVSoProxy.getAVMediaEngineSoDir();
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject3).length() != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("DOWNLOADED_MEDIA_ENGINE_SO_DIR=");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(";");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    paramAVSoProxy.updateHevcCodecSoDir();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("HEVC_ENC_SO_DIR=");
    ((StringBuilder)localObject1).append(paramAVSoProxy.getHevcEncSoDir());
    ((StringBuilder)localObject1).append(";");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("HEVC_DEC_SO_DIR=");
    ((StringBuilder)localObject2).append(paramAVSoProxy.getHevcDecSoDir());
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("HARDWARE_DETECT_SO_DIR=");
    ((StringBuilder)localObject2).append(paramAVSoProxy.getHardwareDetectSoDir());
    ((StringBuilder)localObject2).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (AVCoreSystemInfo.getCpuArchitecture() > 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("SHARP_VIDEO=1;");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("SHARP_VIDEO=2;");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    paramAVSoProxy = paramAVSoProxy.getContext().getResources().getDisplayMetrics();
    int i = Math.max(paramAVSoProxy.widthPixels, paramAVSoProxy.heightPixels);
    int j = Math.min(paramAVSoProxy.widthPixels, paramAVSoProxy.heightPixels);
    paramAVSoProxy = new StringBuilder();
    paramAVSoProxy.append((String)localObject1);
    paramAVSoProxy.append("SCREEN_WIDTH=");
    paramAVSoProxy.append(i);
    paramAVSoProxy.append(";");
    paramAVSoProxy = paramAVSoProxy.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramAVSoProxy);
    ((StringBuilder)localObject1).append("SCREEN_HEIGHT=");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(";");
    paramAVSoProxy = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDeviceInfo, info[");
    ((StringBuilder)localObject1).append(paramAVSoProxy);
    ((StringBuilder)localObject1).append("]");
    AVCoreLog.printAllUserLog("SDKConfigInfo", ((StringBuilder)localObject1).toString());
    return paramAVSoProxy;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDKConfigInfo{logDir=");
    localStringBuilder.append(this.logDir);
    localStringBuilder.append(", logFilePrefix=");
    localStringBuilder.append(this.logFilePrefix);
    localStringBuilder.append(", processName=");
    localStringBuilder.append(this.processName);
    localStringBuilder.append(", isDebugVersion=");
    localStringBuilder.append(this.isDebugVersion);
    localStringBuilder.append(", isGrayVersion=");
    localStringBuilder.append(this.isGrayVersion);
    localStringBuilder.append(", isPublicVersion=");
    localStringBuilder.append(this.isPublicVersion);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.data.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */