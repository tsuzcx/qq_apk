package com.tencent.imsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.manager.BaseManager;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Pattern;

public class SystemUtil
{
  private static final String DEVICE_ID = "DeviceID";
  private static final String DEVICE_INFO = "DeviceInfo";
  private static final String TAG = "SystemUtil";
  private static long lastMemCheckTimeStamps = 0L;
  private static int lastMemUsage = 0;
  private static boolean mFirstTimeRun = true;
  private static CpuUsageMeasurer sCpuUsageMeasurer;
  private static boolean sIsLoadLibrarySuccess = false;
  private static boolean sRunningMemCheck = false;
  
  public static float getAppCpuUsage()
  {
    return getProcessCPURate()[0] / 10 / 100.0F;
  }
  
  public static float getAppMemory()
  {
    if ((!sRunningMemCheck) && ((lastMemCheckTimeStamps == 0L) || (BaseManager.getInstance().getTimeTick() - lastMemCheckTimeStamps >= 15000L)))
    {
      sRunningMemCheck = true;
      AsyncTask.execute(new SystemUtil.1());
    }
    for (int i = lastMemUsage;; i = lastMemUsage) {
      return i;
    }
  }
  
  public static String getDeviceID()
  {
    Object localObject1 = IMContext.getInstance().getApplicationContext();
    if (localObject1 == null) {
      return "";
    }
    Object localObject2 = ((Context)localObject1).getSharedPreferences("DeviceInfo", 0);
    boolean bool = ((SharedPreferences)localObject2).contains("DeviceID");
    int i = 1;
    if (!bool)
    {
      localObject1 = UUID.randomUUID().toString();
    }
    else
    {
      localObject1 = ((SharedPreferences)localObject2).getString("DeviceID", "");
      if ((Pattern.matches("\\w{8}(-\\w{4}){3}-\\w{12}", (CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        i = 0;
      } else {
        localObject1 = UUID.randomUUID().toString();
      }
    }
    if (i != 0)
    {
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putString("DeviceID", (String)localObject1);
      ((SharedPreferences.Editor)localObject2).apply();
    }
    return localObject1;
  }
  
  public static String getDeviceType()
  {
    return Build.MODEL;
  }
  
  public static int getInstanceType()
  {
    String str = Build.MANUFACTURER;
    if (isBrandXiaoMi()) {
      return 2000;
    }
    if (isBrandHuawei()) {
      return 2001;
    }
    if (isBrandMeizu()) {
      return 2003;
    }
    if (isBrandOppo()) {
      return 2004;
    }
    if (isBrandVivo()) {
      return 2005;
    }
    return 2002;
  }
  
  static int[] getProcessCPURate()
  {
    if (sCpuUsageMeasurer == null) {
      sCpuUsageMeasurer = new CpuUsageMeasurer();
    }
    if (mFirstTimeRun)
    {
      mFirstTimeRun = false;
      sCpuUsageMeasurer.getCpuUsage();
      return new int[] { 0, 0 };
    }
    return sCpuUsageMeasurer.getCpuUsage();
  }
  
  public static String getSDKInitPath()
  {
    Object localObject = IMContext.getInstance().getApplicationContext();
    if (localObject == null) {
      return "";
    }
    localObject = ((Context)localObject).getFilesDir().toString();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK Init Path: ");
    localStringBuilder.append((String)localObject);
    IMLog.v(str, localStringBuilder.toString());
    return localObject;
  }
  
  public static String getSDKLogPath()
  {
    Object localObject3 = IMContext.getInstance().getApplicationContext();
    if (localObject3 == null) {
      return "";
    }
    Object localObject1 = ((Context)localObject3).getExternalFilesDir(null);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/sdcard/Android/data/");
      ((StringBuilder)localObject1).append(((Context)localObject3).getPackageName());
      ((StringBuilder)localObject1).append("/log/tencent/imsdk");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("log");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("tencent");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("imsdk");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = localObject2;
    if (!((File)localObject2).exists())
    {
      localObject1 = localObject2;
      if (!((File)localObject2).mkdirs())
      {
        localObject1 = ((Context)localObject3).getFilesDir();
        IMLog.e(TAG, "create log folder failed");
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append("/");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = TAG;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("SDK LOG Path: ");
    ((StringBuilder)localObject3).append((String)localObject1);
    IMLog.v((String)localObject2, ((StringBuilder)localObject3).toString());
    return localObject1;
  }
  
  public static float getSysCpuUsage()
  {
    return getProcessCPURate()[1] / 10 / 100.0F;
  }
  
  public static String getSystemVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  private static boolean isBrandHuawei()
  {
    return ("huawei".equalsIgnoreCase(Build.BRAND)) || ("huawei".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  private static boolean isBrandMeizu()
  {
    return ("meizu".equalsIgnoreCase(Build.BRAND)) || ("meizu".equalsIgnoreCase(Build.MANUFACTURER)) || ("22c4185e".equalsIgnoreCase(Build.BRAND));
  }
  
  private static boolean isBrandOppo()
  {
    return ("oppo".equalsIgnoreCase(Build.BRAND)) || ("oppo".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  private static boolean isBrandVivo()
  {
    return ("vivo".equalsIgnoreCase(Build.BRAND)) || ("vivo".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  private static boolean isBrandXiaoMi()
  {
    return ("xiaomi".equalsIgnoreCase(Build.BRAND)) || ("xiaomi".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  public static boolean isLibraryLoaded()
  {
    return sIsLoadLibrarySuccess;
  }
  
  public static boolean loadIMLibrary()
  {
    return loadIMLibrary(null);
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  public static boolean loadIMLibrary(String paramString)
  {
    if (sIsLoadLibrarySuccess) {
      return true;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("libImSDK.so");
        paramString = ((StringBuilder)localObject).toString();
        System.load(paramString);
        sIsLoadLibrarySuccess = true;
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("system load so library success: ");
        localStringBuilder.append(paramString);
        IMLog.i((String)localObject, localStringBuilder.toString());
      }
      else
      {
        System.loadLibrary("ImSDK");
        sIsLoadLibrarySuccess = true;
        IMLog.i(TAG, "system load so library success, libImSDK.so");
      }
    }
    catch (Exception paramString)
    {
      sIsLoadLibrarySuccess = false;
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("system load so library failed, ");
      localStringBuilder.append(paramString.getMessage());
      Log.e((String)localObject, localStringBuilder.toString());
    }
    catch (UnsatisfiedLinkError paramString)
    {
      sIsLoadLibrarySuccess = false;
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("system load so library failed, ");
      localStringBuilder.append(paramString.getMessage());
      Log.e((String)localObject, localStringBuilder.toString());
    }
    return sIsLoadLibrarySuccess;
  }
  
  public static String md5(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      int j = arrayOfByte.length;
      int i = 0;
      paramString = "";
      while (i < j)
      {
        Object localObject2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        Object localObject1 = localObject2;
        if (((String)localObject2).length() == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append((String)localObject1);
        paramString = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.SystemUtil
 * JD-Core Version:    0.7.0.1
 */