package com.tencent.TMG.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AVDeviceHelper
{
  private static final char[] DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
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
  
  public static String doRead(Context paramContext)
  {
    return string2Md5("");
  }
  
  public static String getDeviceIdentifier(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(doRead(paramContext));
    localStringBuilder.append(";");
    localStringBuilder.append(getOrigMacAddr(paramContext));
    localStringBuilder.append(";");
    localStringBuilder.append(getOrigAndroidID(paramContext));
    return localStringBuilder.toString();
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
  
  public static String getOrigMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        break label68;
      }
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label42:
        continue;
        label68:
        paramContext = null;
      }
    }
    if (paramContext != null)
    {
      paramContext = paramContext.getMacAddress();
    }
    else
    {
      paramContext = null;
      break label42;
      paramContext = "";
    }
    if (paramContext != null) {
      return string2Md5(paramContext.replaceAll(":", "").toUpperCase());
    }
    return "";
  }
  
  public static String getSimulateIDFA(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(doRead(paramContext));
    localStringBuilder.append(";");
    localStringBuilder.append(getOrigMacAddr(paramContext));
    localStringBuilder.append(";");
    localStringBuilder.append(getOrigAndroidID(paramContext));
    return localStringBuilder.toString();
  }
  
  public static String string2Md5(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.AVDeviceHelper
 * JD-Core Version:    0.7.0.1
 */