package com.tencent.TMG.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AVDeviceHelper
{
  private static final char[] DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    int j = 0;
    char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = j + 1;
      arrayOfChar[j] = DIGITS_LOWER[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = k + 1;
      arrayOfChar[k] = DIGITS_LOWER[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String doRead(Context paramContext)
  {
    return string2Md5("");
  }
  
  public static String getDeviceIdentifier(Context paramContext)
  {
    return doRead(paramContext) + ";" + getOrigMacAddr(paramContext) + ";" + getOrigAndroidID(paramContext);
  }
  
  public static String getOrigAndroidID(Context paramContext)
  {
    String str = "";
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return string2Md5(paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static String getOrigMacAddr(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getConnectionInfo();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getMacAddress();
      }
      catch (Exception paramContext)
      {
        paramContext = "";
        continue;
      }
      if (paramContext == null) {
        break label64;
      }
      return string2Md5(paramContext.replaceAll(":", "").toUpperCase());
      paramContext = null;
      continue;
      paramContext = null;
    }
    label64:
    return "";
  }
  
  public static String getSimulateIDFA(Context paramContext)
  {
    return doRead(paramContext) + ";" + getOrigMacAddr(paramContext) + ";" + getOrigAndroidID(paramContext);
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
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.AVDeviceHelper
 * JD-Core Version:    0.7.0.1
 */