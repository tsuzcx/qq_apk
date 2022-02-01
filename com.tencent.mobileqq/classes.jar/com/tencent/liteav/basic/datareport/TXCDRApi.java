package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi
{
  private static final char[] DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int NETWORK_TYPE_2G = 4;
  static final int NETWORK_TYPE_3G = 3;
  static final int NETWORK_TYPE_4G = 2;
  static final int NETWORK_TYPE_UNKNOWN = 255;
  static final int NETWORK_TYPE_WIFI = 1;
  private static final String TAG = "TXCDRApi";
  private static String g_simulate_idfa = "";
  static boolean initRpt = false;
  private static String mAppName = "";
  private static String mDevId = "";
  private static String mDevType = "";
  private static String mDevUUID = "";
  private static String mNetType = "";
  private static String mSysVersion = "";
  
  static
  {
    f.f();
    nativeInitDataReport();
  }
  
  public static void InitEvent(Context paramContext, String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo)
  {
    setCommonInfo(paramContext);
    if (paramString == null) {
      return;
    }
    nativeInitEventInternal(paramString, paramInt1, paramInt2, paramTXCDRExtInfo);
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length << 1];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = j + 1;
      char[] arrayOfChar2 = DIGITS_LOWER;
      arrayOfChar1[j] = arrayOfChar2[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = k + 1;
      arrayOfChar1[k] = arrayOfChar2[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static String getApplicationNameByPackageName(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label25:
      break label25;
    }
    return "";
  }
  
  public static String getDevUUID(Context paramContext, String paramString)
  {
    return getSimulateIDFA(paramContext);
  }
  
  public static int getNetworkType(Context paramContext)
  {
    int i = 255;
    if (paramContext == null) {
      return 255;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 255;
      }
      if (((NetworkInfo)localObject).getType() == 1) {
        return 1;
      }
      if (((NetworkInfo)localObject).getType() == 0)
      {
        i = 2;
        try
        {
          int j = paramContext.getNetworkType();
          switch (j)
          {
          case 13: 
          default: 
            return 2;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
            return 3;
          }
          return 4;
        }
        catch (Exception paramContext)
        {
          TXCLog.e("TXCDRApi", "TXCDRApi: get network type fail, exception occurred.", paramContext);
        }
      }
      return i;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCDRApi", "getActiveNetworkInfo exception:", paramContext);
    }
    return 255;
  }
  
  public static String getOrigAndroidID(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    catch (Throwable paramContext)
    {
      label13:
      break label13;
    }
    paramContext = "";
    return string2Md5(paramContext);
  }
  
  private static String getPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCDRApi", "get package name failed.", paramContext);
    }
    return "";
  }
  
  public static String getSimulateIDFA(Context paramContext)
  {
    Object localObject1 = g_simulate_idfa;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      return g_simulate_idfa;
    }
    Object localObject3 = null;
    File localFile = paramContext.getExternalFilesDir(null);
    if (localFile == null)
    {
      TXCLog.e("TXCDRApi", "getSimulateIDFA sdcardDir is null");
      return g_simulate_idfa;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.tencent.liteav.dev_uuid", 0);
    String str2 = "";
    String str1 = localSharedPreferences.getString("com.tencent.liteav.key_dev_uuid", "");
    int i;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject1).append("/txrtmp/spuid");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (((File)localObject1).exists())
      {
        FileInputStream localFileInputStream = new FileInputStream((File)localObject1);
        i = localFileInputStream.available();
        if (i > 0)
        {
          localObject1 = new byte[i];
          localFileInputStream.read((byte[])localObject1);
          localObject1 = new String((byte[])localObject1, "UTF-8");
        }
        else
        {
          localObject1 = null;
        }
        try
        {
          localFileInputStream.close();
        }
        catch (Exception localException1)
        {
          break label201;
        }
      }
      else
      {
        localObject1 = null;
      }
    }
    catch (Exception localException2)
    {
      localObject1 = null;
      label201:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read UUID from file failed! reason: ");
      localStringBuilder.append(localException2.getMessage());
      TXCLog.e("TXCDRApi", localStringBuilder.toString());
    }
    Object localObject2;
    if ((str1 != null) && (str1.length() > 0))
    {
      localObject2 = str1;
    }
    else
    {
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((String)localObject1).length() > 0) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject2 != null)
    {
      localObject3 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      long l1 = System.currentTimeMillis();
      long l2 = TXCTimeUtil.getTimeTick();
      localObject2 = f.c(paramContext);
      i = 5;
      paramContext = str2;
      while (i >= 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramContext);
        ((StringBuilder)localObject3).append(String.format("%02x", new Object[] { Byte.valueOf((byte)(int)(l1 >> i * 8 & 0xFF)) }));
        paramContext = ((StringBuilder)localObject3).toString();
        i -= 1;
      }
      i = 3;
      while (i >= 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramContext);
        ((StringBuilder)localObject3).append(String.format("%02x", new Object[] { Byte.valueOf((byte)(int)(l2 >> i * 8 & 0xFF)) }));
        paramContext = ((StringBuilder)localObject3).toString();
        i -= 1;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext);
      paramContext = new StringBuilder();
      paramContext.append((String)localObject2);
      paramContext.append(UUID.randomUUID().toString());
      ((StringBuilder)localObject3).append(string2Md5(paramContext.toString()));
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    g_simulate_idfa = (String)localObject3;
    paramContext = new StringBuilder();
    paramContext.append("UUID:");
    paramContext.append(g_simulate_idfa);
    TXCLog.i("TXCDRApi", paramContext.toString());
    if ((localObject1 == null) || (!((String)localObject1).equals(localObject3))) {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(localFile.getAbsolutePath());
        paramContext.append("/txrtmp");
        paramContext = new File(paramContext.toString());
        if (!paramContext.exists()) {
          paramContext.mkdir();
        }
        paramContext = new StringBuilder();
        paramContext.append(localFile.getAbsolutePath());
        paramContext.append("/txrtmp/spuid");
        paramContext = new File(paramContext.toString());
        if (!paramContext.exists()) {
          paramContext.createNewFile();
        }
        paramContext = new FileOutputStream(paramContext);
        paramContext.write(((String)localObject3).getBytes());
        paramContext.close();
      }
      catch (Exception paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("write UUID to file failed! reason: ");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        TXCLog.e("TXCDRApi", ((StringBuilder)localObject1).toString());
      }
    }
    if ((str1 == null) || (!str1.equals(localObject3)))
    {
      paramContext = localSharedPreferences.edit();
      paramContext.putString("com.tencent.liteav.key_dev_uuid", (String)localObject3);
      paramContext.commit();
    }
    return g_simulate_idfa;
  }
  
  public static int getStatusReportInterval()
  {
    return nativeGetStatusReportInterval();
  }
  
  public static void initCrashReport(Context paramContext)
  {
    try
    {
      try
      {
        if ((!initRpt) && (paramContext != null))
        {
          String str = TXCCommonUtil.getSDKVersionStr();
          if (str != null)
          {
            paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
            paramContext.putString("8e50744bf0", str);
            paramContext.commit();
            initRpt = true;
          }
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCDRApi", "init crash report failed.", paramContext);
    }
  }
  
  public static native int nativeGetStatusReportInterval();
  
  private static native void nativeInitDataReport();
  
  private static native void nativeInitEventInternal(String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo);
  
  public static native void nativeReportAVRoomEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3);
  
  private static native void nativeReportDAUInterval(int paramInt1, int paramInt2, String paramString);
  
  public static native void nativeReportEvent(String paramString, int paramInt);
  
  public static native void nativeReportEvent40003(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  public static native void nativeSetCommonValue(String paramString1, String paramString2);
  
  private static native void nativeSetEventValueInterval(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static native void nativeUninitDataReport();
  
  public static void reportAVRoomEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    nativeReportAVRoomEvent(paramInt1, paramLong, paramString1, paramInt2, paramInt3, paramString2, paramString3);
  }
  
  public static void reportEvent40003(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    nativeReportEvent40003(paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public static void setCommonInfo(Context paramContext)
  {
    mDevType = Build.MODEL;
    mNetType = Integer.toString(getNetworkType(paramContext));
    if (mDevId.isEmpty()) {
      mDevId = getSimulateIDFA(paramContext);
    }
    if (mDevUUID.isEmpty()) {
      mDevUUID = getDevUUID(paramContext, mDevId);
    }
    String str = getPackageName(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApplicationNameByPackageName(paramContext, str));
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    mAppName = localStringBuilder.toString();
    mSysVersion = String.valueOf(Build.VERSION.SDK_INT);
    txSetCommonInfo();
  }
  
  public static String string2Md5(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
    }
    catch (Exception paramString)
    {
      TXCLog.e("TXCDRApi", "string2Md5 failed.", paramString);
      paramString = "";
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String txCreateToken()
  {
    return UUID.randomUUID().toString();
  }
  
  public static void txReportDAU(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt, 0, "");
  }
  
  public static void txReportDAU(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt1, paramInt2, paramString);
  }
  
  public static void txSetAppVersion(String paramString)
  {
    if (paramString != null) {
      nativeSetCommonValue(a.k, paramString);
    }
  }
  
  public static void txSetCommonInfo()
  {
    if (mDevType != null) {
      nativeSetCommonValue(a.f, mDevType);
    }
    if (mNetType != null) {
      nativeSetCommonValue(a.g, mNetType);
    }
    if (mDevId != null) {
      nativeSetCommonValue(a.h, mDevId);
    }
    if (mDevUUID != null) {
      nativeSetCommonValue(a.i, mDevUUID);
    }
    if (mAppName != null) {
      nativeSetCommonValue(a.j, mAppName);
    }
    if (mSysVersion != null) {
      nativeSetCommonValue(a.l, mSysVersion);
    }
  }
  
  public static void txSetEventIntValue(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, localStringBuilder.toString());
  }
  
  public static void txSetEventValue(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.datareport.TXCDRApi
 * JD-Core Version:    0.7.0.1
 */